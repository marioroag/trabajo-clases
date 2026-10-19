package es.stemgranada.ed.javadoc.soluciones.nivel2;

/**
 * Representa una sala disponible para reservas dentro del sistema.
 *
 * Cada {@link Reserva} se asocia a una sala concreta y queda registrada
 * a través del {@linkplain ReservaService}.
 *
 * @see Reserva
 * @see ReservaService
 *
 * @author Alumno
 * @since 1.0
 */
public class Sala {

    private final String codigo;
    private final int capacidad;

    /**
     * Crea una nueva sala con un código identificador y una capacidad máxima.
     *
     * @param codigo    identificador único de la sala
     * @param capacidad número máximo de personas admitidas
     * @throws IllegalArgumentException si el código es nulo o está vacío,
     *                                  o si la capacidad es menor o igual que cero
     */
    public Sala(String codigo, int capacidad) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código no puede estar vacío");
        }

        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que cero");
        }

        this.codigo = codigo;
        this.capacidad = capacidad;
    }

    /**
     * Obtiene el código identificador de la sala.
     *
     * @return código de la sala
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtiene la capacidad máxima de la sala.
     *
     * @return número de personas admitidas
     */
    public int getCapacidad() {
        return capacidad;
    }
}
