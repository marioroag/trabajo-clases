#!/bin/bash

periCirculo (){
    if [ $# -ne 2 ]; then
        echo "Uso: periCirculo <radio>"
        return 1
    fi
        echo "scale=2; 2 * 3.14 * $1" | bc
}

peri=$(periCirculo 5)
echo $peri