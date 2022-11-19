var fs = require('fs'), readline = require('readline');
var reader = readline.createInterface({input: fs.createReadStream('data_base/user.json')});

var DBApi = require('../data_base/write');
var data = require('../connect-db/dataJSON');
var errors = require('../connect-db/errors');
var createToken = require('../encrypt/encrypt');
const { Router, response } = require('express');
const router = Router();

const token = require('crypto').randomBytes(64).toString('hex');


router.get('/api', (req, res) => {    
    res.json(
        {
            "Title": "Hola mundo usando rutas! "
        }
    );
});

router.get('/logint/', (req, res) => { 
        res.json(
            errors.responseError404
            );
});

router.get('/logint/:user&:pass', (req, res) => {
  let name = req.params.user;
  let pass = req.params.pass;
  let users = data.users;
  let response = data.responseError1;
  //i contiene a un usuario
    for (let i in users) {
      //j contien una propiedad de usuario
        for (let j in users[i]) {
           if(users[i]['user'] == name && users[i]['pass'] == pass && users[i]['user']== "admin"){
              response = data.users;
           }else if(users[i]['user'] == name && users[i]['pass'] == pass){
              response = data.users[i];
          }
        }
      }
      res.json(response);
});

router.all('/api/login/', (req, res) => {
    let name = req.query.user;
    let pass = req.query.pass;
    let archivoo = fs.readFileSync('data_base/user1.json');
    let usuarios = JSON.parse(archivoo);
    let users = usuarios.usuarios;
    let response = data.responseError1;
    //i contiene a un usuario
      for (let i in users) {
        //j contien una propiedad de usuario
          for (let j in users[i]) {
             if(users[i]['user'] == name && users[i]['pass'] == pass && users[i]['user']== "admin"){
                response = data.users;
             }else if(users[i]['user'] == name && users[i]['pass'] == pass){
                response = data.users[i];
            }
          }
        }
        res.json(response);
});

router.all('/api/singup/', (req, res) => {
  let name = req.query.user;
  let pass = req.query.pass;
  let archivoo = fs.readFileSync('data_base/user1.json');
  let usuarios = JSON.parse(archivoo);
  let users = usuarios.usuarios;
  let response = data.responseError1;
  //i contiene a un usuario
    for (let i in users) {
      //j contien una propiedad de usuario
        for (let j in users[i]) {
           if(users[i]['user'] == name && users[i]['pass'] == pass && users[i]['user']== "admin"){
              response = data.users;
           }else if(users[i]['user'] == name && users[i]['pass'] == pass){
              response = data.users[i];
          }else{
            let token1 = createToken.generateRandomString(128);
            DBApi.agregarUsuario(name,pass,token1,"Usuario Valido");
          }
        }
      }
      res.json(response);
});


let file= "";
var datosArray = [];

  fs.readFile('data_base/user.json', "ascii",function(err, data) {
    if (err) {
      return console.log(err);
    }
    file = file.concat(data);
    datosArray=data;
    console.log(datosArray);
  }); 

  router.all('/prueba/', (req, res) => {
    let f = file.replace(/[&\#,+()$~%.":*?<>{}]/g, '');
    let f2 = f.replace("\ \n", ' ');
    let f3 = file.replace(/[&\#+()$~%."*?<>]/g, '');
    f3 = f3.replace("\ \n", ' ');
    let p = JSON.stringify(f2);
    let archivoo = fs.readFileSync('data_base/user1.json');
    let usuarios = JSON.parse(archivoo);
    res.json(
      {
        users: usuarios.usuarios
      })
  });

  
router.all('/prueba1/', (req, res) => {
  let f = file.replace(/[&\#,+()$~%.":*?<>{}]/g, '');
  let f2 = f.replace("\ \n", ' ');
  let f3 = file.replace(/[&\#+()$~%."*?<>]/g, '');
  f3 = f3.replace("\ \n", ' ');
  let p = JSON.stringify(f2);

  res.json(
    {
      p,
      file,
      f2,
      f3
    })
});


module.exports = router;