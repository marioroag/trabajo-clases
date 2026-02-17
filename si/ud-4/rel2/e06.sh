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

# 6. respaldo

# Crea una copia de seguridad con timestamp: archivo.bak-YYYYMMDD_HHMMSS.

# Uso: respaldo archivo.txt
# Salida esperada: Backup creado: /ruta/archivo.txt.bak-20260217_123456
# Error si el fichero no existe.
# Implementación: usar cp -- y date +%Y%m%d_%H%M%S.
