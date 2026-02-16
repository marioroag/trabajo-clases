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

# 12. Función es_primo
# Crea una función que compruebe si un número es primo. Debe mostrar un mensaje indicando si es primo o no.
# Uso: es_primo 17
# Salida esperada: 17 es primo

# SIN TERMINAR !!!!!

es_primo(){
    validar 1 $# || return 1
    
    if [[ $1 % 1 -eq 0 && $1 % $1 -eq 0 ]]; then
        echo "$1 es primo"
    else
        echo "$1 no es primo"
    fi
}

es_primo 7