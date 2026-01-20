package UD2_rel1;

import java.util.ArrayList;
import java.util.Arrays;

public class e07 {
    public static void main(String[] args) {
        ArrayList<String> dias = new ArrayList<>(
                Arrays.asList("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"));
        dias.set(dias.indexOf("Domingo"), "Domingo (fin de semana)");
        System.out.println(String.join(" - ", dias));
    }
}