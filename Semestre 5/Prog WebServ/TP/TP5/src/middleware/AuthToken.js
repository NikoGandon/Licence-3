require("dotenv").config();
const jwt = require("jsonwebtoken");
const secretKey = process.env.ACCESS_TOKEN;

function verifyToken(req, res, next){
    const token = req.headers.authorization.split(" ")[1];

    if (!token){
        return res.status(401).json({message: "Token inexistant"});
    }

    try {
        const decoded = jwt.verify(token, secretKey);
        req.user = decoded;
        next();
    }
    catch (err) {
        return res.status(401).json({message: "Token invalide"});
    }
}

function verifyAdminToken(req, res, next){
    const token = req.headers.authorization.split(" ")[1];

    if (!token){
        return res.status(401).json({message: "Token inexistant"});
    }

    try {
        const decoded = jwt.verify(token, secretKey);
        req.user = decoded;
        if (!req.user.admin){
            return res.status(401).json({message: "Token invalide"});
        }
        next();
    }
    catch (err) {
        return res.status(401).json({message: "Token invalide"});
    }
}

module.exports = { verifyToken, verifyAdminToken };