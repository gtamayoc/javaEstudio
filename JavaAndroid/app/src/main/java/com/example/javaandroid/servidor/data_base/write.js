var fs = require('fs');
const path = require('path');

let archivoo = 'user1.json';
let camino = path.dirname(archivoo);
let camino2 = path.basename(archivoo);
let camino3 = path.resolve(archivoo);
console.log(camino);
console.log(camino2);
console.log(camino3);
fs.readFile(camino3+"/"+camino2, 'utf8', function(err, data) {
    if (err) {
      return console.log(err);
    }
    console.log(data);
  });

  var data = {}
  data.usuarios = []


const crearArchivo = () =>{
    for (i=0; i == 2 ; i++){
        var obj = {
            user: "admin",
            pass: "admin",
            token: "prueba",
            message: "Usuario Valido"
        }
        data.usuarios.push(obj)
     }
     fs.writeFile ("user1.json", JSON.stringify(data), function(err) {
         if (err) throw err;
         console.log('complete');
         }
     );
};

const agregarUsuario = (user,pass,token,message) =>{
    message = message;
    fs.readFile('user1.json', 'utf8', function readFileCallback(err, data){
        if (err){
            console.log(err);
        } else {
        obj = JSON.parse(data);//now it an object
        console.log(data.length); 
        obj.usuarios.push(
            {
                user: user,
                pass: pass,
                token: token,
                message: "Usuario Valido"
            }
            ); //add some data
        json = JSON.stringify(obj); //convert it back to json
        fs.writeFile('user1.json', json, 'utf8', function(err) {
            if (err) throw err;
            console.log('complete2');
            }
        ); // write it back 
    }});

};



module.exports = {
    crearArchivo,
    agregarUsuario
}; 

