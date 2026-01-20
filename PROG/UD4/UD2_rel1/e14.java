package UD2_rel1;

import java.util.ArrayList;
import java.util.Arrays;

public class e14 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(5, 10, 15, 20));

        numeros.addFirst(numeros.removeLast());
        System.out.println(numeros);
    }
}
