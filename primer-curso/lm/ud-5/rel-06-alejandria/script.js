const buscador = document.getElementById('buscador');
const listaLibros = document.querySelector('#lista-libros ul');
const listaFavoritos = document.querySelector('#favoritos ul');

// Buscador
buscador.addEventListener("keyup", buscadorLibros)
function buscadorLibros () {
    let filtro = this.value.toLowerCase();
    let libros = document.querySelectorAll("li");

    for (const libro of libros) {
        let nombre = libro.textContent.toLowerCase()

        if (nombre.includes(filtro)) {
            libro.style.display = "block"
        } else {
            libro.style.display = "none"
        }
    }
}
for (const element of listaLibros) {
    element.addEventListener("click", aniadirFavoritos(element))
}
function aniadirFavoritos (element) {
    element.textContent="asdasda"
}