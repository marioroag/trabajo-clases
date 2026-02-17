package prog.ud_4.ud2_rel1;

import java.util.ArrayList;
import java.util.Arrays;

public class e10 {
    public static void main(String[] args) {
        ArrayList<Integer> pila = new ArrayList<>(Arrays.asList(10, 20, 30));

        System.out.println("Pila: " + pila);

        System.out.println("Extraigo: " + pila.remove(pila.size() - 1));
        System.out.println("Pila: " + pila);

        System.out.println("Extraigo: " + pila.remove(pila.size() - 1));
        System.out.println("Pila: " + pila);

        System.out.println("Extraigo: " + pila.remove(pila.size() - 1));
        System.out.println("Pila: " + pila);

    }
}
