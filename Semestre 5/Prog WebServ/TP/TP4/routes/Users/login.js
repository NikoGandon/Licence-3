require("dotenv").config();
const express = require("express");
const app = express();
const jwt = require("jsonwebtoken");
const passport = require("./passportRoute");

const secretKey = process.env.ACCESS_TOKEN;

function createToken(user) {
  return jwt.sign(
    {
      id: user.id,
      username: user.username,
      admin: user.isAdmin ? true : false,
    },
    secretKey,
    { expiresIn: process.env.DURATION_TOKEN }
  );
}

app.post(
  "/login",
  passport.authenticate("local", { session: false }),
  (req, res, next) => {
    const user = req.user;
    const token = createToken(user);
    res.json({ token });
  }
);

module.exports = app;
