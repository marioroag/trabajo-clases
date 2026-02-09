#!/bin/bash

volumenEsfera (){
    if [ $# -ne 2 ]; then
        echo "Uso: volumenEsfera <radio>"
        return 1
    fi
        echo "scale=3; (4/3) * 3.14 * $1*$1*$1" | bc
}

esfera=$(volumenEsfera 5)
echo $esfera