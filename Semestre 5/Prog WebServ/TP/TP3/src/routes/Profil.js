const express = require("express");
const app = express();
const bodyParser = require("body-parser");

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));


app.post("/profil", (req, res) => {
    let maVar = "test";
    function concatener(parametre) {
      maVar = maVar + parametre;
      return maVar;
    }
    const resultat = concatener(req.body.profil);
    res.send("resultat de la concaténation : " + resultat);
});

module.exports = app;