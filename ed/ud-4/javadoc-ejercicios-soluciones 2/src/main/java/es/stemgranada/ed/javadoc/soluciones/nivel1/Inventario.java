package es.stemgranada.ed.javadoc.soluciones.nivel1;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona una colección de productos disponibles en un inventario.
 *
 * Permite añadir productos, buscar por su código identificador y
 * consultar el número total de productos registrados.
 *
 * @author Alumno
 * @since 1.0
 */
public class Inventario {

    private final List<Producto> productos = new ArrayList<>();

    /**
     * Añade un producto al inventario.
     *
     * @param producto producto que se desea registrar
     * @throws IllegalArgumentException si el producto es {@code null}
     */
    public void agregarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser null");
        }

        productos.add(producto);
    }

    /**
     * Busca un producto en el inventario a partir de su código.
     *
     * @param codigo identificador del producto que se desea localizar
     * @return el producto correspondiente si existe, o {@code null}
     *         si no se encuentra registrado
     */
    public Producto buscarPorCodigo(String codigo) {
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }

        return null;
    }

    /**
     * Obtiene el número total de productos almacenados en el inventario.
     *
     * @return cantidad de productos registrados
     */
    public int totalProductos() {
        return productos.size();
    }
}
