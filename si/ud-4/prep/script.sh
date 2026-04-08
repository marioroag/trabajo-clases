validar_min(){
    if [ $2 -lt $1 ]; then
        echo "debe haber al menos $1 argumentos"
        return 1
    fi
}

maximo(){
    validar_min 1 $# || return 1

    max=$1

    for n in $@
    do
        if [ $n -gt $max ]; then
            max=$n
        fi
    done

    echo $max
}

maximo 4 10 2 8

mas_grandes(){
    validar_min 1 $# || return 1

    max=0

    # Se podria usar la funcion "maximo" aqui pero es mas sencillo no usarla
    # Ya que tendriamos que recorrer la carpeta igualmente para guardarlos y
    # despues usarlo asi que no tiene sentido
    for archivo in $(ls $1)
    do
        tamanio=$(ls -l $1/$archivo | awk '{print $5}')

        if [ $tamanio -gt $max ]; then
            max=$tamanio
        fi
    done

    for archivo in $(ls $1)
    do
        tamanio=$(ls -l $1/$archivo | awk '{print $5}')

        if [ $tamanio -eq $max ]; then
            echo $archivo
        fi
    done
}

mas_grandes carpeta

borrar_grandes(){
    validar_min 1 $# || return 1

    for archivo in $(mas_grandes $1)
    do
        rm -r $1/$archivo
        echo "$archivo eliminado"
    done
}

borrar_grandes carpeta