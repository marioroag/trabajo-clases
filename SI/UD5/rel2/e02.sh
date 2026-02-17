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

# 2. buscar_archivos_grandes

# Busca archivos mayores que X megabytes en un directorio (usar find).

# Uso: buscar_archivos_grandes /ruta 50 (busca > 50 MB)
# Salida esperada: lista de rutas (una por línea) o No se encontraron archivos > 50 MB
# Nota: convertir MB a bytes con $(( size_mb * 1024 * 1024 )) si es necesario.



