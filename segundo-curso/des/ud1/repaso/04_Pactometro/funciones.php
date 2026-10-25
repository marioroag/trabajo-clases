<?php
/*
 * Recetas examen:
 *   mayoría absoluta = mitad entera + 1  →  intdiv($total, 2) + 1
 *   escapar = htmlspecialchars antes de pintar HTML
 */

// Mitad + 1 (ej. 41 → 21). NO es solo la mitad.
function calcularMayoria($totalEscanos)
{
    return intdiv((int) $totalEscanos, 2) + 1;
}

function escapar($valor)
{
    return htmlspecialchars((string) $valor, ENT_QUOTES, 'UTF-8');
}

function esMetodoEnvio($actual, $esperado)
{
    return strtoupper(trim((string) $actual)) === strtoupper(trim((string) $esperado));
}
