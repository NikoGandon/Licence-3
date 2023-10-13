const {DataTypes} = require('sequelize');
const sequelize = require('../routes/config');

const User = sequelize.define('utilisateurs', {
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
});

const isAdmin = async (id) => {
    const admin = await sequelize.query('SELECT * FROM admin WHERE id = :id', {
        replacements: { id: id },
        type: sequelize.QueryTypes.SELECT
    });
    return admin.length > 0;
}

User.sync();

module.exports = User;