const {DataTypes} = require('sequelize');
const sequelize = require('../routes/config');

const User = sequelize.define('utilisateur', {
    id: {
        type: DataTypes.INTEGER,
        autoIncrement: true,
        primaryKey: true
    },
    username: {
        type: DataTypes.STRING,
        allowNull: false,
        unique: true
    },
    password: {
        type: DataTypes.STRING,
        allowNull: false
    }
}, {
    tableName: 'utilisateur'
});

User.sync();

module.exports = User;