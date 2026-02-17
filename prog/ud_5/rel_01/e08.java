package prog.ud_5.rel_01;

public class e08 {
    /*
     * Ejercicio 8: Clase Televisor
     * 
     * Crea una clase Televisor con atributos canalActual y volumen. Agrega métodos
     * subirVolumen(), bajarVolumen(), cambiarCanal(nuevoCanal), y toString() que
     * muestre el canal y volumen actuales.
     */

    public static void main(String[] args) {
        Televisor tv1 = new Televisor(0, "Nada");

        System.out.println(tv1);
        tv1.subirVolumen(10);
        System.out.println(tv1);
        tv1.bajarVolumen(5);
        tv1.cambiarCanal("DMAX");
        System.out.println(tv1);
        tv1.cambiarCanal("FDF");
        System.out.println(tv1);

    }

}

class Televisor {
    int volumen = 0;
    String canalActual;

    Televisor(int volumen, String canalActual) {
        this.volumen = volumen;
        this.canalActual = canalActual;
    }

    void subirVolumen(int cantidad) {
        this.volumen += cantidad;
    }

    void bajarVolumen(int cantidad) {
        this.volumen -= cantidad;

    }

    void cambiarCanal(String nuevoCanal) {
        this.canalActual = nuevoCanal;
    }

    @Override
    public String toString() {
        String mostrarTel;
        mostrarTel = "Volumen: " + this.volumen + " | Canal: " + this.canalActual;
        return mostrarTel;
    }
}