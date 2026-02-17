package prog.ud_4.UD2_rel1;

import java.util.ArrayList;
import java.util.Arrays;

public class e06 {
    public static void main(String[] args) {
        ArrayList<String> frutas = new ArrayList<>(Arrays.asList("manzana", "banana", "naranja"));

        frutas.remove(0);
        frutas.add("fresa");

        System.out.println(frutas);
    }
}
