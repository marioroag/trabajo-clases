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

# 5. obtener_propietario

# Muestra propietario y grupo de un fichero

# Uso: obtener_propietario archivo.txt
# Salida esperada: archivo.txt: propietario=juan grupo=staff
# Validaciones: comprobar existencia del fichero.
