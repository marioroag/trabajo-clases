package prog.ud_6.rel_01.e14;

// ### 14. Productos en una Tienda Online
// **Enunciado:**  
// Crea una **clase abstracta** `Producto` con los atributos `nombre` y `precio`, y un método abstracto `toString()`. 
// Luego, crea dos clases concretas: `Electronico` y `Ropa`. 
// La clase `Electronico` debe tener un atributo adicional `garantia` y su método `toString()` debe devolver una cadena con los detalles del producto electrónico. 
// La clase `Ropa` debe tener un atributo adicional `talla` y su método `toString()` debe devolver una cadena con los detalles de la prenda de ropa.  

// Implementa una clase `Main` para probar la creación de objetos y la llamada al método `toString()`.

public class Main {
    public static void main(String[] args) {

        Electronico termomix = new Electronico(3, "TERMOMIX", 699.99);
        Ropa baniador = new Ropa("M", "Bañador", 9.99);

        System.out.println(termomix);
        System.out.println(baniador);

    }
}
