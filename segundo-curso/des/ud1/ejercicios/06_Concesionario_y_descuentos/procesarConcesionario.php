<?php
require_once __DIR__ . '/componentes.php';

// Escapar al pintar HTML
function mostrar($texto): string
{
    return htmlspecialchars((string) $texto, ENT_QUOTES, 'UTF-8');
}

// Dinero con 2 decimales estilo ES
function euros($importe): string
{
    return number_format($importe, 2, ',', '.') . ' €';
}

// ========== TODO 1: solo POST ==========
if (($_SERVER['REQUEST_METHOD'] ?? '') !== 'POST') {
    http_response_code(405);
    exit('Envía el formulario mediante POST.');
}

// ========== TODO 2: validar 5 radios obligatorios ==========
// Cada name del HTML es una clave de $componentes (Modelo, Motor...)
$obligatorios = ['Modelo', 'Motor', 'Color', 'Llantas', 'Equipamiento'];
$seleccion = []; // grupo => valor elegido

foreach ($obligatorios as $grupo) {
    $valor = $_POST[$grupo] ?? null;

    // Debe existir y ser una clave del mapa de ese grupo
    if (!is_string($valor) || !array_key_exists($valor, $componentes[$grupo])) {
        exit('Debes seleccionar una opción válida de ' . mostrar($grupo) . '.');
    }

    $seleccion[$grupo] = $valor;
}

// ========== TODO 3: Accesorios[] (puede no venir) + sin duplicados ==========
$accesorios = $_POST['Accesorios'] ?? []; // sin [] en $_POST

if (!is_array($accesorios)) {
    exit('La selección de accesorios no es válida.');
}

foreach ($accesorios as $accesorio) {
    if (!is_string($accesorio) || !array_key_exists($accesorio, $componentes['Accesorios'])) {
        exit('Has seleccionado un accesorio no válido.');
    }
}

$accesorios = array_unique($accesorios); // no sumar dos veces el mismo

// ========== TODO 3: cantidad 1..5 ==========
$cantidad = filter_var(
    $_POST['cantidad'] ?? null,
    FILTER_VALIDATE_INT,
    ['options' => ['min_range' => 1, 'max_range' => 5]]
);

if ($cantidad === false) {
    exit('La cantidad debe ser un número entero entre 1 y 5.');
}

// ========== TODO 5: código (opcional). Si no existe → 0 % ==========
$codigo = strtoupper(trim((string) ($_POST['codigo_descuento'] ?? '')));
// ?? 0 = si la clave no está en el mapa, descuento 0
$descuentoPorcentaje = $codigosDescuento[$codigo] ?? 0;

// ========== TODO 4: precio por vehículo = suma componentes + accesorios ==========
$precioUnidad = 0;

echo '<!doctype html><html lang="es"><head><meta charset="utf-8"><title>Tu coche</title></head><body>';
echo '<h1>Resumen de tu coche personalizado</h1>';
echo '<ul>';

foreach ($seleccion as $grupo => $valor) {
    $precio = $componentes[$grupo][$valor]; // precio del catálogo
    $precioUnidad += $precio;
    echo '<li>' . mostrar($grupo) . ': ' . mostrar($valor) . ' — ' . $precio . ' €</li>';
}

if ($accesorios === []) {
    echo '<li>Accesorios: ninguno</li>';
}

foreach ($accesorios as $accesorio) {
    $precio = $componentes['Accesorios'][$accesorio];
    $precioUnidad += $precio;
    echo '<li>Accesorio: ' . mostrar($accesorio) . ' — ' . $precio . ' €</li>';
}

echo '</ul>';

// ========== TODO 4–6: base × cantidad → descuento → IVA 21 % → total ==========
$baseInicial = $precioUnidad * $cantidad;                    // sin IVA, sin dto
$rebaja = round($baseInicial * $descuentoPorcentaje / 100, 2); // € descontados
$baseFinal = $baseInicial - $rebaja;                         // tras descuento
$iva = round($baseFinal * 0.21, 2);                          // IVA sobre base final
$totalConIva = $baseFinal + $iva;

echo '<p>Cantidad: ' . mostrar($cantidad) . '</p>';
echo '<p>Precio por unidad sin IVA: ' . euros($precioUnidad) . '</p>';
echo '<p>Base inicial sin IVA: ' . euros($baseInicial) . '</p>';

if ($codigo !== '') {
    // Avisar si el código no vale, pero SEGUIMOS sin descuento
    echo '<p>Código de descuento: ' . mostrar($codigo)
        . ($descuentoPorcentaje ? ' (válido)' : ' (no válido)')
        . '</p>';
} else {
    echo '<p>Código de descuento: no aplicado</p>';
}

echo '<p>Descuento aplicado: ' . euros($rebaja) . '</p>';
echo '<p>Base tras el descuento: ' . euros($baseFinal) . '</p>';
echo '<p>IVA (21 %): ' . euros($iva) . '</p>';
echo '<h2>Total con IVA: ' . euros($totalConIva) . '</h2>';
echo '<p><a href="formularioConcesionario.html">Nueva configuración</a></p>';
echo '</body></html>';
