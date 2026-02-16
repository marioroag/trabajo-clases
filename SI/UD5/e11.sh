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

# 10. Función mayor_de_tres
# Crea una función que reciba tres números como argumentos y devuelva el mayor de ellos.
# Uso: mayor_de_tres 15 8 22
# Salida esperada: 22

mayor_de_tres(){
    validar 3 $# || return 1
    resultado=$1

    if [ $2 -gt $resultado ]; then
        resultado=$2
    fi

    if [ $3 -gt $resultado ]; then
        resultado=$3
    fi

    echo $resultado
    
}

mayor_de_tres 15 8 22