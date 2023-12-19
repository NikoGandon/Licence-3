const {DataTypes} = require('sequelize');
const sequelize = require('../routes/config');

const Admin = sequelize.define('admin', {
    id: {
        type: DataTypes.INTEGER,
        autoIncrement: true,
        primaryKey: true
    }
}, {
    tableName: 'admin',
    timestamps: false   
});

Admin.sync();

module.exports = Admin;