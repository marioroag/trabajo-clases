package prog.ud_5.rel1;

public class e07 {
    /*
     * Ejercicio 7: Clase Lampara
     * 
     * Crea una clase Lampara con un atributo estado (encendida o apagada). Agrega
     * métodos encender() y apagar() para cambiar su estado.
     */

    public static void main(String[] args) {
        Lampara lampara1 = new Lampara(false);

        System.out.println(lampara1);

        lampara1.encender();
        System.out.println(lampara1);

        lampara1.apagar();
        System.out.println(lampara1);
    }
}

class Lampara {
    boolean estado;

    Lampara(boolean estado) {
        this.estado = estado;
    }

    // Si no nos dan estado al crear la lampara el default es false
    Lampara() {
        this.estado = false;
    }

    void encender() {
        this.estado = true;
    }

    void apagar() {
        this.estado = false;
    }

    @Override
    public String toString() {
        String estadoLampara;

        if (this.estado) {
            estadoLampara = "La lámpara está encendida";
        } else {
            estadoLampara = "La lámpara está apagada";
        }

        return estadoLampara;
    }
}