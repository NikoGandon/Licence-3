const passport = require("passport");
const LocalStrategy = require("passport-local").Strategy;

const db = require("../routes/config");
const { hashPassword } = require("../routes/Users/AuthHelper");

passport.use(
  "localRegister",
  new LocalStrategy((username, password, next) => {
    if (!username || !password ) {
      return next(null, false, {
        message: "Tous les champs ne sont pas remplis.",
      });
    }
    db.query(
      "SELECT * FROM utilisateurs WHERE username = ?",
      [username],
      (err, result) => {
        if (err) {
          return next(err);
        }
        if (result.length > 0) {
          return next(null, false, { message: "Utilisateur déjà existant" });
        }

        const hash = hashPassword(password);

        db.query(
          "INSERT INTO utilisateurs (username, password) VALUES (?, ?)",
          [username, hash],
          (err) => {
            if (err) {
              return next(err);
            }
            return next(null, { username });
          }
        );
      }
    );
  })
);

module.exports = passport;
