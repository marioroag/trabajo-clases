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
# Crea una función que devuelva el n-ésimo número de la serie de Fibonacci. La serie comienza: 1, 1, 2, 3, 5, 8, 13...
# Uso: fibonacci 7
# Salida esperada: 13

    # 1, 1, 2, 3, 5, 8, 13...
    # 1 itineracion
    #       posicion1=1
    #       posicion2=1
    #       posicion3=2 // 1 + 2

    # 2 itineracion
    #       posicion1=1
    #       posicion2=2
    #       posicion3=3

# posicion1 = anteriorposicion2
# posicion2 = anteriorposicion3
    # 3 itineracion
    #       posicion1=2
    #       posicion2=3
    #       posicion3=5

fibonacci(){
    validar 1 $# || return 1

    posicion1=1
    posicion2=1
    posicion3=0

    for i in $( seq 1 $(( $1 - 1 )) ); do
        # Calcula la que sera la proxima posicion
        posicion3=$(( $posicion1 + $posicion2 ))

        # Actualiza las anteriores posiciones 
        posicion1=$posicion2
        posicion2=$posicion3
    done

    echo $posicion1
    
}

fibonacci 7