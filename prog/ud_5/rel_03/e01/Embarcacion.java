package prog.ud_5.rel_03.e01;

import java.util.ArrayList;
import java.util.Arrays;

public class Embarcacion {
    // [ Atributos ]
    private String matricula;
    private String nombre;
    private double eslora;
    private String tipo;
    private String propietario;
    private int anioFabricacion;
    public double valorEstimado;

    // [ Tipos de embarcacion ]
    ArrayList<String> tiposValidos = new ArrayList(
            Arrays.asList("Velero", "Lancha", "Yate", "Catamarán", "Moto de agua"));

    // [ Constructor ]
    // IMPORTANTE, NO USAR SETTERS EN PUBLICOS, CAMBIAR ESTO <-------------
    public Embarcacion(String matricula, String nombre, double eslora, String tipo, String propietario,
            int anioFabricacion, double valorEstimado, ArrayList<String> tiposValidos) {
        setMatricula(matricula);
        setNombre(nombre);
        setEslora(eslora);
        setTipo(tipo);
        setPropietario(propietario);
        setAnioFabricacion(anioFabricacion);
        setValorEstimado(valorEstimado);
    }

    // [ Getter y Setters ]
    public String getMatricula() {
        return matricula;
    }

    // No puede estar vacío
    public boolean setMatricula(String matricula) {
        boolean exito = false;

        if (!matricula.isBlank() || matricula == null) {
            this.matricula = matricula;
            exito = true;
        }

        return exito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getEslora() {
        return eslora;
    }

    // Debe ser mayor que 0
    public boolean setEslora(double eslora) {
        boolean exito = false;

        if (eslora > 0) {
            this.eslora = eslora;
            exito = true;
        }

        return exito;
    }

    public String getTipo() {
        return tipo;
    }

    // Tipo solo puede ser uno de:
    // "Velero", "Lancha", "Yate", "Catamarán", "Moto de agua"
    public boolean setTipo(String tipo) {
        boolean exito = false;

        if (tiposValidos.contains(tipo)) {
            this.tipo = tipo;
            exito = true;
        }

        return exito;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    // Debe estar entre 1950 y 2026
    public boolean setAnioFabricacion(int anioFabricacion) {
        boolean exito = false;

        if (anioFabricacion >= 1950 && anioFabricacion <= 2026) {
            this.anioFabricacion = anioFabricacion;
            exito = true;
        }

        return exito;
    }

    public boolean setValorEstimado(double valorEstimado) {
        boolean exito = false;

        if (valorEstimado >= 0) {
            this.valorEstimado = valorEstimado;
            exito = true;
        } else {
            this.valorEstimado = 0;
        }

        return exito;
    }

}
