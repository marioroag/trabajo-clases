<?php
require_once __DIR__ . '/datosPartidos.php';
require_once __DIR__ . '/funciones.php';

// TODO 1: aceptar POST y validar censo entero entre 1 y 100000.

if (!esMetodoEnvio($_SERVER['REQUEST_METHOD'] ?? '', 'POST')) {
	http_response_code(405);
	exit('Método no permitido.');
}

$censo = validarEntero($_POST['censo'] ?? '', 1, 100000);
$votos = $_POST['votos'] ?? [];

// TODO 2: validar que votos[] contiene exactamente las claves de $partidos,
//          y que todos los votos, blancos y nulos son enteros >= 0.

foreach ($partidos as $partido) {
    if (!isset($votos[$partido])) {
        exit('Datos no válidos.');
    }
}
if (count($votos) !== count($partidos)) {
    exit('Datos no válidos.');
}

// TODO 3: votos a candidaturas, votos válidos (candidaturas + blancos),
//          emitidos (válidos + nulos), abstención y participación.
// TODO 4: rechazar votos emitidos > censo y recuentos de 0 emitidos.
// TODO 5: calcular porcentajes de cada partido sobre VOTOS VÁLIDOS,
//          ordenar de más a menos votos e identificar empate en el primer puesto.
// TODO 6: contar cuántos partidos alcanzan el umbral didáctico del 5 %.
// TODO 7: mostrar tabla HTML mediante vistas/resultados.php.

// require __DIR__ . '/vistas/resultados.php';
echo 'Pendiente de implementar el escrutinio.';
