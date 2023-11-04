require('dotenv').config();
const express = require('express')
const bodyParser = require('body-parser')
const app = express()
const port = process.env.PORT


const storageRouter = require('./routes/storage');
const registerRouter = require('./routes/Users/register');
const loginRouter = require('./routes/Users/login');
const deleteRouter = require('./routes/delete');

const checkToken = require('./middleware/AuthToken');

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());


app.get('/', (req, res) => {res.send("HW")})
app.listen(port, () => {
	console.log("server listening @ port")
})


app.get('/Hey', (req, res) => {res.send("Hey")})
app.get('/Calcul/:num1/:num2/:operateur', (req, res) => {
	
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
	} else if (operateur === "/") {
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

app.post('/constante', (req, res) => {
	const {name, value} = req.body;

	const constante = {}
	if (constante[name]){
		res.status(400).send("La constante existe déjà");
	}	
	else  {
		constante[name] = value;
		res.status(200).send("La constante a bien été ajoutée " + constante[name]);
	}
});

app.post('/profil', checkToken.verifyToken,(req, res) => {

		let maVar = "test";
		function concatener(parametre) {
			maVar = maVar + parametre;
			return maVar;
		}
		const resultat = concatener(req.params.profil);
		res.send(resultat);
		
});

app.post('/login', loginRouter);
app.post('/register', registerRouter);
app.post('/upload', checkToken.verifyAdminToken, storageRouter);
app.delete('/delete', checkToken.verifyAdminToken, deleteRouter);
