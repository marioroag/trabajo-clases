package es.stemgranada.ed.javadoc.soluciones.nivel3;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un pedido compuesto por una colección de productos.
 *
 * El cálculo del total se realiza aplicando los límites definidos
 * en {@link ConstantesPedido}.
 *
 * @see ConstantesPedido
 *
 * @author Alumno
 * @version 1.0
 * @since 1.0
 */
public class Pedido {

    private final List<String> productos = new ArrayList<>();

    /**
     * Añade un producto al pedido.
     *
     * Si el número máximo de productos definidos en
     * {@link ConstantesPedido#MAX_PRODUCTOS} se supera,
     * se lanza una excepción.
     *
     * @param nombreProducto nombre del producto que se desea añadir
     * @throws IllegalStateException si ya se ha alcanzado el número máximo
     *                               de productos permitidos
     */
    public void agregarProducto(String nombreProducto) {
        if (productos.size() >= ConstantesPedido.MAX_PRODUCTOS) {
            throw new IllegalStateException("No se pueden añadir más productos");
        }

        productos.add(nombreProducto);
    }

    /**
     * Obtiene la lista de productos incluidos en el pedido.
     *
     * @return lista de nombres de productos
     */
    public List<String> getProductos() {
        return productos;
    }

    /**
     * Calcula el total del pedido aplicando el IVA.
     *
     * El cálculo realizado es:
     * {@code numeroProductos × precioUnitario × (1 + IVA)}.
     *
     * @param precioUnitario precio de cada producto
     * @return importe total del pedido con impuestos incluidos
     */
    public double calcularTotal(double precioUnitario) {
        return productos.size() * precioUnitario * (1 + ConstantesPedido.IVA);
    }
}
