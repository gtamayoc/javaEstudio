var fs = require('fs'),
    readline = require('readline');
const { resolve } = require('path');

var data = require('../encrypt/encrypt');

var reader = readline.createInterface({
  input: fs.createReadStream('user.json')
});

reader.on('line', function (line) {
  console.log(line);
});

fs.readFile('user.json', 'utf8', function(err, data) {
  if (err) {
    return console.log(err);
  }

  console.log(data);
});

const registrar = () =>{
    user = "prueba";

    let users = {
      "0":
      {
          "user":"admin",
          "pass":"admin",
          "token": "8a59916c900035e985d1968f154a77796b60a4a9f3f96fe00eb5bc5d8dc659eaedfc93d7219b49bbad12f008c48de979227caac6bbbd6c606751b31432e62b5c",
          "message": "Usuario Valido"
      }
    };


fs.appendFile('user.json', JSON.stringify(users) ,{encoding: 'utf8', flag: 'a'}, (error) =>{
    if (error) throw error;
    console.log(`asd`);
});



};

let datosss = data.generateRandomString(128);

const registrar1 = () =>{
  let users = {
    0:{
      "user":"admin",
      "pass":"admin",
      "token": datosss,
      "message": "Usuario Valido"
    }
  };

  var salto=`,\n`;
fs.appendFile('user.json', salto ,{encoding: 'utf8', flag: 'a'}, (error) =>{
  if (error) throw error;
  console.log(`asd`);
});

fs.appendFile('user.json', JSON.stringify(users) ,{encoding: 'utf8', flag: 'a'}, (error) =>{
  if (error) throw error;
  console.log(`asd`);
});



};


registrar1();

