const todosLosBotones = document.getElementsByTagName("button")
const botonCambiar = document.getElementById("cambiarEstilo")

// Cambio primer boton
document.querySelector(".boton").style.backgroundColor = "lightgreen"

// Cambio todos los colores
botonCambiar.addEventListener("click", function() {
    for (const botonestilo of todosLosBotones) {
        botonestilo.style.backgroundColor = "lightyellow"
        botonestilo.style.border = "1px solid lightgreen"
    }
})
