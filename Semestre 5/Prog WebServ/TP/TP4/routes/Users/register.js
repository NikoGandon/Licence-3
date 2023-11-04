const express = require("express");
const app = express();
const passport = require("../../middleware/passportRegister");

app.post("/register", (req, res, next) => {
  try {
    passport.authenticate("localRegister", (err, user, info) => {
      if (err) {
        console.log(err);
        return next(err);
      }
  
      if (!user) {
        return res.status(401).json({ message: info.message });
      }
  
      res.redirect(307, "/login");
  
    })(req, res, next);
  } catch (error) {
    console.log(error);
  }
});

module.exports = app;
