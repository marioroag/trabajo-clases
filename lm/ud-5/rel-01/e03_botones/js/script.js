const primerBoton = document.querySelector(".boton")
const todosLosBotones = document.querySelectorAll(".boton")
const botonCambiar = document.getElementById("cambiarEstilo")

// Cambio primer boton
primerBoton.style.backgroundColor = "lightgreen"

// Cambio todos los colores
botonCambiar.addEventListener("click", function() {
    for (const botonestilo of todosLosBotones) {
        botonestilo.style.backgroundColor = "lightyellow"
        botonestilo.style.border = "1px solid lightgreen"
    }
})
