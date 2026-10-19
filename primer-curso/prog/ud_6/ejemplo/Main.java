package prog.ud_6.ejemplo;

public class Main {
    public static void main(String[] args) {

        Animal a = new Animal("Pepe", 5.5);
        a.hacerSonido();

        Perro p = new Perro("Sora", 15.5, "Podenco");
        p.ladrar();
    }

}
