const express = require("express");
const app = express();
const jwt = require("jsonwebtoken");
const db = require("../config");
const { hashPassword } = require("./AuthHelper");

const User = require("../../Models/User");

const secretKey = process.env.ACCESS_TOKEN;

/*function createToken(user) {
  return jwt.sign(
    {
      id: user.id,
      username: user.username,
      admin: user.isAdmin ? true : false
    },
    secretKey,
    { expiresIn: "1h" }
  );
}*/

app.post("/signup", async (req, res, next) => {
  const { username, password } = req.body;
  try{
    const existingUser = await User.findOne({ where: { username: username } }); 
      if (existingUser) {
      return res.status(400).json({ message: "Username already exists" });
    }
    const hashedPassword = hashPassword(password);
    const newUser = User.create({
      username: username,
      password: hashedPassword,
    });

    res.redirect(307, "/login");
  } catch (error) {
    res.status(500).json({ message: "Signup failed" });
  }
});

module.exports = app;
