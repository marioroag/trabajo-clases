package es.stemgranada.ed.javadoc.soluciones.nivel3;

/**
 * Servicio encargado de la creación y consulta de pedidos.
 *
 * Proporciona una API para trabajar con instancias de {@link Pedido}.
 *
 * @see Pedido
 *
 * @author Alumno
 * @version 1.0
 * @since 1.0
 */
public class PedidoService {

    /**
     * Crea un pedido vacío.
     *
     * @return nueva instancia de {@link Pedido}
     */
    public Pedido crearPedido() {
        return new Pedido();
    }

    /**
     * Devuelve el total de un pedido aplicando un precio unitario.
     *
     * Este método delega el cálculo en {@link Pedido#calcularTotal(double)}.
     *
     * @param pedido         pedido del que se desea obtener el total
     * @param precioUnitario precio unitario de los productos
     * @return importe total del pedido
     */
    public double obtenerTotal(Pedido pedido, double precioUnitario) {
        return pedido.calcularTotal(precioUnitario);
    }
}
