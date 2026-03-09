package prog.ud_6.rel_01.e03;

public class Salvaje extends Animal {
    private String habitat;

    public Salvaje(String nombre, String tipoAlimentacion, String habitat) {
        super(nombre, tipoAlimentacion);
        this.habitat = habitat;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    @Override
    public String toString() {
        return getNombre() + " del habitat " + habitat + " se alimenta de " + getTipoAlimentacion();
    }

    public String cazar() {
        return "El animal salvaje " + getNombre() + " caza en su hábitat " + habitat + " y se alimenta de "
                + getTipoAlimentacion();
    }

}
