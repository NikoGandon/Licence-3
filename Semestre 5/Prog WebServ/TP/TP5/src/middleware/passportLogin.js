const passport = require("passport");
const LocalStrategy = require("passport-local").Strategy;

const db = require("../routes/config");
const { comparePassword } = require("../routes/Users/AuthHelper");
const User = require("../Models/User.model");

passport.use(
  "localLogin",
  new LocalStrategy(async (username, password, done) => {
    try {
      const userExisting = await User.findOne({
        where: { username: username },
      });
      if (!userExisting) {
        return done(null, false, { message: "Utilisateur inexistant" });
      }
      const user = userExisting.dataValues;
      if (!comparePassword(password, user.password)) {
        return done(null, false, { message: "Mot de passe incorrect" });
      }
      const admin = await db.query("SELECT * FROM admin WHERE id = :id", {
        replacements: { id: user.id },
        type: db.QueryTypes.SELECT,
      });
      user.isAdmin = false;
      if (admin.length > 0) {
        user.isAdmin = true;
      }
      return done(null, user);
    } catch (error) {
      return done(error);
    }
  })
);

passport.serializeUser((user, done) => {
  done(null, user.id);
});

passport.deserializeUser(async (id, done) => {
  try {
    const user = await User.findOne({ where: { id: id } });
    return done(null, user);
  } catch (error) {
    return done(error);
  }
});

module.exports = passport;
