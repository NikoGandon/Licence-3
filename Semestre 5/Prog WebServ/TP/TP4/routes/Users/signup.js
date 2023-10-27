const express = require("express");
const app = express();
const jwt = require("jsonwebtoken");
const db = require("../config");
const { hashPassword } = require("./AuthHelper");

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

app.post("/signup", (req, res, next) => {
  const { username, password } = req.body;
  db.query(
    "SELECT * FROM utilisateur WHERE username = ?",
    [username],
    (err, result) => {
      if (err) {
        return next(err);
      }

      if (result.length > 0) {
        return res.status(401).json({ message: "Utilisateur deja existant" });
      }

      const hash = hashPassword(password);

      db.query(
        "INSERT INTO utilisateur (username, password) VALUES (?, ?)",
        [username, hash],
        (err, result) => {
          if (err) {
            return next(err);
          }

          const token = createToken({ id: result.insertId, username });
          return res.json({ token });
        }
      );
    }
  );
});

module.exports = app;
