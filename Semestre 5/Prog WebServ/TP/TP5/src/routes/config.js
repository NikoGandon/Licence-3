require("dotenv").config();

const { Sequelize } = require("sequelize");

const db = new Sequelize(
  process.env.DB_NAME,
  process.env.DB_USER,
  process.env.DB_PASSWORD,
  {
    host: process.env.DB_HOST,
    dialect: "mysql",
  }
);

db.authenticate()
  .then(() => {
    console.log("Connecté à la base MySQL");
  })
  .catch((err) => {
    console.error("Impossible de se connecter à la base de données:", err);
  });

module.exports = db;
