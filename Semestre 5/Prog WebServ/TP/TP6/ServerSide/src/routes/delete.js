const express = require("express");
const app = express();

app.delete("/delete", (req, res) => {
  var variable = 10;
  const avant = "valeur de la variable avant : " + variable;
  variable = undefined;
  const apres = "valeur de la variable après : " + variable;
  res.send(avant + "\n" + apres);
});

module.exports = app;
