#!/bin/bash

validar_argumentos() {
    if [ $# -ne $(( $1 + 1 )) ]; then
        echo "Hay que pasar $1 argumentos"
        echo false
    else
        echo true
    fi
}

validar(){
    if [ $1 -ne $2 ]; then
        echo "Hay que pasar $1 argumentos"
        return 1
    fi
}

# Función fibonacci
# Crea una función que devuelva el n-ésimo número de la serie de Fibonacci. La serie comienza: 0, 1, 1, 2, 3, 5, 8, 13...
# Uso: fibonacci 7
# Salida esperada: 13

fibonacci(){

}

fibonacci 7