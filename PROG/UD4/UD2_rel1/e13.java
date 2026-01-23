package UD2_rel1;

import java.util.ArrayList;
import java.util.Arrays;

public class e13 {
    public static void main(String[] args) {
        ArrayList<Character> letras = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd'));
        ArrayList<Character> arrayInvertido = new ArrayList<>();
        for (Character letra : letras) {
            arrayInvertido.addFirst(letra);
        }

        System.out.println(arrayInvertido);
    }
}
