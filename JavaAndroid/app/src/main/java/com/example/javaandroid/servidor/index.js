const express = require('express');
const app = express();
const morgan=require('morgan');

var currentDate = new Date();

//Configuraciones
app.set('port', process.env.PORT || 3000);
app.set('json spaces', 2);

app.use(morgan('dev'));
app.use(express.urlencoded({extended:false}));
app.use(express.json());
app.use(require('./routes/routes'));


app.get('/', (req, res) => {    
    res.json(
        {
            "name": "Java Estudio",
            "version": "1.0",
            "descripcion": "API Developed by: Giuseppe.",
            "enviroment": "Android Studio",
            "API level": "1",
            "creationDate": "Tue Nov 15 2022",
            "currentDate": currentDate.toDateString(),
        }
    );
});

app.listen(app.get('port'),()=>{
    console.log(`Server listening on port ${app.get('port')}`);
});
