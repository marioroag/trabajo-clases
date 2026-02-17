package prog.ud_4.UD2_rel1;

import java.util.ArrayList;
import java.util.Arrays;

public class e05 {
    public static void main(String[] args) {
        ArrayList<String> animales = new ArrayList<>(Arrays.asList("loro", "tortuga", "perro", "gato"));

        System.out.println(animales);

        ArrayList<String> eliminado = new ArrayList<String>();
        eliminado.add(animales.get(0));
        animales.remove(0);

        System.out.println(animales);
        System.out.println(eliminado);
    }
}
