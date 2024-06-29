/**
 * 
 */
var c = 0;

function carrusel(){
  if (c >= 6) {
    return; // Stop the recursion after 6 iterations
  }

  document.querySelector("#portada").style.opacity = "0";
  document.querySelector("#portada").style.transition = "opacity 0.5s ease";

  setTimeout(cambio, 500);
}

function cambio(){
  c++;
  if(c > 6){
    c = 1;
  }
  document.querySelector("#portada").setAttribute("src", "img/banner/banner_inicio"+c+".jpg");
  document.querySelector("#portada").style.opacity = "1";
  document.querySelector("#portada").style.transition = "opacity 1s ease";

  setTimeout(carrusel, 2000);
}

carrusel();

function mostrarMensaje(mensaje) {
  document.querySelector("#mensaje").innerHTML = mensaje;
}

mostrarMensaje("Hola, mundo!");

