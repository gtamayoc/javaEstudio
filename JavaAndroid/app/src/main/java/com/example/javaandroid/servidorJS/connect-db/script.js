// CONECTAR BASES DE DATOS
// https://expressjs.com/en/guide/database-integration.html

// Paquete necesario para conectar a bases de datos MySQL.
var mysql = require('mysql');
// Consulta SQL.
var sql = 'SELECT * FROM users LIMIT 1';

// Parámetros de conexión a la base de datos.
var con = mysql.createConnection({
  host: "loaclhost",
  user: "postgress",
  password: "1234",
  database : 'javaEstudio'
});

// Funcion que nos permite comprobar la conexión a la base de datos.
// con.connect(function(err) {
//   if (err) throw err;
//   console.log("Connected!");
// });

// Funcion que nos devolverá resultados de la base de datos.
con.connect(function(err) {
  if (err) throw err;
  console.log("Conectado!");
  con.query(sql, function (err, result) {
    if (err) throw err;

    // Bucle que recore los resultados y pinta en consola.
    for(i=0; i<result.length; i++){
    	console.log("Result: " + result[i].name);
    }

  });
});