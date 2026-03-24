package prog.ud_6.rel_01.e15;

public abstract class Empleado {
    public double sueldoBase;
    public String nombre;

    public Empleado(double sueldoBase, String nombre) {
        this.sueldoBase = sueldoBase;
        this.nombre = nombre;
    }

    public abstract double calcularSueldo();
}
