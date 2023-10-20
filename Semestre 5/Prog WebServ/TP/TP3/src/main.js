const express = require("express");
const app = express();
const port = 3000;

const Hey = require("./routes/Hey");
const Profil = require("./routes/Profil");
const File = require("./routes/File");
const Calcul = require("./routes/Calcul");
const Constante = require("./routes/Constante");
const Delete = require("./routes/Delete");

app.listen(port, () => {
  console.log("server listening @ port " + port);
});

app.get("/Hey", Hey);
app.get("/Calcul/:num1/:num2/:operateur", Calcul);
app.post("/constante", Constante);
app.post("/file", File);
app.post("/profil", Profil);
app.delete("/delete", Delete);