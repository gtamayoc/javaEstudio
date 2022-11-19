var data = require('../connect-db/user');
var errors = require('../connect-db/errors');
var fs = require('fs'),
    readline = require('readline');

let archivoo = fs.readFileSync('data_base/user1.json');
let usuarios = JSON.parse(archivoo);

let users = usuarios.usuarios;
let responseError = errors.responseError; 
let responseError1 = errors.responseError1;
let user = data.user;
  
module.exports = {
    users,
    responseError,
    responseError1,
    user
};
