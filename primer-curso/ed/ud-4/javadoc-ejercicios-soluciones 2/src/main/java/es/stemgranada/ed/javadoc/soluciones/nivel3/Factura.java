package es.stemgranada.ed.javadoc.soluciones.nivel3;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa una factura emitida a un cliente y compuesta por varias líneas.
 *
 * El cálculo del total se realiza aplicando el IVA definido en
 * {@link ConstantesFactura}.
 *
 * @see Cliente
 * @see LineaFactura
 * @see ConstantesFactura
 *
 * @author Alumno
 * @version 1.0
 * @since 1.0
 */
public class Factura {

    private final Cliente cliente;
    private final List<LineaFactura> lineas = new ArrayList<>();

    /**
     * Crea una nueva factura asociada a un cliente.
     *
     * @param cliente cliente al que se emite la factura
     * @throws IllegalArgumentException si el cliente es {@code null}
     */
    public Factura(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser null");
        }

        this.cliente = cliente;
    }

    /**
     * Añade una línea a la factura.
     *
     * Si se supera el límite definido en
     * {@link ConstantesFactura#MAX_LINEAS_FACTURA},
     * se lanza una excepción.
     *
     * @param linea línea de factura que se desea agregar
     * @throws IllegalStateException si se ha alcanzado el número máximo
     *                               de líneas permitidas
     */
    public void agregarLinea(LineaFactura linea) {
        if (lineas.size() >= ConstantesFactura.MAX_LINEAS_FACTURA) {
            throw new IllegalStateException("No se pueden añadir más líneas a la factura");
        }

        lineas.add(linea);
    }

    /**
     * Calcula el total de la factura aplicando el IVA general.
     *
     * El cálculo realizado es:
     * {@code sumaSubtotales × (1 + IVA_GENERAL)}.
     *
     * @return importe total de la factura con impuestos incluidos
     */
    public double calcularTotal() {
        double totalSinIva = 0;

        for (LineaFactura linea : lineas) {
            totalSinIva += linea.calcularSubtotal();
        }

        return totalSinIva * (1 + ConstantesFactura.IVA_GENERAL);
    }

    /**
     * Obtiene el cliente asociado a la factura.
     *
     * @return cliente al que se emite la factura
     */
    public Cliente getCliente() {
        return cliente;
    }
}
