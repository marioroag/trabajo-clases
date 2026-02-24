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

# 8. puerto_abierto

# Comprueba si un puerto TCP está escuchando en un host (usar nc -z o /dev/tcp).

# Uso: puerto_abierto ejemplo.com 80
# Salida esperada: 80 abierto en ejemplo.com o: 80 cerrado en ejemplo.com
# Validaciones: comprobar que nc o /dev/tcp están disponibles; manejar tiempo de espera razonable

puerto_abierto() {
    validar 2 $# || return 1

}

puerto_abierto ejemplo.com 80