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

# Función sumatorio
# Crea una funcion que sume todos los números de 1 al numero pasado como primer argumento. 
# Si lo haces en eficiencia lineal O(n), lo tienes bien, pero la gracia de este ejercicio es intentar hacerlo de manera inmediata
# lo que se llama O(1). Una manera de calcularlo, que dé igual lo grande que sea el número, se haga de manera "inmediata".
# Al igual que para sumatorio, ¿Se podría hacer para el factorial?

sumatorio() {
    validar 1 $# || return 1

    echo "scale=0; ($1 * ($1 + 1)) / 2" | bc
}

sumatorio 10