const express = require("express");
const app = express();
const { hashPassword } = require("./AuthHelper");

const User = require("../../Models/User");

app.post("/register", async (req, res, next) => {
  const { username, password } = req.body;
  try {
    const existingUser = await User.findOne({ where: { username: username } });
    if (existingUser) {
      return res.status(400).json({ message: "Username already exists" });
    }
    const hashedPassword = hashPassword(password);
    User.create({
      username: username,
      password: hashedPassword,
    })
      .then((user) => {
        res.json(user);
      })
      .catch((err) => {
        console.log(err);
        res.status(500).json({ message: "Signup failed" });
      });
  } catch (err) {
    console.log(err);
    res.status(500).json({ message: "Signup failed" });
  }
});

module.exports = app;
