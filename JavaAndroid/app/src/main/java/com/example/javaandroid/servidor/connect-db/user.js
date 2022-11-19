let users = {
    "0":
    {
        "user":"admin",
        "pass":"admin",
        "token": "8a59916c900035e985d1968f154a77796b60a4a9f3f96fe00eb5bc5d8dc659eaedfc93d7219b49bbad12f008c48de979227caac6bbbd6c606751b31432e62b5c",
        "message": "Usuario Valido"
    },
    "1":
    {
        "user":"123",
        "pass":"123",
        "token": "f9ca6c9fd6491010db14a43237f277bae1b0aea3ffd763a88d1c9cb9193c38a7c7ccebf6ea00617b29299da27f8d3e4025a4df62a78246fd6afefc7d783fa0e2",
        "message": "Usuario Valido"
    },
    "2":
    {
        "user":"234",
        "pass":"234",
        "token": "a518e106b92e3ed273c1114ddb1db652bfc60048dad505ecfd1a85efa4345a6500f1cc64cf69bd34da4118452d55f7b9e6d288e21f13c6f75270bad3e179b714",
        "message": "Usuario Valido"
    }
  };

let user = {
    "user": users["0"]["user"],
    "pass": users["0"]["pass"],
    "token": users["0"]["token"],
    "message": "Usuario Valido"
};

module.exports = {
    users,
    user
}; 