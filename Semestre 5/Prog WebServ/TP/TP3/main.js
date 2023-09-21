const express = require('express')
const app = express()
const port = 3000

app.get('/', (req, res) => {res.send("HW")})
app.listen(port, () => {
	console.log("server listening @ port")
})
app.get('/Hey', (req, res) => {res.send("Hey")})
app.get('/Calcul', (req, res) => {res.send("Un calculateur un matheux")})
app.get('/Calculatrice', (req, res) => {res.send("C'est une pute")})
