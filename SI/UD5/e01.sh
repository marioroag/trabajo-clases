#!/bin/bash

validar(){
    if [ $1 -ne $2 ]; then
        echo "Hay que pasar $1 argumentos"
        return 1
    fi
}

areaCirculo (){
    validar 1 $# || return 1
    echo "scale=2; 3.14 * $1*$1" | bc
}

area=$(areaCirculo 1)
echo $area