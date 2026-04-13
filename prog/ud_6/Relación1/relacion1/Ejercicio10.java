// EJERCICIO 10 - Robots con Múltiples Capacidades

interface Movil {
    String moverse();
}

interface Trabajador {
    String realizarTarea();
}

class Robot implements Movil, Trabajador {
    String modelo;
    int capacidadBateria;

    Robot(String modelo, int capacidadBateria) {
        this.modelo = modelo;
        this.capacidadBateria = capacidadBateria;
    }

    public String moverse() {
        String resultado = "El Robot modelo " + modelo + " con batería " + capacidadBateria
                + "% se desplaza hacia el destino programado.";
        return resultado;
    }

    public String realizarTarea() {
        String resultado = "El Robot modelo " + modelo + " con batería " + capacidadBateria
                + "% realiza la tarea asignada eficientemente.";
        return resultado;
    }
}

public class Ejercicio10 {
    public static void main(String[] args) {
        Robot r = new Robot("RX-200", 85);

        System.out.println(r.moverse());
        System.out.println(r.realizarTarea());

        // Referencia por interface
        Movil refMovil = r;
        Trabajador refTrabajador = r;

        System.out.println(refMovil.moverse());
        System.out.println(refTrabajador.realizarTarea());
    }
}
