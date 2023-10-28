const express = require("express");
const app = express();
const db = require("../config");
const { hashPassword } = require("./AuthHelper");

app.post("/register", (req, res, next) => {
  const { username, password } = req.body;
  try {
    db.query(
      "SELECT * FROM utilisateurs WHERE username = ?",
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
          "INSERT INTO utilisateurs (username, password) VALUES (?, ?)",
          [username, hash],
          (err, result) => {
            if (err) {
              return next(err);
            }
            res.redirect(307, "/login");
          }
        );
      }
    );
  } catch (err) {
    res.status(500).json({ message: "L'enregistrement de votre compte n'a pas su s'aboutir. Veuillez réessayer ultérieurement." });
  }
});

module.exports = app;
