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

# 7. tamaño_directorio

# Devuelve el tamaño total en bits de un directorio.

# Uso: tamaño_directorio /var/log
# Salida esperada: 4096 (bits)

tamanio_directorio() {
    validar 1 $# || return 1

}

tamaño_directorio /var/log