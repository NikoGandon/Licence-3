const express = require("express");
const app = express();

app.get("/Hey", (req, res) => {
    res.send("Hey, ceci est le TP 5");
});

module.exports = app;
