const animales = document.getElementsByClassName("animal")
const boton = document.getElementById("resaltarAnimales")

for (const animal of animales) {
    animal.style.backgroundColor = "lightyellow"
}

boton.addEventListener("click", function() {
    for (const animal of animales) {
        animal.style.backgroundColor = "lightgreen"
        animal.style.fontSize = "24px"
    }
})

