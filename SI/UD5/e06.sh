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

# Función multiplicar
# Crea una función que multiplique dos números pasados como argumentos.
# Uso: multiplicar 7 8
# Salida esperada: 56

multiplicar(){
    validar 2 $# || return 1
    echo "scale=2; $1 * $2" | bc
}

multiplicar 2 3