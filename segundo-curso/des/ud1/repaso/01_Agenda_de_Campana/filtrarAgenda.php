<?php
require_once __DIR__ . '/datosActos.php';
require_once __DIR__ . '/validaciones.php';

// TODO 1: comprobar que la petición es GET.
$esGet = esMetodoEnvio($_SERVER['REQUEST_METHOD'] ?? '', 'GET');

// TODO 2: leer y validar provincia, partido, tipo y limite (1..10).
// Permitir "Todas" / "Todos" para no filtrar ese campo.
$provincia = mb_strtolower(trim($_GET['provincia'] ?? ''));
$partido   = mb_strtolower(trim($_GET['partido'] ?? ''));
$tipo      = mb_strtolower(trim($_GET['tipo'] ?? ''));
$limite    = $_GET['limite'] ?? '';

$provinciasOk = array_map('mb_strtolower', array_merge(['Todas'], $provincias));
$partidosOk   = array_map('mb_strtolower', array_merge(['Todos'], $partidos));
$tiposOk      = array_map('mb_strtolower', array_merge(['Todos'], $tipos));

$provincia = validarOpcion($provincia, $provinciasOk);
$partido   = validarOpcion($partido, $partidosOk);
$tipo      = validarOpcion($tipo, $tiposOk);
$limite = validarEntero($limite, 1, 10);

if ($provincia === false || $partido === false || $tipo === false || $limite === false) {
    http_response_code(400);
    exit('Datos de búsqueda no válidos.');
}

// TODO 3: recorrer $actos y guardar todos los que cumplen LOS TRES filtros.
$coincidencias = [];

foreach ($actos as $acto) {
    $provinciaOk = $provincia == 'todas' || mb_strtolower($acto['provincia']) == $provincia;
    $partidoOk   = $partido == 'todos' || mb_strtolower($acto['partido']) == $partido;
    $tipoOk      = $tipo == 'todos' || mb_strtolower($acto['tipo']) == $tipo;

    if ($provinciaOk && $partidoOk && $tipoOk) {
        $coincidencias[] = $acto;
    }
}

// TODO 4: calcular cantidad de coincidencias y aforo total coincidente.
$cantidadCoincidencias = count($coincidencias);
$aforoTotal = 0;

foreach ($coincidencias as $acto) {
    $aforoTotal += $acto['aforo'];
}

echo $cantidadCoincidencias . ' coincidencias, aforo total: ' . $aforoTotal;

// TODO 5: mostrar solo los primeros $limite actos usando una vista externa.
$actosMostrar = array_slice($coincidencias, 0, $limite);
require __DIR__ . '/vistas/agendaResultado.php';


