const passport = require("passport");
const LocalStrategy = require("passport-local").Strategy;

const { comparePassword } = require("../routes/Users/AuthHelper");
const User = require("../Models/User.model");
const Admin = require("../Models/Admin.model");

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

      const admin = await Admin.findOne({ where: { id: user.id } });
      user.isAdmin = false;
      if (admin) {
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
