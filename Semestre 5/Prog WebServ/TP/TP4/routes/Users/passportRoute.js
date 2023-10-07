const passport = require('passport');
const LocalStrategy = require('passport-local').Strategy;

const db = require('../config');
const { comparePassword } = require('./AuthHelper');

passport.use(new LocalStrategy((username, password, done) => {
    db.query('SELECT * FROM utilisateur WHERE username = ?', [username], (err, result) => {
        if (err) {
            return done(err);
        }
        if (!result || result.length === 0) {
            return done(null, false, { message: 'Utilisateur inexistant' });
        }

        const user = result[0];
       
        if (comparePassword(password, user.password)) {
            return done(null, user);
        }
        
        return done(null, false, { message: 'Mot de passe incorrect' });
        
    })
}
));



passport.serializeUser((user, done) => {
    done(null, user.id);
});

passport.deserializeUser((id, done) => {
    db.query('SELECT * FROM utilisateur WHERE id = ?', [id], (err, result) => {
        if (err) {
            return done(err);
        }

        const user = result[0];
        return done(null, user);
    });
});

module.exports = passport;