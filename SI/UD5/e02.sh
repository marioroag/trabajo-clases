#!/bin/bash

validar(){
    if [ $1 -ne $2 ]; then
        echo "Hay que pasar $1 argumentos"
        return 1
    fi
}

divisionEntera (){
    validar 2 $# || return 1
    resultado=$(( $1 / $2))
    echo $resultado
}

division=$(divisionEntera 10 2)
echo "La división da $division"