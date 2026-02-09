#!/bin/bash

areaCirculo (){
    if [ $# -ne 2 ]; then
        echo "Uso: areaCirculo <radio>"
        return 1
    fi
        echo "scale=2; 3.14 * $1*$1" | bc
}

area=$(areaCirculo 5)
echo $area