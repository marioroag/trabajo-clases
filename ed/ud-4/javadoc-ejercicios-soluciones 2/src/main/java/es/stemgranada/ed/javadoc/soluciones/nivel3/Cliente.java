package es.stemgranada.ed.javadoc.soluciones.nivel3;

/**
 * Representa a un cliente del sistema de facturación.
 *
 * Cada {@link Factura} se emite para un cliente concreto.
 *
 * @see Factura
 *
 * @author Alumno
 * @version 1.0
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
