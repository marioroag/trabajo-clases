package prog.ud_6.rel_01.e12;
// ### 12. Vehículos con Métodos Abstractos

// **Enunciado:**  
// Crea una **clase abstracta** `Vehiculo` que tenga los métodos abstractos `arrancar()` y `detener()`.
//  Luego, crea dos clases concretas: `Moto` y `Camion`. 
// La clase `Moto` debe implementar los métodos `arrancar()` y `detener()` con el comportamiento específico de una motocicleta. 
// La clase `Camion` debe implementar los métodos `arrancar()` y `detener()` con el comportamiento específico de un camión.  

public class Main {

    public static void main(String[] args) {

        Moto motillo = new Moto();
        Camion trailer = new Camion();

        System.out.println(motillo.arrancar());
        System.out.println(motillo.detener());

        System.out.println("--------------------");

        System.out.println(trailer.arrancar());
        System.out.println(trailer.detener());
        
    }

}
