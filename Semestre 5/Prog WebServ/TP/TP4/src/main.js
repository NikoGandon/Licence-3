require("dotenv").config();
const express = require("express");
const app = express();
const port = process.env.PORT;
const bodyParser = require("body-parser"); 

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

const Hey = require("./routes/Hey");
const Profil = require("./routes/Profil");
const Calcul = require("./routes/Calcul");
const Constante = require("./routes/Constante");
const Storage = require("./routes/storage");
const Register = require("./routes/Users/register");
const Login = require("./routes/Users/login");
const Delete = require("./routes/Delete");

const checkToken = require("./middleware/AuthToken");

app.use((req, res, next) => {
  res.header('Access-Control-Allow-Origin', '*');
  res.header('Access-Control-Allow-Headers', 'Origin, X-Requested-With, Content-Type, Accept');
  next();
});


app.use((err, req, res, next) => {
  console.error(err.stack);
  res.status(500).send({ error: 'Something went wrong!' });
});


app.listen(port, () => {
  console.log("server listening @ port " + port);
});

app.get("/Hey", Hey);
app.get("/Calcul/:num1/:num2/:operateur", checkToken.verifyToken, Calcul);
app.post("/constante", checkToken.verifyToken, Constante);
app.post("/profil", Profil);
app.post("/login", Login);
app.post("/register", Register);
app.post("/upload", checkToken.verifyAdminToken, Storage);
app.delete("/delete", checkToken.verifyAdminToken, Delete);