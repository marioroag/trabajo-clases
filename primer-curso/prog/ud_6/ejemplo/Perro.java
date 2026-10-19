package prog.ud_6.ejemplo;

class Perro extends Animal {

    String raza;

    public Perro(String nombre, double peso, String raza) {
        super(nombre, peso);
        this.raza = raza;
    }

    void hacerSonido() {
        System.out.println("El perro hace un sonido");
    }

    void ladrar() {
        super.hacerSonido();
        System.out.println("GUAU");
    }

}