<?php
/*
 * EJERCICIO 04 · Pactómetro
 * Recetas: socios[] (checkboxes), array_key_exists en catálogo,
 *          mayoría = intdiv/2+1, partidos fuera + socio mínimo.
 */
require_once __DIR__ . '/datosEscenarios.php';
require_once __DIR__ . '/funciones.php';

// --- TODO 1: solo POST ---
if (!esMetodoEnvio($_SERVER['REQUEST_METHOD'] ?? '', 'POST')) {
    http_response_code(405);
    exit('Método no permitido.');
}

// Escenario del select
$escenario = trim($_POST['escenario'] ?? '');

// Checkboxes: si no marcaron ninguno → []
$socios = $_POST['socios'] ?? [];

// --- TODO 1–2: validar escenario y socios (1 a 3, sin inventados ni repetidos) ---
if (!array_key_exists($escenario, $escenarios)) {
    exit('Datos no válidos.');
}

if (!is_array($socios)) {
    exit('Datos no válidos.');
}

// Quitar duplicados (por si el navegador manda dos iguales)
$socios = array_values(array_unique($socios));

// Entre 1 y 3
if (count($socios) < 1 || count($socios) > 3) {
    exit('Datos no válidos.');
}

// Partidos permitidos en ESTE escenario (claves del mapa)
$partidosEscenario = $escenarios[$escenario]['partidos'];

foreach ($socios as $socio) {
    // ¿Existe en el catálogo de este escenario?
    if (!array_key_exists($socio, $partidosEscenario)) {
        exit('Datos no válidos.');
    }
}

// Datos del escenario elegido
$nombreAsamblea = $escenarios[$escenario]['nombre'];
$totalEscanos = $escenarios[$escenario]['escanos'];

// --- TODO 3: mayoría absoluta = mitad + 1 ---
$umbralMayoria = calcularMayoria($totalEscanos);

// --- TODO 3–4: sumar escaños del pacto ---
$escanosPacto = 0;
foreach ($socios as $socio) {
    $escanosPacto += $partidosEscenario[$socio];
}

$tieneMayoria = ($escanosPacto >= $umbralMayoria);
// Positivo = sobran; negativo = faltan
$diferencia = $escanosPacto - $umbralMayoria;

// --- TODO 5: partidos FUERA del pacto → qué pasaría si se une SOLO ese ---
$alternativas = []; // filas para la tabla
foreach ($partidosEscenario as $partido => $escanos) {
    // Si ya está en el pacto, lo saltamos
    if (in_array($partido, $socios, true)) {
        continue;
    }

    $totalSiSeUne = $escanosPacto + $escanos;
    $alcanza = ($totalSiSeUne >= $umbralMayoria);

    $alternativas[] = [
        'partido' => $partido,
        'aporta' => $escanos,
        'total' => $totalSiSeUne,
        'alcanza' => $alcanza,
    ];
}

// --- TODO 6: socio externo de MENOR aportación que dé mayoría ---
// Si ya hay mayoría → no hace falta nadie.
$socioMinimo = null; // nombre del partido, o null si no aplica / no existe

if (!$tieneMayoria) {
    foreach ($alternativas as $alt) {
        if (!$alt['alcanza']) {
            continue; // este solo no llega
        }
        // Nos quedamos con el que aporta MENOS escaños
        if (
            $socioMinimo === null ||
            $alt['aporta'] < $partidosEscenario[$socioMinimo]
        ) {
            $socioMinimo = $alt['partido'];
        }
    }
}

// --- TODO 7: pintar informe ---
require __DIR__ . '/vistas/informe.php';
