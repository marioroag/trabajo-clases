<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Ticket del pedido</title>
</head>
<body>
    <h1>Ticket de material electoral</h1>

<?php
// TODO: tabla o lista con partido, pack, unidades, extras y transporte.
// Aquí pinto los datos que eligió el usuario en el formulario.
echo '<p>Partido: ' . escapar($partido) . '</p>';
echo '<p>Pack: ' . escapar($packs[$pack]['nombre']) . '</p>';
echo '<p>Unidades: ' . escapar($unidades) . '</p>';
echo '<p>Transporte: ' . escapar($transporte) . '</p>';

// Los extras pueden venir vacíos; si no hay ninguno, lo digo claro.
echo '<p>Extras: ';
if (count($extrasRecibidos) === 0) {
    echo 'Ninguno';
} else {
    foreach ($extrasRecibidos as $extra) {
        echo escapar($extras[$extra]['nombre']) . ' ';
    }
}
echo '</p>';

// TODO: mostrar subtotal, descuento, transporte, base, IVA y total.
// Tabla con los números (euros() les pone 2 decimales bonitos).
echo '<table border="1">';
echo '<tr><th>Concepto</th><th>Importe</th></tr>';
echo '<tr><td>Mercancía</td><td>' . euros($mercanciaBruta) . ' €</td></tr>';
echo '<tr><td>Descuento</td><td>' . euros($descuento) . ' €</td></tr>';
echo '<tr><td>Transporte</td><td>' . euros($precioTransporte) . ' €</td></tr>';
echo '<tr><td>Base</td><td>' . euros($base) . ' €</td></tr>';
echo '<tr><td>IVA</td><td>' . euros($iva) . ' €</td></tr>';
echo '<tr><td>Total</td><td>' . euros($total) . ' €</td></tr>';
echo '</table>';

// TODO: mensaje distinto dependiendo de si se superan los 500 €.
// $superaPresupuesto ya viene calculado desde procesarPedido.php
if ($superaPresupuesto) {
    echo '<p>El pedido supera los 500 € (IVA incluido).</p>';
} else {
    echo '<p>El pedido no supera los 500 €.</p>';
}
?>

    <!-- ../ porque este archivo está dentro de vistas/ -->
    <p><a href="../pedido.html">Volver al formulario</a></p>
</body>
</html>
