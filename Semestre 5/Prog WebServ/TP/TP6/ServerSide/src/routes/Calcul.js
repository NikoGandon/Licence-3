const express = require("express");
app = express();

app.get("/Calcul/:num1/:num2/:operateur", (req, res) => {
  const num1 = parseInt(req.params.num1);
  const num2 = parseInt(req.params.num2);
  const operateur = req.params.operateur;
  let result = 0;

  if (operateur === "+") {
    result = num1 + num2;
  } else if (operateur === "-") {
    result = num1 - num2;
  } else if (operateur === "*") {
    result = num1 * num2;
  } else if (operateur === "d") {
    if (num2 === 0) {
      res.status(400).send("Division par zéro impossible");
      return;
    }
    result = num1 / num2;
  } else {
    res.status(400).send("Opérateur non pris en charge");
    return;
  }

  res.send("Résultat = " + result);
});

module.exports = app;
