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

# 9. verificar_conectividad

# Hace un ping -c 1 y muestra si el host responde y la latencia.

# Uso: verificar_conectividad 8.8.8.8
# Salida esperada: 8.8.8.8 responde (latencia: 24 ms) o: 8.8.8.8 no responde

verificar_conectividad() {
    validar 1 $# || return 1

}

verificar_conectividad 8.8.8.8