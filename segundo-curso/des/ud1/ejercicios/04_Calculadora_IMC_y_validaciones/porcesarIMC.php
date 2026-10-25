<?php
/*
 * EJERCICIO 04 · Calculadora IMC
 * Recetas reutilizables el día del examen:
 *   - Solo POST
 *   - filter_var INT / FLOAT con rango
 *   - strlen / mb_strlen para longitud de texto
 *   - IMC = peso / (altura_m)²
 *   - htmlspecialchars al imprimir
 */

// Escapar texto antes de meterlo en HTML (evita XSS).
function mostrar($valor): string
{
    return htmlspecialchars((string) $valor, ENT_QUOTES, 'UTF-8');
}

// --- 1) Solo aceptar POST (si abres el PHP a pelo → 405) ---
if (($_SERVER['REQUEST_METHOD'] ?? '') !== 'POST') {
    http_response_code(405);
    exit('Envía el formulario mediante POST.');
}

// --- 2) Recoger datos (?? = si no viene el campo, usa valor por defecto) ---
$nombre = trim((string) ($_POST['nombre'] ?? ''));

// Entero en rango: false si no es entero o está fuera
$edad = filter_var(
    $_POST['edad'] ?? null,
    FILTER_VALIDATE_INT,
    ['options' => ['min_range' => 0, 'max_range' => 130]]
);

$alturaCm = filter_var(
    $_POST['altura'] ?? null,
    FILTER_VALIDATE_INT,
    ['options' => ['min_range' => 50, 'max_range' => 300]]
);

// Decimal en rango (peso admite .5 etc.)
$pesoKg = filter_var(
    $_POST['peso'] ?? null,
    FILTER_VALIDATE_FLOAT,
    ['options' => ['min_range' => 20, 'max_range' => 500]]
);

// --- 3) Validar: si algo falla, NO calculamos ---
// mb_strlen cuenta bien tildes/ñ; 1–20 caracteres
if (
    $nombre === '' ||
    mb_strlen($nombre, 'UTF-8') > 20 ||
    $edad === false ||
    $alturaCm === false ||
    $pesoKg === false
) {
    exit(
        'Revisa los campos: nombre (1–20 caracteres), edad (0–130), ' .
        'altura (50–300 cm) y peso (20–500 kg).'
    );
}

// --- 4) Cálculos (solo si todo es válido) ---
// Altura llega en cm → pasar a metros
$alturaMetros = $alturaCm / 100;

// IMC = peso / (altura)² ; round(..., 2) → dos decimales
$imc = round($pesoKg / ($alturaMetros * $alturaMetros), 2);

// Estimación didáctica (NO es medición clínica)
$pulsoEstimado = 220 - $edad;

// --- 5) Mostrar resultado ---
echo '<!doctype html>';
echo '<html lang="es">';
echo '<head>';
echo '<meta charset="utf-8">';
echo '<title>Resultado IMC</title>';
echo '</head>';
echo '<body>';

echo '<h1>Resultados de ' . mostrar($nombre) . '</h1>';

// number_format: 2 decimales, coma decimal, punto de miles (estilo ES)
echo '<p>IMC calculado: ' . number_format($imc, 2, ',', '.') . '</p>';

echo '<p>Estimación didáctica de pulsaciones máximas (220 − edad): '
    . mostrar($pulsoEstimado)
    . ' pulsaciones/minuto.</p>';

echo '<p>Estos cálculos son ejemplos de programación, no una valoración médica.</p>';

echo '<p><a href="IMC.html">Volver al formulario</a></p>';

echo '</body>';
echo '</html>';
