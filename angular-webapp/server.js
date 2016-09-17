 	// set up ========================
 	var express  = require('express');
    var app      = express();                               // create our app w/ express

    // configuration =================
    app.use(express.static(__dirname + '/Desktop/angular project'));                 // set the static files location /public/img will be /img for users

    // listen (start app with node server.js) ======================================
    app.listen(8080);
    console.log("App listening on port 8080");	