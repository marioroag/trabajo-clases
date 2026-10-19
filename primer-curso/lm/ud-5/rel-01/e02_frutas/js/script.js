const elementosLista = document.getElementsByTagName("li")
const boton = document.getElementById("marcarFrutas")

// Añado bordes
for (const elemento of elementosLista) {
    elemento.style.border = "1px solid orange"
}

// Evento al pulsar
boton.addEventListener("click", function() {
    for (const elemento of elementosLista) {
        elemento.style.backgroundColor = "lightgreen"
        if (!elemento.textContent.includes("✅")) {
            elemento.textContent += "✅"
        }
    }
})