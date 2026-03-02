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
        if (cantidad > 0) {
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
        // Código: A1B2C3 | Nombre: León | Cantidad: 3 | Precio: 25.00 €
        return "Código: " + codigo + " | Nombre: " + nombre + " | Cantidad: " + cantidad + " | Precio: " + precio
                + " €";
    }
}