package prog.ud_6.rel_01.e15;

public class Asistente extends Empleado {
    public int horasExtras;

    public Asistente(double sueldoBase, String nombre, int horasExtras) {
        super(sueldoBase, nombre);
        this.horasExtras = horasExtras;
    }

    @Override
    public double calcularSueldo() {
        return sueldoBase + horasExtras;
    }

}
