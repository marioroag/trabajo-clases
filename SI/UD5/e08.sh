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

# 7. Función volumen_cubo
# Crea una función que calcule el volumen de un cubo recibiendo el lado como argumento. Formula: V = lado³
# Uso: volumen_cubo 4
# Salida esperada: 64

volumen_cubo(){
    validar 1 $# || return 1
    echo "scale=2; $1^3" | bc
}

volumen_cubo 4
