package prog.ud_5.rel_02.e03;

/*
 * Ejercicio 3: Supermercado y Productos
 * 
 * Crea una clase Producto con atributos id, nombre, descripción, precio y
 * cantidadEnStock. Implementa los métodos get y set para cada atributo, así
 * como el método toString(). Luego, crea una clase Supermercado con un array de
 * productos y métodos para:
 * 
 * Agregar productos
 * Vender un producto (reducir cantidadEnStock)
 * Mostrar el inventario
 * En el main, implementa un menú para vender y reponer productos. Usa la clase
 */

public class Producto {
    private String id, nombre, descripcion;
    private int cantidadEnStock;
    private double precio;

    // Es static porque pertenece a la clase no al objeto
    private static int numeroProductos = 0;

    public Producto(String nombre, String descripcion, double precio, int cantidadEnStock) {
        setID(String.valueOf(numeroProductos));
        this.nombre = nombre;
        this.descripcion = descripcion;
        setPrecio(precio);
        setCantidad(cantidadEnStock);
        numeroProductos++;
    }

    public Producto() {
        this.id = null;
        this.nombre = null;
        this.descripcion = null;
        this.precio = 0;
        this.cantidadEnStock = 0;
    }

    // Privado porque solo se usa cuando se crea el objeto
    private void setID(String nuevoID) {
        this.id = "P-" + nuevoID;
    }

    public String getId() {
        return id;
    }

    public void setNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDescripcion(String nuevoDescripcion) {
        this.descripcion = nuevoDescripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean setPrecio(double nuevoPrecio) {
        boolean precioCorrecto = false;
        if (nuevoPrecio >= 0) {
            this.precio = nuevoPrecio;
            precioCorrecto = true;
        }

        return precioCorrecto;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean setCantidad(int nuevoCantidad) {
        boolean cantidadCorrecto = false;
        if (nuevoCantidad >= 0) {
            this.cantidadEnStock = nuevoCantidad;
            cantidadCorrecto = true;
        }

        return cantidadCorrecto;
    }

    public int getCantidad() {
        return cantidadEnStock;
    }

    @Override
    public String toString() {
        return "[ " + nombre + ": " + descripcion + ", Unidades: "
                + cantidadEnStock + ", Precio: " + precio + "€ ]";
    }
}
