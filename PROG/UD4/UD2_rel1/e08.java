package UD2_rel1;

import java.util.ArrayList;
import java.util.Arrays;

public class e08 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(100, 200, 300));
        ArrayList<Integer> primerNum = new ArrayList<>();

        primerNum.add(numeros.getFirst());

        numeros.set(0, numeros.get(2));
        numeros.set(2, primerNum.getFirst());

        System.out.println(numeros);
        System.out.println(primerNum);
    }
}
