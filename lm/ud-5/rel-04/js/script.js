//Ejercicio 1
function mostrarAlerta() {
    alert("¡Siente la Energía de Burn!")
}


const imagenAlerta = document.getElementById("imgClick")
imagenAlerta.addEventListener("click", mostrarAlerta)

//Ejercicio 2

function cambiarImagen() {
    imagen.src = "https://picsum.photos/id/238/200/300"
}
function restablecerImagen() {
    imagen.src = imagenOriginal
}

let imagen = document.getElementById("imgHover")
const imagenOriginal = imagen.src

imagen.addEventListener("mouseover", cambiarImagen)
imagen.addEventListener("mouseout", restablecerImagen)


//Ejercicio 3
const teclaPreseionada = document.getElementById("campoTexto")
teclaPreseionada.addEventListener("keydown",function (event) {
    console.log("Tecla presionada es: " + event.key);    
})

//Ejercicio 4
const formulario = document.getElementById("formulario")
const inputnombre = document.getElementById("nombre")
const resultado = document.getElementById("resultado")

formulario.addEventListener("submit", function (event) {
    event.preventDefault();
    const nombre = inputnombre.value
    resultado.innerHTML += "<br>Energia Recargada, <em>" + nombre + "</em>"
})
//Ejercicio 5
const input = document.getElementById("codigo")
const parrafo = document.getElementById("mensaje")
input.addEventListener("focus", function() {
    this.style.border = "2px solid green"
    parrafo.textContent = "Introduce tu codigo de energia"
    
})
input.addEventListener("blur", function() {
    this.style.border = ""
    parrafo.textContent = ""
    
})

