package es.stemgranada.ed.javadoc.soluciones.nivel2;

/**
 * Representa la reserva de una {@link Sala} para un cliente concreto.
 *
 * Las reservas suelen gestionarse mediante el {@linkplain ReservaService}.
 *
 * @see Sala
 * @see ReservaService
 *
 * @author Alumno
 * @since 1.0
 */
public class Reserva {

    private final Sala sala;
    private final String nombreCliente;

    /**
     * Crea una nueva reserva para la sala indicada y el cliente especificado.
     *
     * @param sala          sala que se reserva
     * @param nombreCliente nombre del cliente que realiza la reserva
     * @throws IllegalArgumentException si la sala es {@code null}
     *                                  o el nombre del cliente es nulo o está vacío
     */
    public Reserva(Sala sala, String nombreCliente) {
        if (sala == null) {
            throw new IllegalArgumentException("La sala no puede ser null");
        }

        if (nombreCliente == null || nombreCliente.isBlank()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío");
        }

        this.sala = sala;
        this.nombreCliente = nombreCliente;
    }

    /**
     * Obtiene la sala asociada a la reserva.
     *
     * @return sala reservada
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * Obtiene el nombre del cliente que realizó la reserva.
     *
     * @return nombre del cliente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }
}
