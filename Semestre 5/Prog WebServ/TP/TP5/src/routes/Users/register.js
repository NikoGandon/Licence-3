const express = require("express");
const app = express();
const passport = require("../../middleware/passportRegister");

app.post("/register", (req, res, next) => {
  passport.authenticate("localRegister", (err, user, info) => {
    if (err) {
      console.log(err);
      return next(err);
    }
    if (!user) {
      console.log(info);
      return res.status(401).json({ message: info.message });
    }
    res.redirect(307, "/login");
  })(req, res, next);
});

module.exports = app;
