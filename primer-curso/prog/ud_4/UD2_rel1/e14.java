package prog.ud_4.ud2_rel1;

import java.util.ArrayList;
import java.util.Arrays;

public class e14 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(5, 10, 15, 20));

        numeros.add(numeros.removeFirst());
        System.out.println(numeros);
    }
}
