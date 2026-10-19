#!/bin/bash

validar(){
    if [ $1 -ne $2 ]; then
        echo "Hay que pasar $1 argumentos"
        return 1
    fi
}

areaRectangulo (){
        validar 2 $# || return 1
        echo "scale=2; $1 * $2" | bc
}

rectangulo=$(areaRectangulo 5 5)
echo $rectangulo