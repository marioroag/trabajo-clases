package UD2_rel1;

import java.util.ArrayList;
import java.util.Arrays;

public class e05 {
    public static void main(String[] args) {
        ArrayList<String> animales = new ArrayList<String>();
        animales.addAll(Arrays.asList("perro", "gato"));

        ArrayList<String> eliminado = new ArrayList<String>();

        eliminado.add(animales.get(0));
        animales.remove(0);
        eliminado.add(animales.get(0));
        animales.remove(0);
    }
}
