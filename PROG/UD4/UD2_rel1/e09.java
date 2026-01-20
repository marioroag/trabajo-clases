package UD2_rel1;

import java.util.ArrayList;
import java.util.Arrays;

public class e09 {
    public static void main(String[] args) {
        ArrayList<String> cola = new ArrayList<>(Arrays.asList("cliente1", "cliente2", "cliente3"));
        String arrayMostrar = "";

        for (String cliente : cola) {
            arrayMostrar += cliente + " ";
        }

        System.out.println("Cola de clientes: " + arrayMostrar);
        System.out.println("Longitud de cola: " + cola.size());

        System.out.println("Cliente atendido: " + cola.remove(0));
        System.out.println("Longitud de cola: " + cola.size());

        System.out.println("Cliente atendido: " + cola.remove(0));
        System.out.println("Longitud de cola: " + cola.size());

        System.out.println("Cliente atendido: " + cola.remove(0));
        System.out.println("Longitud de cola: " + cola.size());

        System.out.println("Array final: " + cola);
    }
}
