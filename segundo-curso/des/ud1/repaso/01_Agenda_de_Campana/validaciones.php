<?php
function esMetodoEnvio($metodoActual, $metodoEsperado)
{
    $actual = strtoupper(trim((string) $metodoActual));
    $esperado = strtoupper(trim((string) $metodoEsperado));
    $coincide = $actual === $esperado;

    return $coincide;
}

$metodoValido = esMetodoEnvio($_SERVER['REQUEST_METHOD'] ?? '', 'GET');

if ($metodoValido == false) {
    http_response_code(405);
    exit('Método de envio no permitido.');
}

function validarOpcion($valor, $opcionesPermitidas)
{
    $resultado = false;

    if (
        (is_string($valor) || is_int($valor) || is_float($valor)) &&
        is_array($opcionesPermitidas) &&
        in_array($valor, $opcionesPermitidas, true)
    ) {
        $resultado = $valor;
    }

    return $resultado;
}

function validarEntero($valor, $minimo, $maximo)
{
    $resultado = filter_var(
        $valor,
        FILTER_VALIDATE_INT,
        array(
            'options' => array(
                'min_range' => $minimo,
                'max_range' => $maximo
            )
        )
    );

    return $resultado;
}