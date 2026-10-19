// EJERCICIO 2 - Sistema de Gestión de Empleados

class Empleado {
    String nombre;
    double sueldoBase;

    Empleado(String nombre, double sueldoBase) {
        this.nombre = nombre;
        this.sueldoBase = sueldoBase;
    }
}

class Programador extends Empleado {
    Programador(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
    }

    public double calcularSueldo() {
        double resultado = sueldoBase * 1.3; // bonificacion 30%
        return resultado;
    }
}

class Diseñador extends Empleado {
    Diseñador(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
    }

    public double calcularSueldo() {
        double resultado = sueldoBase * 1.2; // bonificacion 20%
        return resultado;
    }
}

class Gerente extends Empleado {
    Gerente(String nombre, double sueldoBase) {
        super(nombre, sueldoBase);
    }

    public double calcularSueldo() {
        double resultado = sueldoBase * 1.5; // bonificacion 50%
        return resultado;
    }
}

public class Ejercicio02 {
    public static void main(String[] args) {
        Programador p = new Programador("Luis", 2000);
        Diseñador d = new Diseñador("Ana", 1800);
        Gerente g = new Gerente("Carlos", 3000);

        System.out.println(p.nombre + ": " + p.calcularSueldo());
        System.out.println(d.nombre + ": " + d.calcularSueldo());
        System.out.println(g.nombre + ": " + g.calcularSueldo());
    }
}
