const express = require('express');
const app = express();
const bodyParse = require('body-parser')
const multer = require('multer');

app.use(bodyParse.json())

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

app.post('/file', upload.single('file'), (req, res) => {
    console.log('Fichier téléchargé :', req.file);	
	console.log('chemin :', req.file.path);
    res.send('Fichier téléchargé avec succès !');
});

module.exports = app;