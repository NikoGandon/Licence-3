const express = require("express");
const app = express();

app.get("/Hey", (req, res) => {
    res.setHeader('Content-Type', 'application/json');

    return res.json({ message : "Hey, ceci est le TP 4"});
});

module.exports = app;