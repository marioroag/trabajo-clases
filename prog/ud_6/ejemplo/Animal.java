package prog.ud_6.ejemplo;

class Animal {
    private String nombre;
    private double peso;

    public Animal(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    void hacerSonido() {
        System.out.println("El animal hace un sonido");
    }

}