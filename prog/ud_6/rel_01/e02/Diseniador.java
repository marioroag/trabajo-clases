package prog.ud_6.rel_01.e02;

class Diseniador extends Empleado {
    private final double BONIFICADOR = 1.5;

    public Diseniador(String nombre, double sueldoBase) {
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
        return "Diseñador: " + getNombre() + " cobra tras bonificacion " + calcularSueldo() + "€";
    }

}