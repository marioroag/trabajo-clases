package prog.ud_5.pt5;

public class Animal {

    // [ Variables ]
    private static int numeroAnimales;

    private String codigo;
    private String nombre;
    private int cantidad;
    private double precio;

    // [ Constructor ]
    public Animal(String nombre, int cantidad, double precio) {
        setNombre(nombre);
        setCodigo();

        // Setteo solo a -1 en el constructor para indicar que es un valor erroneo
        // No se hace en el setter para si se va a poner un valor erroneo despues de
        // crear el animal directamente no se cambie en vez de poner un numero negativo
        if (cantidad >= 0) {
            setCantidad(cantidad);
        } else {
            this.cantidad = -1;
        }

        if (precio >= 0) {
            setPrecio(precio);

        } else {
            this.precio = -1;
        }
    }

    public Animal(String codigo, String nombre, int cantidad, double precio) {
        this(nombre, cantidad, precio);
        setCodigo(codigo);
    }

    // [ Getter y Setters ]
    public String getNombre() {
        return nombre;
    }

    /**
     * Solo permite el nombre si no esta vacio ni es nulo
     * 
     * En caso contrario el nombre se queda como null para saber que es erroneo
     * 
     * @param nombre
     * @return
     */
    public boolean setNombre(String nombre) {
        boolean exito = false;
        if (nombre != null && !nombre.isBlank()) {
            this.nombre = nombre;
            exito = true;
        }

        return exito;
    }

    public String getCodigo() {
        return codigo;
    }

    /**
     * Si no recibe un código en el constructor genera uno propio segun el numero de
     * objetos diferentes
     */
    public void setCodigo() {
        this.codigo = "Z-" + numeroAnimales;
        numeroAnimales++;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    /**
     * Solo cambia la cantidad si es un número positivo (no se pueden tener animales
     * negativos)
     * 
     * @param cantidad
     * @return Booleano de exito
     */
    public boolean setCantidad(int cantidad) {
        boolean exito = false;

        if (cantidad >= 0) {
            this.cantidad = cantidad;
            exito = true;
        }

        return exito;
    }

    public double getPrecio() {
        return precio;
    }

    /**
     * Solo cambia el precio si es un número positivo
     * 
     * @param precio
     * @return Booleano de exito
     */
    public boolean setPrecio(double precio) {
        boolean exito = false;

        if (precio >= 0) {
            this.precio = precio;
            exito = true;
        }

        return exito;
    }

    // [ toString ]
    @Override
    public String toString() {
        return "Código: " + codigo + " | Nombre: " + nombre + " | Cantidad: " + cantidad + " | Precio: " + precio
                + " €";
    }
}