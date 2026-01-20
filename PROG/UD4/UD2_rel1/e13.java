package UD2_rel1;

import java.util.ArrayList;
import java.util.Arrays;

public class e13 {
    public static void main(String[] args) {
        ArrayList<Character> letras = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd'));
        ArrayList<Character> arrayInvertido = new ArrayList<>();
        Character recordarLetra = 'x';

        while (letras.size() > 0) {
            recordarLetra = letras.removeLast();
            arrayInvertido.add(recordarLetra);
        }

        System.out.println(arrayInvertido);
    }
}
