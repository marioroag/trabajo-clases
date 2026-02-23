package prog.ud_5.rel_03.e01;

import java.util.ArrayList;
import java.util.Arrays;

public class Amarre {
    // [ Atributos ]
    private static int numeroAmarre;
    private int numero;
    private double longitudMaxima;
    private boolean ocupado;
    // Cambio a variables privadas
    private String tipoAmarre;
    private double precioDia;

    // Tipos de amarre
    ArrayList<String> tiposValidos = new ArrayList<>(Arrays.asList("normal", "premium", "megayate"));

    // [ Constructor ]
    // IMPORTANTE, NO USAR SETTERS EN PUBLICOS, CAMBIAR ESTO <-------------
    public Amarre(double longitudMaxima, String tipoAmarre) {
        asignarAmarre();
        setLongitudMaxima(longitudMaxima);
        // Un nuevo amarre siempre empezará libre
        setOcupado(false);
        setTipoAmarre(tipoAmarre);

        calcularPrecioDia();
    }

    // [ Getters y setters ]
    public int getNumero() {
        return numero;
    }

    // Debe ser positivo
    public boolean setNumero(int numero) {
        boolean exito = false;

        if (numero > 0) {
            this.numero = numero;
            exito = true;
        }

        return exito;
    }

    public void asignarAmarre() {
        this.numero = numeroAmarre;
        numeroAmarre++;
    }

    public double getLongitudMaxima() {
        return longitudMaxima;
    }

    // Debe ser mayor que 4
    public boolean setLongitudMaxima(double longitudMaxima) {
        boolean exito = false;

        if (longitudMaxima >= 4.0) {
            this.longitudMaxima = longitudMaxima;
            calcularPrecioDia();
            exito = true;
        } else {
            // Valores por defecto al fallar el mínimo requerido
            this.longitudMaxima = -1;
            this.precioDia = -1;
        }

        return exito;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public String getTipoAmarre() {
        return tipoAmarre;
    }

    // Debe estar en los tipos validos
    public boolean setTipoAmarre(String tipoAmarre) {
        boolean exito = false;

        if (tiposValidos.contains(tipoAmarre.toLowerCase())) {
            this.tipoAmarre = tipoAmarre;
            // Recalcula el precio diario al cambiar de tipo
            calcularPrecioDia();
            exito = true;
        }
        return exito;
    }

    public double getPrecioDia() {
        return precioDia;
    }

    // [ Metodos ]
    // Calcula el precio del día
    // Es privado porque solo se debe llamar desde el constructor
    public double calcularPrecioDia() {
        if (tipoAmarre.equals(tiposValidos.get(0))) { // Normal
            precioDia = 25 + (1.5 * longitudMaxima);
        } else if (tipoAmarre.equals(tiposValidos.get(1))) { // Premium
            precioDia = 60 + (2.2 * longitudMaxima);
        } else if (tipoAmarre.equals(tiposValidos.get(2))) { // Megayate
            precioDia = 120 + (3.5 * longitudMaxima);
        } else {
            E01.imprimirMensaje("Tipo de amarre no tiene formula de precio de día todavía");
        }

        return precioDia;
    }

    @Override
    public String toString() {
        String mostrarOcupado = "Ocupado";
        if (!ocupado) {
            mostrarOcupado = "Libre";
        }
        return "Amarre Nº" + numero + " | Max. Longitud: " + longitudMaxima + "m | " + mostrarOcupado
                + " | Tipo de amarre: " + tipoAmarre + " | Costo diario: " + precioDia;
    }
}