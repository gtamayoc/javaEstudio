const express = require('express');
const app = express();
const morgan=require('morgan');

var currentDate = new Date();

//Configuraciones
app.set('port', process.env.PORT || 3000);
app.set('json spaces', 3);

app.use(morgan('dev'));
app.use(express.urlencoded({extended:false}));
app.use(express.json());
app.use(require('./routes/routes'));
app.use(express.static(__dirname + '/public'));

app.get('/', (req, res) => {  
    res.type('html');  
    res.send(
        {
            "name": "Java Estudio",
            "version": "1.0",
            "descripcion": "API Developed by: Giuseppe.",
            "enviroment": "Android Studio",
            "API level": null,
            "creationDate": "Tue Nov 15 2022",
            "currentDate": currentDate.toDateString(),
        });
});

app.listen(app.get('port'),()=>{
    console.log(`Server listening on port ${app.get('port')}`);
});
