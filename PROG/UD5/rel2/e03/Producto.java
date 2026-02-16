package PROG.UD5.rel2.e03;

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
    private int cantidadEnStock = -1;
    private int precio = -1;

    public Producto(String id, String nombre, String descripcion, int precio, int cantidadEnStock) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadEnStock = cantidadEnStock;
    }

    public Producto() {
        this.id = null;
        this.nombre = null;
        this.descripcion = null;
        this.precio = 0;
        this.cantidadEnStock = 0;
    }

    public void setID(String nuevoID) {
        this.id = nuevoID;
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

    public void setPrecio(int nuevoPrecio) {
        this.precio = nuevoPrecio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setCantidad(int nuevoCantidad) {
        this.cantidadEnStock = nuevoCantidad;
    }

    public int getCantidad() {
        return cantidadEnStock;
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", cantidadEnStock="
                + cantidadEnStock + ", precio=" + precio + "]";
    }
}
