<!DOCTYPE html>
<html lang="es"><head><meta charset="UTF-8"><title>Resultados de agenda</title></head>
<body>
    <h1>Actos encontrados</h1>

<?php
echo "<p>Provincia: " . htmlspecialchars($provincia) . " | Partido: " . htmlspecialchars($partido) . " | Tipo: " . htmlspecialchars($tipo) . " | Límite: " . $limite . "</p>";

echo "<p>Coincidencias: " . $cantidadCoincidencias . " · Aforo total: " . $aforoTotal . "</p>";

if ($cantidadCoincidencias === 0) {
    echo "<p>La búsqueda no tiene resultados.</p>";
} else {
    echo "<table border='1'>";
    echo "<tr><th>Fecha</th><th>Hora</th><th>Provincia</th><th>Partido</th><th>Tipo</th><th>Lugar</th><th>Aforo</th></tr>";

    foreach ($actosMostrar as $acto) {
        echo "<tr>";
        echo "<td>" . htmlspecialchars($acto['fecha']) . "</td>";
        echo "<td>" . htmlspecialchars($acto['hora']) . "</td>";
        echo "<td>" . htmlspecialchars($acto['provincia']) . "</td>";
        echo "<td>" . htmlspecialchars($acto['partido']) . "</td>";
        echo "<td>" . htmlspecialchars($acto['tipo']) . "</td>";
        echo "<td>" . htmlspecialchars($acto['lugar']) . "</td>";
        echo "<td>" . $acto['aforo'] . "</td>";
        echo "</tr>";
    }

    echo "</table>";
}
?>

    <p><a href="agenda.html">Nueva búsqueda</a></p>
</body></html>