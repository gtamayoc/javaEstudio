const express = require('express');
const app = express();
const { Router } = require('express');
const router = Router();

const token = require('crypto').randomBytes(64).toString('hex');


router.get('/api', (req, res) => {    
    res.json(
        {
            "Title": "Hola mundo usando rutas! "
        }
    );
});

router.get('/login/', (req, res) => { 
        res.json(
            {
                "error": "404",
                "message": "Por Favor Inicie Session"
            }
        );
});

router.get('/login/:user&:pass', (req, res) => {
    let name = req.params.user;
    let pass = req.params.pass;
    if(name != "123" || pass != "123"){  
        res.json(
            {
                "user": null,
                "pass": null,
                "token": null,
                "message": "Usuario o Clave No Validos"
            }
        );
    }else{
        res.json(
            {
                "user": name,
                "pass": pass,
                "token": token,
                "message": "Usuario Valido"
            }
        );
    }
});

router.post('/login/:user&:pass', (req, res) => {
    let name = req.params.user;
    let pass = req.params.pass;
    if(name != "123" || pass != "123"){  
        res.json(
            {
                "user": null,
                "pass": null,
                "token": null,
                "message": "Usuario o Clave No Validos"
            }
        );
    }else{
        res.json(
            {
                "user": name,
                "pass": pass,
                "token": token,
                "message": "Usuario Valido"
            }
        );
    }
});



module.exports = router;