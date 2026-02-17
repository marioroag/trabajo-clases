package prog.ud_4.UD2_rel1;

import java.util.ArrayList;
import java.util.Arrays;

public class e12 {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<>(Arrays.asList("Ana", "Pedro"));
        nombres.add(0, "Carlos");
        nombres.add("Laura");

        nombres.removeFirst();
        nombres.removeLast();

        System.out.println(nombres);
    }
}
