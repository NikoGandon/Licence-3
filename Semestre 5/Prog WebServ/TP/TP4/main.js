require('dotenv').config();
const express = require('express')
const app = express()
const port = process.env.PORT
const bodyParse = require('body-parser')
const multer = require('multer');
const passport = require('passport');
const LocalStrategy = require('passport-local').Strategy;
const jwt = require('jsonwebtoken');
const crypto = require('crypto');
const mysql = require('mysql2');
const bcrypt = require('bcrypt');

const secretKey = process.env.ACCESS_TOKEN;

app.use(bodyParse.json())
app.use(passport.initialize());

passport.use(new LocalStrategy((username, password, done) => {
	if (username === "admin" && password === "admin") {
		return done(null, {username});
	} else {
		return done(null, false, {message: 'Incorrect username or password.'});
	}
}));

app.post('/login', (req, res) => {
	passport.authenticate('local', { session: false }, (err, user) => {
		if (err) {
		  return res.status(500).json({ message: "Erreur d'authentification : " + err });
		}
	
		if (!user) {
		  return res.status(401).json({ message: 'Authentification échouée' });
		}

		const token = jwt.sign({ username: user.username }, secretKey, { expiresIn: '1h' });
	
		return res.json({ token });
	  })(req, res);
})


app.post('/signin', (req, res) => {
	const {username, password} = req.body;
	if ()
})
  

const storage = multer.diskStorage({
    destination: (req, file, callback) => {
      callback(null, './uploads');
    },
    filename: (req, file, callback) => {
      const filename = Date.now() + '-' + file.originalname;
      callback(null, filename);
    },
});

const upload = multer({ storage: storage });



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

app.post('/profil', (req, res) => {
		let maVar = "test";
		function concatener(parametre) {
			maVar = maVar + parametre;
			return maVar;
		}
		const resultat = concatener(req.params.profil);
		res.send(resultat);
		
});

app.post('/login', loginRouter);
app.post('/signup', signupRouter);

app.post('/upload', storageRouter);

