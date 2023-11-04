require("dotenv").config();
const express = require("express");
const app = express();
const passport = require("../../middleware/passportLogin");
const { createToken } = require("../../middleware/AuthToken");

app.post(
  "/login",
  passport.authenticate("localLogin", { session: false }),
  (req, res, next) => {
    const user = req.user;
    const token = createToken(user);
    res.json({ token });
  }
);

module.exports = app;