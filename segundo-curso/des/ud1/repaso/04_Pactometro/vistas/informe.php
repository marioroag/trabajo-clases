<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <title>Informe del pacto</title>
</head>

<body>
    <h1>Informe del pacto (simulación)</h1>

    <?php
    // Datos de la asamblea
    echo '<p>Asamblea: ' . escapar($nombreAsamblea) . '</p>';
    echo '<p>Escaños totales: ' . escapar($totalEscanos) . '</p>';
    echo '<p>Mayoría absoluta (mitad + 1): ' . escapar($umbralMayoria) . '</p>';

    // Socios del pacto
    echo '<p>Socios del pacto: ' . escapar(implode(', ', $socios)) . '</p>';
    echo '<p>Escaños del pacto: ' . escapar($escanosPacto) . '</p>';

    // Diagnóstico de mayoría
    if ($tieneMayoria) {
        echo '<p>¿Mayoría absoluta? Sí (sobran '
            . escapar($diferencia)
            . ' escaños).</p>';
    } else {
        echo '<p>¿Mayoría absoluta? No (faltan '
            . escapar(abs($diferencia))
            . ' escaños).</p>';
    }

    // Tabla: partidos fuera y qué pasaría si se unen solos
    echo '<h2>Alternativas (un solo partido externo)</h2>';
    echo '<table border="1">';
    echo '<tr><th>Partido</th><th>Aporta</th><th>Total si se une</th><th>¿Mayoría?</th></tr>';

    foreach ($alternativas as $alt) {
        echo '<tr>';
        echo '<td>' . escapar($alt['partido']) . '</td>';
        echo '<td>' . escapar($alt['aporta']) . '</td>';
        echo '<td>' . escapar($alt['total']) . '</td>';
        echo '<td>' . ($alt['alcanza'] ? 'Sí' : 'No') . '</td>';
        echo '</tr>';
    }

    if (count($alternativas) === 0) {
        echo '<tr><td colspan="4">No quedan partidos fuera del pacto.</td></tr>';
    }

    echo '</table>';

    // Socio mínimo adicional
    echo '<h2>Socio adicional de menor aportación</h2>';
    if ($tieneMayoria) {
        echo '<p>El pacto ya tiene mayoría: no necesita socios adicionales.</p>';
    } elseif ($socioMinimo === null) {
        echo '<p>Ningún partido externo, sumándose solo, alcanza la mayoría.</p>';
    } else {
        echo '<p>El socio mínimo es <strong>'
            . escapar($socioMinimo)
            . '</strong> (+'
            . escapar($partidosEscenario[$socioMinimo])
            . ' escaños).</p>';
    }
    ?>

    <p><a href="pactos.html">Analizar otro pacto</a></p>
</body>

</html>
