<?php
function esMetodoEnvio($actual, $esperado)
{
	return strtoupper(trim((string) $actual)) === strtoupper(trim((string) $esperado));
}
function validarOpcion($valor, $permitidas)
{
	if (is_array($permitidas) && in_array($valor, $permitidas, true)) {
		return $valor;
	}
	return false;
}
function validarEntero($valor, $min, $max)
{
	return filter_var($valor, FILTER_VALIDATE_INT, [
		'options' => ['min_range' => $min, 'max_range' => $max],
	]);
}
function euros($n)
{
	return number_format($n, 2, ',', '.');
}
function escapar($texto)
{
	return htmlspecialchars((string) $texto, ENT_QUOTES, 'UTF-8');
}
function prioridad($valor)
{
	if ($valor <= 2) return 'BAJA';
	if ($valor <= 5) return 'MEDIA';
	return 'ALTA';
}