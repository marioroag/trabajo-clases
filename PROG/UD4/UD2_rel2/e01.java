package UD2_rel2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class e01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int DIAS_SEMANA = 7;

        ArrayList<Integer> temperaturas = new ArrayList<>();
        int temperaturaSolicitada = 0, temperaturaMaxima = 0, temperaturaMinima = 0, temperaturaMedia = 0;

        int opcion = 0;

        boolean salirBucle = false;

        for (int i = 0; i < DIAS_SEMANA; i++) {
            System.out.println("Introduzca la temperatura del dia nº " + (i + 1));
            temperaturaSolicitada = Integer.parseInt(scanner.nextLine());

            // Control
            while (temperaturaSolicitada < -270 || temperaturaSolicitada > 100) {
                temperaturaSolicitada = Integer.parseInt(scanner.nextLine());
            }

            // Temperatura correcta asi que la introduce al array
            temperaturas.set(i, temperaturaSolicitada);

            System.out.println(temperaturas);
        }
    }
}