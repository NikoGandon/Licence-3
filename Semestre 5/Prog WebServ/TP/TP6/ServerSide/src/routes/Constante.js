const express = require("express");
const app = express();

const bodyParser = require("body-parser");
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

let constante = {};

app.post("/constante", (req, res) => {
  const { name, value } = req.body;

  if (constante[name]) {
    res.status(400).send("La constante existe déjà");
  } else {
    constante[name] = value;
    res
      .status(200)
      .send(
        "La constante " +
          name +
          " a bien été ajoutée avec la valeur " +
          constante[name]
      );
  }
});

module.exports = app;
