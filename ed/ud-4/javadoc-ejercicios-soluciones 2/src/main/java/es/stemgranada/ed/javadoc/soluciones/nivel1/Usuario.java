package es.stemgranada.ed.javadoc.soluciones.nivel1;

/**
 * Representa a un usuario del sistema identificado por su nombre
 * y su documento nacional de identidad.
 *
 * La clase es inmutable: sus datos se establecen en el constructor
 * y no pueden modificarse posteriormente.
 *
 * @author Alumno
 * @since 1.0
 */
public class Usuario {

    private final String nombre;
    private final String dni;

    /**
     * Crea un nuevo usuario con los datos indicados.
     *
     * @param nombre nombre completo del usuario
     * @param dni    documento nacional de identidad del usuario
     * @throws IllegalArgumentException si el nombre o el DNI son nulos
     *                                  o están vacíos
     */
    public Usuario(String nombre, String dni) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        if (dni == null || dni.isBlank()) {
            throw new IllegalArgumentException("El DNI no puede estar vacío");
        }

        this.nombre = nombre;
        this.dni = dni;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return nombre completo del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el documento nacional de identidad del usuario.
     *
     * @return DNI del usuario
     */
    public String getDni() {
        return dni;
    }
}
