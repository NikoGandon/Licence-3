require('dotenv').config();

const mysql = require('mysql2');
const {Sequelize, DataType} = require('sequelize');
/*
const db = mysql.createConnection({
    host: process.env.DB_HOST,
    user: process.env.DB_USER,
    password: process.env.DB_PASSWORD,
    database : process.env.DB_NAME
});

db.connect((err) => {
    if (err) {
        throw err;
    }
    console.log('Connecté à la base MySQL');
});*/

const db = new Sequelize(process.env.DB_NAME, process.env.DB_USER, process.env.DB_PASSWORD, {
    host: process.env.DB_HOST,
    dialect: 'mysql'
});

db.authenticate().then(() => {
    console.log('Connecté à la base MySQL');
}).catch(err => {
    console.error('Impossible de se connecter à la base de données:', err);
});

module.exports = db;