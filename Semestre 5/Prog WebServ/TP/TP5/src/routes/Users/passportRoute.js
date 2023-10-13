const passport = require('passport');
const LocalStrategy = require('passport-local').Strategy;
const User = require('../../Models/User');
const db = require('../config');
const { comparePassword } = require('./AuthHelper');

passport.use(new LocalStrategy(async (username, password, done) => {
    try{
        const user = await User.findOne({ where: { username: username } });
    
        if (!user) {
            return done(null, false, { message: 'Incorrect username.' });
        }
    
        const passwordMatch = await comparePassword(password, user.password);
        if (!passwordMatch) {
            return done(null, false, { message: 'Incorrect password.' });
        }
    
        return done(null, user);
    }
    catch (error) {
        return done(error);
}
}
));



passport.serializeUser((user, done) => {
    done(null, user.id);
});

passport.deserializeUser((id, done) => {
    db.query('SELECT * FROM utilisateurs WHERE id = ?', [id], (err, result) => {
        if (err) {
            return done(err);
        }

        const user = result[0];
        return done(null, user);
    });
});

module.exports = passport;