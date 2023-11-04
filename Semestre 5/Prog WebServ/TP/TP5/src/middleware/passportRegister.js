const passport = require("passport");
const LocalStrategy = require("passport-local").Strategy;

const { hashPassword } = require("../routes/Users/AuthHelper");

const UserModel = require("../Models/User.model");

passport.use(
  "localRegister",
  new LocalStrategy(async(username, password, next) => {
    try {
      const user = await UserModel.findOne({ where: { username: username } });
      if (user) {
        return next(null, false, { message: "Utilisateur déjà existant" });
      }
      const hash = hashPassword(password);
      const newUser = UserModel.create({ username: username, password: hash });
      return next(null, newUser);
    } catch (error) {
      return next(error);
    }
  })
);

module.exports = passport;
