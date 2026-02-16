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

volumenEsfera (){
        validar 1 $# || return 1
        echo "scale=3; (4/3) * 3.14 * $1*$1*$1" | bc
}

esfera=$(volumenEsfera 5)
echo $esfera