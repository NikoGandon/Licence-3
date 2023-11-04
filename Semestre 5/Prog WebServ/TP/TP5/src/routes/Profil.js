const express = require("express");
const app = express();

app.post("/profil", (req, res) => {
  let maVar = "test";
  function concatener(parametre) {
    maVar = maVar + parametre;
    return maVar;
  }
  const resultat = concatener(req.params.profil);
  res.send(resultat);
});

module.exports = app;