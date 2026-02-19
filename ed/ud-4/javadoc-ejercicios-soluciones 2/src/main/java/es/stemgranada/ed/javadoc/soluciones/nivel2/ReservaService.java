package es.stemgranada.ed.javadoc.soluciones.nivel2;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio encargado de gestionar el registro y la creación de reservas.
 *
 * Actúa como una pequeña API interna que centraliza la interacción
 * con objetos {@link Reserva}.
 *
 * @see Sala
 * @see Reserva
 *
 * @author Alumno
 * @since 1.0
 */
public class ReservaService {

    private final List<Reserva> reservas = new ArrayList<>();

    /**
     * Registra una reserva existente en el sistema.
     *
     * @param reserva reserva que se desea añadir
     */
    public void registrarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    /**
     * Crea una reserva utilizando la API antigua y la registra internamente.
     *
     * @deprecated usar {@link #registrarReserva(Reserva)} junto con el
     *             constructor de {@link Reserva}.
     *
     * @param sala    sala que se desea reservar
     * @param cliente nombre del cliente que realiza la reserva
     * @return reserva creada y registrada
     */
    @Deprecated
    public Reserva crearReserva(Sala sala, String cliente) {
        Reserva reserva = new Reserva(sala, cliente);
        reservas.add(reserva);
        return reserva;
    }

    /**
     * Obtiene la lista de reservas registradas.
     *
     * La colección devuelta corresponde a la lista interna
     * utilizada por el servicio.
     *
     * @return lista de reservas
     */
    public List<Reserva> getReservas() {
        return reservas;
    }
}
