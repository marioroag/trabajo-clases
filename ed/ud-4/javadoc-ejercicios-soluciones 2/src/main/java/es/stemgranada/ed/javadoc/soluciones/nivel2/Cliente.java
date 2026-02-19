package es.stemgranada.ed.javadoc.soluciones.nivel2;

/**
 * Representa a un cliente del sistema identificado mediante un id
 * y un nombre visible.
 *
 * Un {@link Pedido} siempre se asocia a un cliente concreto.
 *
 * @see Pedido
 * @see PedidoService
 *
 * @author Alumno
 * @since 1.0
 */
public class Cliente {

    private final String id;
    private final String nombre;

    /**
     * Crea un nuevo cliente con los datos indicados.
     *
     * @param id     identificador único del cliente
     * @param nombre nombre completo del cliente
     * @throws IllegalArgumentException si el id o el nombre son nulos
     *                                  o están vacíos
     */
    public Cliente(String id, String nombre) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El id no puede estar vacío");
        }

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador del cliente.
     *
     * @return id del cliente
     */
    public String getId() {
        return id;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }
}
