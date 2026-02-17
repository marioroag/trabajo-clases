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

# Función verificar_par
# Crea una función que compruebe si un número es par. Debe mostrar un mensaje indicando si es par o impar.
# Uso: verificar_par 8
# Salida esperada: 8 es par

verificar_par(){
    validar 1 $# || return 1
    if (( $1 % 2 == 0 )); then
        echo "$1 es par"
    else
        echo "$1 no es par"
    fi
}

verificar_par 8