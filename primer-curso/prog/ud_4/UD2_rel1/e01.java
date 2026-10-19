package prog.ud_4.ud2_rel1;

import java.util.ArrayList;
import java.util.Arrays;

public class e01 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<Integer>(Arrays.asList(5, 10, 15, 20));
        // numeros.add(5);
        // numeros.add(10);
        // numeros.add(15);
        // numeros.add(20);

        System.out.println(numeros.get(0));
        System.out.println(numeros.get(numeros.size() - 1));
    }
}
