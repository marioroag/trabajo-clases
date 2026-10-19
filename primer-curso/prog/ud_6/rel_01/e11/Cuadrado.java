package prog.ud_6.rel_01.e11;

public class Cuadrado extends Figura {

    public double lado = 0;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public double calcularArea() {
        return lado * lado;
    }

}
