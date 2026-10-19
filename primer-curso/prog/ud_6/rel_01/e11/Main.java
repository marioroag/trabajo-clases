package prog.ud_6.rel_01.e11;
// Crea una **clase abstracta** `Figura` que tenga un método abstracto `calcularArea()`. Luego, crea dos clases concretas: `Triangulo` y `Cuadrado`. La clase `Triangulo` debe tener los atributos `base` y `altura`, y su método `calcularArea()` debe devolver el área del triángulo. La clase `Cuadrado` debe tener el atributo `lado`, y su método `calcularArea()` debe devolver el área del cuadrado. 

public class Main {
    public static void main(String[] args) {

        Triangulo triangulo = new Triangulo(2, 4);
        Cuadrado cuadrado = new Cuadrado(5.69);

        System.out.println(triangulo.calcularArea());
        System.out.println(cuadrado.calcularArea());
        
    }
}
