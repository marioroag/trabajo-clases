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

# 1. crear_directorio

# Crea un directorio (usa mkdir -p) y muestra si ya existía o fue creado.

# Uso: crear_directorio /ruta/al/directorio
# Salida esperada: Directorio '/tmp/prueba' creado o Directorio '/tmp/prueba' ya existe
# Validaciones: comprobar número de argumentos y permisos de escritura en la ruta padre.

crear_directorio() {
    validar 1 $# || return 1

}

crear_directorio /ruta/al/directorio