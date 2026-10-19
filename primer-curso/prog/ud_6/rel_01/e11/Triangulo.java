package prog.ud_6.rel_01.e11;

public class Triangulo extends Figura {
    public int base;
    public int altura;

    public Triangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public double calcularArea() {
        return (base * altura) / 2;
    }

}
