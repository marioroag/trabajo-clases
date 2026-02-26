const lista = document.getElementById("lista");
const aniadir = document.getElementById("btnAniadir");
const borrar = document.getElementById("btnBorrar");
const editar = document.getElementById("btnEditar");
// No declaro ultimoElemento fuera de las funciones porque cada vez que se ejecute tiene que rescatar el ultimo elemento actual asi que seria inutil

function aniadirElemento() {
    let nuevoElemento = document.createElement("LI")
    let cantidadElementos = lista.childElementCount;
    nuevoElemento.textContent = "Elemento " + (cantidadElementos + 1)
    lista.appendChild(nuevoElemento)
    
}

function borrarElemento() {
    let ultimoElemento = lista.lastElementChild
    ultimoElemento.remove();
}

function editarElemento() {
    ultimoElemento = lista.lastElementChild
    ultimoElemento.textContent = "Elemento editado"
}

aniadir.addEventListener("click", aniadirElemento);
borrar.addEventListener("click", borrarElemento);
editar.addEventListener("click", editarElemento);


