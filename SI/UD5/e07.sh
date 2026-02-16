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

# 5. Función potencia
# Crea una función que eleve un número a una potencia. El primer argumento es la base y el segundo el exponente.
# Uso: potencia 2 5
# Salida esperada: 32

potencia(){
    validar 2 $# || return 1
    echo "scale=2; $1^$2" | bc
}

potencia 2 5