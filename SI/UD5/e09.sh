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

# Función modulo
# Crea una función que obtenga el resto de la división entre dos números.
# Uso: modulo 17 5
# Salida esperada: 2

modulo(){
    validar 2 $# || return 1
    echo "scale=0; $1%$2" | bc
}

modulo 17 5