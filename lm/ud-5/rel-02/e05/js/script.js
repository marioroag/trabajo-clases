const contenedor = document.getElementById("contenedor")

const noticias = [
    "noticia1",
    "noticia2",
    "noticia3"
]

for (let i = 0; i < noticias.length; i++) {
    const parrafo = document.createElement("p")
    parrafo.textContent = noticias[i]
    contenedor.appendChild(parrafo)
    
}