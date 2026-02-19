package es.stemgranada.ed.javadoc.soluciones.nivel2;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un pedido realizado por un {@link Cliente}.
 *
 * Un pedido mantiene una lista de nombres de productos asociados
 * y se crea habitualmente a través del {@linkplain PedidoService}.
 *
 * @see Cliente
 * @see PedidoService
 *
 * @author Alumno
 * @since 1.0
 */
public class Pedido {

    private final Cliente cliente;
    private final List<String> productos = new ArrayList<>();

    /**
     * Crea un pedido para el cliente indicado.
     *
     * @param cliente cliente al que se asocia el pedido
     * @throws IllegalArgumentException si el cliente es {@code null}
     */
    public Pedido(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser null");
        }

        this.cliente = cliente;
    }

    /**
     * Obtiene el cliente asociado al pedido.
     *
     * @return cliente propietario del pedido
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Añade un producto al pedido.
     *
     * @param nombreProducto nombre del producto que se desea agregar
     */
    public void agregarProducto(String nombreProducto) {
        productos.add(nombreProducto);
    }

    /**
     * Obtiene la lista de productos incluidos en el pedido.
     *
     * La colección devuelta corresponde a la lista interna
     * utilizada por el pedido.
     *
     * @return lista de nombres de productos
     */
    public List<String> getProductos() {
        return productos;
    }
}
