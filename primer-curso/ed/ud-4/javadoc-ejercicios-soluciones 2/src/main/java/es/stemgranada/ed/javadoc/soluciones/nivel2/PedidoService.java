package es.stemgranada.ed.javadoc.soluciones.nivel2;

/**
 * Servicio encargado de la creación de pedidos para clientes.
 *
 * Esta clase actúa como una pequeña API interna que centraliza
 * la instanciación de {@link Pedido}.
 *
 * @see Cliente
 * @see Pedido
 *
 * @author Alumno
 * @since 1.0
 */
public class PedidoService {

    /**
     * Crea un nuevo pedido asociado al cliente indicado.
     *
     * @param cliente cliente para el que se genera el pedido
     * @return nuevo pedido creado para el cliente
     */
    public Pedido crearPedidoParaCliente(Cliente cliente) {
        return new Pedido(cliente);
    }

    /**
     * Crea un pedido utilizando la API antigua.
     *
     * @deprecated usar {@link #crearPedidoParaCliente(Cliente)} en su lugar.
     *
     * @param cliente cliente para el que se genera el pedido
     * @return nuevo pedido creado para el cliente
     */
    @Deprecated
    public Pedido crearPedido(Cliente cliente) {
        return new Pedido(cliente);
    }
}
