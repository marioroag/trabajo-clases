package prog.ud_6.rel_01.e03;

public class Domestico extends Animal {
    private String duenio;

    public Domestico(String nombre, String tipoAlimentacion, String duenio) {
        super(nombre, tipoAlimentacion);
        this.duenio = duenio;
    }

    public String convivirConHumanos() {
        return "El animal doméstico " + getNombre() + " convive con su dueño " + duenio + " y se alimenta de "
                + getTipoAlimentacion();
    }

    public String getDuenio() {
        return duenio;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }

    @Override
    public String toString() {
        return getNombre() + " con dueño: " + duenio + " se alimenta de " + getTipoAlimentacion();
    }

}
