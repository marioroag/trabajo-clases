package UD2_rel1;

import java.util.ArrayList;
import java.util.Arrays;

public class e15 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        while (!numeros.isEmpty()) {
            System.out.println(numeros);
            numeros.removeLast();
        }

        System.out.println("Array final: " + numeros);

    }
}
