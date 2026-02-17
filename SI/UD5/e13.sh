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

# Función es_primo
# Crea una función que compruebe si un número es primo. Debe mostrar un mensaje indicando si es primo o no.
# Uso: es_primo 17
# Salida esperada: 17 es primo

es_primo(){
    validar 1 $# || return 1

    if [ "$1" -le 1 ]; then
        echo "$1 no es primo"
        return
    fi

    for (( i=2; i<$1; i++ )); do
        if [ $(($1 % i)) -eq 0 ]; then
            echo "$1 no es primo"
            return
        fi
    done

    echo "$1 es primo"
}

es_primo 17