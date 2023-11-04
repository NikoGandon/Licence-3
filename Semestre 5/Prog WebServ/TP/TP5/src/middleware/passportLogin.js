const passport = require("passport");
const LocalStrategy = require("passport-local").Strategy;

const db = require("../routes/config");
const { comparePassword } = require("../routes/Users/AuthHelper");

passport.use('localLogin',
  new LocalStrategy((username, password, done) => {
    db.query(
      "SELECT * FROM utilisateurs WHERE username = ?",
      [username],
      (err, result) => {
        if (err) {
          return done(err);
        }
        if (!result || result.length === 0) {
          return done(null, false, { message: "Utilisateur inexistant" });
        }

        const user = result[0];

        if (!comparePassword(password, user.password)) {
          return done(null, false, { message: "Mot de passe incorrect" });
        }

        db.query(
          "SELECT * FROM admin WHERE id = ?",
          [user.id],
          (adminErr, result) => {
            if (adminErr) {
              return done(adminErr);
            }
            if (result.length > 0) {
              user.isAdmin = true;
            } else {
              user.isAdmin = false;
            }
            return done(null, user);
          }
        );
      }
    );
  })
);

passport.serializeUser((user, done) => {
  done(null, user.id);
});

passport.deserializeUser((id, done) => {
  db.query("SELECT * FROM utilisateurs WHERE id = ?", [id], (err, result) => {
    if (err) {
      return done(err);
    }

    const user = result[0];
    return done(null, user);
  });
});

module.exports = passport;
