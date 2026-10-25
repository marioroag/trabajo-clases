<?php
/*
 * EJERCICIO 05 · Matrícula y horario
 * Reutilizable en examen:
 *   - checkbox name="asignaturas[]" → $_POST['asignaturas'] (array)
 *   - array_key_exists / array_unique
 *   - tramos de 2 en 2: [inicio, fin, inicio, fin...]
 *   - strtotime para restar horas
 */
require_once __DIR__ . '/horario.php';

// --- Helpers ---

// Diferencia entre dos horas "HH:MM" → horas decimales (ej. 1.5)
function calcularDuracionHoras($horaInicio, $horaFin)
{
    // strtotime convierte "08:00" a timestamp; / 3600 → horas
    return (strtotime($horaFin) - strtotime($horaInicio)) / 3600;
}

// ¿Qué asignatura ocupa este día+hora? (para la tabla)
// Compara quitar ":" → "0830" para ordenar como números
function encontrarAsignatura($dia, $horaInicio)
{
    global $horario;

    $horaInicio = str_replace(':', '', $horaInicio);

    foreach ($horario as $asignatura => $horarioAsignatura) {
        // ¿Esta asignatura tiene clase ese día?
        if (!isset($horarioAsignatura[$dia])) {
            continue;
        }

        $horas = $horarioAsignatura[$dia];

        // Recorrer de 2 en 2: índice par = inicio, impar = fin
        for ($i = 0; $i + 1 < count($horas); $i += 2) {
            $ini = str_replace(':', '', $horas[$i]);
            $fin = str_replace(':', '', $horas[$i + 1]);

            // La franja del horario cae dentro del tramo de la asignatura
            if ($horaInicio >= $ini && $horaInicio < $fin) {
                return $asignatura;
            }
        }
    }

    return ''; // nadie ese tramo
}

// ========== TODO 1: solo POST ==========
if (($_SERVER['REQUEST_METHOD'] ?? '') !== 'POST') {
    http_response_code(405);
    exit('Envía el formulario mediante POST.');
}

// ========== TODO 2: recoger asignaturas[] ==========
// Si no marcaron nada → [] (el campo no llega)
$asignaturasMatriculadas = $_POST['asignaturas'] ?? [];

// ========== TODO 3: al menos una + existen en $horario ==========
if (!is_array($asignaturasMatriculadas) || $asignaturasMatriculadas === []) {
    exit('Selecciona al menos una asignatura.');
}

foreach ($asignaturasMatriculadas as $asignatura) {
    // Clave inventada o no string → error
    if (!is_string($asignatura) || !array_key_exists($asignatura, $horario)) {
        exit('Se ha enviado una asignatura no válida.');
    }
}

// Evitar sumar dos veces la misma si viene duplicada
$asignaturasMatriculadas = array_unique($asignaturasMatriculadas);

// ========== TODO 4–5: mostrar horarios y sumar horas (cada tramo) ==========
$horasSemanales = 0;

echo '<h1>Tu horario semanal</h1>';

foreach ($asignaturasMatriculadas as $asignatura) {
    echo '<h3>La asignatura ' . htmlspecialchars($asignatura, ENT_QUOTES, 'UTF-8') . ' tiene este horario:</h3>';
    echo '<ul>';

    // $horario[$asignatura] = [ "Lunes" => ["12:30","13:30"], ... ]
    foreach ($horario[$asignatura] as $dia => $horas) {
        echo '<li>' . htmlspecialchars($dia, ENT_QUOTES, 'UTF-8') . ': ';

        // DWES martes tiene DOS tramos → el for de 2 en 2 los pilla todos
        for ($i = 0; $i + 1 < count($horas); $i += 2) {
            $horaInicio = $horas[$i];
            $horaFin = $horas[$i + 1];

            $horasSemanales += calcularDuracionHoras($horaInicio, $horaFin);

            echo htmlspecialchars($horaInicio, ENT_QUOTES, 'UTF-8')
                . ' a '
                . htmlspecialchars($horaFin, ENT_QUOTES, 'UTF-8');

            // Si hay otro tramo después → " y "
            if ($i + 2 < count($horas)) {
                echo ' y ';
            }
        }

        echo '</li>';
    }

    echo '</ul>';
}

echo '<h3>Te has matriculado de '
    . htmlspecialchars((string) $horasSemanales, ENT_QUOTES, 'UTF-8')
    . ' horas a la semana</h3>';

// ========== AMPLIACIÓN: tabla días × tramos (solo matriculadas) ==========
?>
<style>
    table { border-collapse: collapse; margin: 1rem 0; font-family: sans-serif; }
    th, td { border: 1px solid #8f9cae; padding: .5rem; text-align: center; }
    th { background: #203d70; color: #fff; }
    .DAW { background: #d9edff; }
    .DIW { background: #fce5cd; }
    .DWEC { background: #e2efda; }
    .DWES { background: #eadcf8; }
    .IPE_II { background: #fff2cc; }
    .Proyecto { background: #f8d8df; }
    .Ingles { background: #d2f0ed; }
    .Optativa { background: #e0e4e9; }
</style>

<table>
    <thead>
        <tr>
            <th></th>
            <th>Lunes</th>
            <th>Martes</th>
            <th>Miércoles</th>
            <th>Jueves</th>
            <th>Viernes</th>
        </tr>
    </thead>
    <tbody>
        <?php
        // Filas = tramos de media hora ($horasHorario)
        foreach ($horasHorario as $hora) {
            $horaInicio = $hora[0];
            $horaFin = $hora[1];

            echo '<tr>';
            echo '<td>' . htmlspecialchars($horaInicio . ' - ' . $horaFin, ENT_QUOTES, 'UTF-8') . '</td>';

            // Columnas = días
            foreach ($diasSemana as $dia) {
                $asignaturaQueToca = encontrarAsignatura($dia, $horaInicio);

                // Solo pinto si está matriculada
                if (in_array($asignaturaQueToca, $asignaturasMatriculadas, true)) {
                    $clase = htmlspecialchars($asignaturaQueToca, ENT_QUOTES, 'UTF-8');
                    echo '<td class="' . $clase . '">' . $clase . '</td>';
                } else {
                    echo '<td></td>';
                }
            }

            echo '</tr>';
        }
        ?>
    </tbody>
</table>
