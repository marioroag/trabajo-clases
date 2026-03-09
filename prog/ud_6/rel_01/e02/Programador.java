package prog.ud_6.rel_01.e02;

class Programador extends Empleado {
    private final double BONIFICADOR = 2;

    public Programador(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
    }

    public double getBONIFICADOR() {
        return BONIFICADOR;
    }

    public double calcularSueldo() {
        double sueldoFinal = getSueldoBase() * BONIFICADOR;

        return sueldoFinal;
    }

    @Override
    public String toString() {
        return "Programador: " + getNombre() + " cobra tras bonificacion " + calcularSueldo() + "€";
    }

}