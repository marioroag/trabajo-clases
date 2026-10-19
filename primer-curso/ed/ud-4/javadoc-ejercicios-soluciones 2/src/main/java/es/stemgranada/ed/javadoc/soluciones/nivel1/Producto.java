package es.stemgranada.ed.javadoc.soluciones.nivel1;

/**
 * Representa un producto identificable dentro de un inventario,
 * con un código único, un nombre descriptivo y un precio asociado.
 *
 * Permite consultar sus datos básicos y modificar su precio respetando
 * las validaciones establecidas.
 *
 * @author Alumno
 * @since 1.0
 */
public class Producto {

    private final String codigo;
    private final String nombre;
    private double precio;

    /**
     * Crea un nuevo producto con los datos indicados.
     *
     * @param codigo identificador único del producto
     * @param nombre nombre descriptivo del producto
     * @param precio precio inicial del producto
     * @throws IllegalArgumentException si el código o el nombre son nulos
     *                                  o están vacíos, o si el precio es negativo
     */
    public Producto(String codigo, String nombre, double precio) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("El código no puede estar vacío");
        }

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    /**
     * Obtiene el código del producto.
     *
     * @return identificador del producto
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return nombre descriptivo del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el precio actual del producto.
     *
     * @return precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Modifica el precio del producto.
     *
     * @param nuevoPrecio nuevo importe que se asignará al producto
     * @throws IllegalArgumentException si el nuevo precio es negativo
     */
    public void cambiarPrecio(double nuevoPrecio) {
        if (nuevoPrecio < 0) {
            throw new IllegalArgumentException("El nuevo precio no puede ser negativo");
        }

        this.precio = nuevoPrecio;
    }
}
