const express = require("express");
const app = express();

app.get("/Hey", (req, res) => {
    res.send("Hey");
});

module.exports = app;