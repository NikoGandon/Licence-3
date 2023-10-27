const express = require("express");
const app = express();


var variable = 10;

app.delete("/delete", (req, res) => {
    //res.write("Valeur de la variable avant : " + variable);
    variable = undefined;
    res.send("Valeur de la variable après : " + variable);
});

module.exports = app;