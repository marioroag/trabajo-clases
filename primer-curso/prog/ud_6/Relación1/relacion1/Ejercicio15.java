// EJERCICIO 15 - Empleados con Diferentes Roles

abstract class Empleado {
    String nombre;
    double sueldoBase;

    Empleado(String nombre, double sueldoBase) {
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
    }

    abstract double calcularSueldo();
}

class Gerente extends Empleado {
    double bono;

    Gerente(String nombre, double sueldoBase, double bono) {
        super(nombre, sueldoBase);
        this.bono = bono;
    }

    double calcularSueldo() {
        double resultado = sueldoBase + bono;
        return resultado;
    }
}

class Asistente extends Empleado {
    int horasExtras;

    Asistente(String nombre, double sueldoBase, int horasExtras) {
        super(nombre, sueldoBase);
        this.horasExtras = horasExtras;
    }

    double calcularSueldo() {
        double resultado = sueldoBase + (horasExtras * 15);  // 15€ por hora extra
        return resultado;
    }
}

public class Ejercicio15 {
    public static void main(String[] args) {
        Gerente g = new Gerente("Ana", 3000, 800);
        Asistente a = new Asistente("Pedro", 1500, 10);

        System.out.println(g.nombre + ": " + g.calcularSueldo());
        System.out.println(a.nombre + ": " + a.calcularSueldo());

        // Polimorfismo
        Empleado ref = g;
        System.out.println("Ref polimórfica: " + ref.calcularSueldo());
    }
}
