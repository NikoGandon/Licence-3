const express = require("express");
const app = express();

app.get("/Hey", (req, res) => {
  res.send({ message: "Hey, ceci est le TP 6" });
});

module.exports = app;
