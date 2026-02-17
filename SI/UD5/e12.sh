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

# Función factorial
# Crea una función que calcule el factorial de un número. El factorial de n es el producto de todos los números desde 1 hasta n.
# Uso: factorial 5
# Salida esperada: 120

factorial(){
    validar 1 $# || return 1
    factorial=$1

    resultado=1
    
    for i in $( seq 1 $factorial ); do
        resultado=$(($i * $resultado))

        echo "Iteracion $i, resultado = $resultado"
    done

    echo "El factorial de $1 es $resultado"
}

factorial 5