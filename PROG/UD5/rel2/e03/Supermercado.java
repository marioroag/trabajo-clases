package PROG.UD5.rel2.e03;

import java.util.ArrayList;

public class Supermercado {
    ArrayList<Producto> stockProductos;
    int idEnSupermercado;

    public Supermercado() {
        this.stockProductos = new ArrayList<>();
    }

    public void agregarProducto(Producto nuevoProducto) {
        stockProductos.add(nuevoProducto);
    }

    public void venderProducto(Producto productoVender, int cantidadVender) {
        if (productoVender.getCantidad() - cantidadVender >= 0) {
            productoVender.setCantidad((productoVender.getCantidad() - cantidadVender));
        } else {
            System.out.println("No puedes vender más unidades de las que dispones");
        }
    }

    public Producto buscarProducto(String idBuscar) {
        Producto productoEncontrado = null;
        boolean encontrado = false;
        for (int i = 0; i < stockProductos.size() && !encontrado; i++) {
            if (stockProductos.get(i).getId().contains(idBuscar)) {
                productoEncontrado = stockProductos.get(i);
                encontrado = true;
            }
        }

        return productoEncontrado;
    }

    @Override
    public String toString() {
        String stringProductos = "-- STOCK ACTUAL --\n";
        for (Producto nuevoProducto : stockProductos) {
            stringProductos += "\n" + nuevoProducto + "\n";
        }
        return stringProductos;
    }

}
