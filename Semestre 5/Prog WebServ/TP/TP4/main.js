const express = require('express')
const app = express()
const port = 3000
const bodyParse = require('body-parser')
const multer = require('multer');

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


app.use(bodyParse.json())

app.get('/', (req, res) => {res.send("HW")})
app.listen(port, () => {
	console.log("server listening @ port")
})

app.get('/Login/:usrname/:pwd', (req, res) => {
	res.send("Login")
})

app.get('/Register/:email/:pwd', (req, res) => {
	res.send("Register")
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

app.post('/upload', upload.single('file'), (req, res) => {
    console.log('Fichier téléchargé :', req.file);	
	console.log('chemin :', req.file.path);
    res.send('Fichier téléchargé avec succès !');
});