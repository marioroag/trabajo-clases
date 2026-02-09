#!/bin/bash

divisionEntera (){
    if [ $# -ne 2 ]; then
        echo "Uso: divisionEntera <dividendo> <divisor>"
        return 1
    fi
        resultado=$(( $1 / $2))
        echo $resultado
}

division=$(divisionEntera 10 2)
echo "La división da $division"