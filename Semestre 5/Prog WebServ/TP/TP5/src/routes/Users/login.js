require("dotenv").config();
const express = require("express");
const app = express();
const passport = require("../../middleware/passportLogin");
const { createToken } = require("../../middleware/AuthToken");

app.post("/login", (req, res, next) => {
  if (!req.body.username || !req.body.password) {
    return res
      .status(400)
      .json({ message: "Tous les champs ne sont pas remplis." });
  }
  passport.authenticate("localLogin", { session: false }, (err, user, info) => {
    if (err) {
      console.log(err);
      return next(err);
    }

    if (!user) {
      return res.status(401).json({ message: info.message });
    }

    const token = createToken(user);
    res.json({ token });
  })(req, res, next);
});

module.exports = app;
