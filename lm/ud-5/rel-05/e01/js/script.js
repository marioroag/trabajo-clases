const lista = document.getElementById("lista");
const aniadir = document.getElementById("btnAniadir");
const borrar = document.getElementById("btnBorrar");
const editar = document.getElementById("btnEditar");
let ultimoElemento = lista.lastElementChild;

function aniadirElemento() {
    let nuevoElemento = document.createElement("LI")
    let cantidadElementos = lista.childElementCount;
    nuevoElemento.textContent = "Elemento " + (cantidadElementos + 1)
    lista.appendChild(nuevoElemento)
    
}

function borrarElemento() {
    ultimoElemento = lista.lastElementChild
    console.log(ultimoElemento);
    ultimoElemento.remove();
}

function editarElemento() {
    ultimoElemento = lista.lastElementChild
    ultimoElemento.textContent = "Elemento editado"
}

aniadir.addEventListener("click", aniadirElemento);
borrar.addEventListener("click", borrarElemento);
editar.addEventListener("click", editarElemento);


