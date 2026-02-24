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

# 4. cambiar_permisos

# Aplica chmod a un fichero (verificar formato numérico ^[0-7]{3,4}$).

# Uso: cambiar_permisos 644 archivo.txt
# Salida esperada: Permisos de 'archivo.txt' cambiados a 644
# Error si formato inválido o fichero no existe.

cambiar_permisos() {
    validar 2 $# || return 1

}

cambiar_permisos 644 archivo.txt