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

# 3. buscar_por_extension

# Cuenta o lista archivos con una extensión en un directorio.

# Uso: buscar_por_extension /ruta txt (por defecto lista; opcional -c para contar)
# Salida esperada (conteo): 12 o (lista): /ruta/a/archivo1.txt (una por línea)
# Validaciones: comprobar que el directorio existe.
