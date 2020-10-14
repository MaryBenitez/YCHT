var donanteStyle = document.getElementById("donantecheck");
var loginB = document.getElementById("login");
var registro = document.getElementById("register");
var seleccion = document.getElementById("elegir");
var donante = document.getElementById('donantecheck');
var beneficiario = document.getElementById('beneficiariocheck');

//Muestra iniciar sesion
function login() {
    loginB.style.left = "50px";
    registro.style.left = "450px";
    seleccion.style.left = "0px";
}

//Muestra Registro, haciendo cambios en los estilos y se vea como animación
function registrar() {
    donanteStyle.style.margin = "30px 10px 30px 0";
    loginB.style.left = "-400px";
    registro.style.left = "50px";
    registro.style.top = "-225px";
    seleccion.style.left = "120px";
}

//Funciones que desabilitan un checkbox si ya esta seleccionado otro
donante.onclick = function() {
    if(beneficiario.disabled){
        beneficiario.disabled = false;
    }else{
        beneficiario.disabled = true;
    }
}
beneficiario.onclick = function() {
    if(donante.disabled){
        donante.disabled = false;
    }else{
        donante.disabled = true;
    }
}