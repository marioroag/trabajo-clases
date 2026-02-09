#!/bin/bash

areaRectangulo (){
    if [ $# -ne 2 ]; then
        echo "Uso: areaRectangulo <base> <altura>"
        return 1
    fi
        echo "scale=2; $1 * $2" | bc
}

rectangulo=$(areaRectangulo 5 5)
echo $rectangulo