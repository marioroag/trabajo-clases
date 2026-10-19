package prog.ud_4.ud2_rel1;

import java.util.ArrayList;
import java.util.Arrays;

public class e04 {
    public static void main(String[] args) {
        ArrayList<String> animales = new ArrayList<>(Arrays.asList("perro", "gato"));

        animales.add(0, "tortuga");
        animales.add(0, "loro");

        System.out.println(animales);

    }
}
