package prog.ud_6.rel_01.e15;

public class Gerente extends Empleado {
    // bono` y su método `calcularSueldo()` debe devolver el sueldo base más el bono
    public double bono;

    public Gerente(double bono, String nombre, double sueldoBase) {
        super(sueldoBase, nombre);
        this.bono = bono;
    }

    @Override
    public double calcularSueldo() {
        return bono + sueldoBase;
    }
}
