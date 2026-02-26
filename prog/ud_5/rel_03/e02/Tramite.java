package prog.ud_5.rel_03.e02;

import java.util.ArrayList;
import java.util.Arrays;

public class Tramite {
    private String codigo;
    private String nombreTramite;
    private double precioBase;
    private boolean requiereCita;
    private int duracionDias;

    // contador
    private static int cantidadCodigos;
    // Array de tipos
    private ArrayList<String> tiposCitas = new ArrayList<>(
            Arrays.asList("Trámite de extranjería", "Gestión de herencias", "Constitución de sociedad"));

    public Tramite(String nombreTramite, double precioBase, boolean requiereCita, int duracionDias) {
        setCodigo();
        this.nombreTramite = nombreTramite;
        setPrecioBase(precioBase);
        this.requiereCita = requiereCita;
        setDuracionDias(duracionDias);
    }

    public Tramite(String codigo, String nombreTramite, double precioBase, boolean requiereCita, int duracionDias) {
        setCodigo(codigo);
        this.nombreTramite = nombreTramite;
        setPrecioBase(precioBase);
        this.requiereCita = requiereCita;
        setDuracionDias(duracionDias);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo() {
        this.codigo = "TRM" + cantidadCodigos;
        cantidadCodigos++;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
        cantidadCodigos++;
    }

    public String getNombreTramite() {
        return nombreTramite;
    }

    public void setNombreTramite(String nombreTramite) {
        if (tiposCitas.contains(nombreTramite)) {
            this.requiereCita = true;
        }
        this.nombreTramite = nombreTramite;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public boolean setPrecioBase(double precioBase) {
        boolean exito = false;
        if (precioBase >= 0) {
            this.precioBase = precioBase;
            exito = true;
        } else {
            this.precioBase = -1;
        }
        return exito;
    }

    public boolean isRequiereCita() {
        return requiereCita;
    }

    public void setRequiereCita(boolean requiereCita) {
        this.requiereCita = true;
    }

    public int getDuracionDias() {
        return duracionDias;
    }

    public boolean setDuracionDias(int duracionDias) {
        boolean exito = false;
        if (duracionDias >= 1) {
            this.duracionDias = duracionDias;
            exito = true;
        }
        return exito;
    }

    @Override
    public String toString() {
        return "Tramite [codigo=" + codigo + ", nombreTramite=" + nombreTramite + ", precioBase=" + precioBase
                + ", requiereCita=" + requiereCita + ", duracionDias=" + duracionDias + "]";
    }

}
