<?php
require_once __DIR__ . '/catalogo.php';
require_once __DIR__ . '/funciones.php';
require_once __DIR__ . '/validaciones.php';

// TODO 1: aceptar solo POST y validar partido, pack, transporte, unidades (1..8).
$esPost     = esMetodoEnvio($_SERVER['REQUEST_METHOD'] ?? '', 'POST');

$partido    = trim($_POST['partido'] ?? '');
$pack       = mb_strtolower(trim($_POST['pack'] ?? ''));
$transporte = trim($_POST['transporte'] ?? '');
$unidades   = $_POST['unidades'] ?? '';
$codigo     = mb_strtoupper(trim($_POST['codigo'] ?? ''));

$partido    = validarOpcion($partido, $partidos);
$pack       = validarOpcion($pack, array_keys($packs));
$transporte = validarOpcion($transporte, array_keys($transportes));
$unidades   = validarEntero($unidades, 1, 8);

if ($partido === false || $pack === false || $transporte === false || $unidades === false) {
    exit('Datos del pedido no válidos.');
}

// TODO 2: recuperar extras[] (puede no existir), validar sus valores y eliminar duplicados.
$extrasRecibidos = $_POST['extras'] ?? [];

// Borra duplicados
$extrasRecibidos = array_unique($extrasRecibidos);

// Todas las claves estan dentro de las validas?
foreach ($extrasRecibidos as $extra) {
    if (!in_array($extra, array_keys($extras), true)) {
        exit('Datos del pedido no válidos.');
    }
}

// TODO 3: calcular precio unitario = pack + suma de extras.
$precioExtras = 0;

foreach ($extrasRecibidos as $extra) {
    $precioExtras += $extras[$extra]['precio'];
}

$precioUnitario = $packs[$pack]['precio'] + $precioExtras;

// TODO 4: mercancía = precio unitario * unidades; aplicar código si es válido.
//          Un código inválido NO da descuento; el transporte NO se descuenta.
$mercanciaBruta = $precioUnitario * $unidades;
$descuento = 0;
$mercancia = $mercanciaBruta;

// Calcula y aplica el descuento
if (array_key_exists($codigo, $codigos)) {
    $descuento = $mercanciaBruta * ($codigos[$codigo] / 100);
    $mercancia = $mercanciaBruta - $descuento;
}

// TODO 5: calcular base con transporte, IVA 21 % y total final.
$precioTransporte = $transportes[$transporte];
$base = $mercancia + $precioTransporte;
$iva = $base * ($ivaPorcentaje / 100);
$total = $base + $iva;

// TODO 6: indicar si 
// total final supera 500 €, y preparar desglose en la vista.
$superaPresupuesto = $total > $presupuestoMaximo;

require __DIR__ . '/vistas/ticket.php';
