package es.stemgranada.ed.javadoc.soluciones.nivel3;

/**
 * Representa una línea individual dentro de una factura.
 *
 * Cada línea contiene un concepto, un precio unitario y una cantidad,
 * a partir de los cuales se calcula su importe parcial.
 *
 * @see Factura
 *
 * @author Alumno
 * @version 1.0
 * @since 1.0
 */
public class LineaFactura {

    private final String concepto;
    private final double precioUnitario;
    private final int cantidad;

    /**
     * Crea una nueva línea de factura con los datos indicados.
     *
     * @param concepto       descripción del producto o servicio
     * @param precioUnitario precio por unidad
     * @param cantidad       número de unidades
     * @throws IllegalArgumentException si el concepto es nulo o está vacío,
     *                                  si el precio unitario es negativo,
     *                                  o si la cantidad es menor o igual que cero
     */
    public LineaFactura(String concepto, double precioUnitario, int cantidad) {
        if (concepto == null || concepto.isBlank()) {
            throw new IllegalArgumentException("El concepto no puede estar vacío");
        }

        if (precioUnitario < 0) {
            throw new IllegalArgumentException("El precio unitario no puede ser negativo");
        }

        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero");
        }

        this.concepto = concepto;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    /**
     * Calcula el subtotal de la línea de factura.
     *
     * El cálculo realizado es:
     * {@code precioUnitario × cantidad}.
     *
     * @return importe parcial sin impuestos
     */
    public double calcularSubtotal() {
        return precioUnitario * cantidad;
    }

    /**
     * Obtiene el concepto de la línea.
     *
     * @return descripción del concepto
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * Obtiene la cantidad de unidades facturadas.
     *
     * @return número de unidades
     */
    public int getCantidad() {
        return cantidad;
    }
}
