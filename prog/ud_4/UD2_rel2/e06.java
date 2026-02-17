package prog.ud_4.UD2_rel2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class e06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final ArrayList<String> tareas = new ArrayList<>(Arrays.asList("tarea1", "tarea2", "tarea3"));
        final ArrayList<Boolean> completadas = new ArrayList<>(Arrays.asList(false, true, false));
        ArrayList<String> hechas = new ArrayList<>();
        ArrayList<String> pendientes = new ArrayList<>();

        String tareaBuscar, tareaNueva;
        String arrayMostrable = "", menu;
        boolean tareaEncontrada = false;

        int opcionMenu = 0;

        while (opcionMenu != 5) {
            menu = """
                    \n1. Añadir tarea.
                    2. Marcar completada.
                    3. Ver pendientes.
                    4. Ver completadas.
                    5. Salir.
                        """;

            if (opcionMenu == 1) {

                System.out.println("Nueva tarea: ");
                tareaNueva = scanner.nextLine();
                tareas.add(tareaNueva);
                completadas.add(false);

                System.out.println(tareas);
                System.out.println(completadas);
            } else if (opcionMenu == 2) {
                System.out.println("Nombre de la tarea: ");
                tareaBuscar = scanner.nextLine();

                for (int i = 0; i < tareas.size() && !tareaEncontrada; i++) {
                    if (tareas.get(i).equals(tareaBuscar)) {
                        tareaEncontrada = true;
                        completadas.set(i, tareaEncontrada);
                    }
                }

                if (!tareaEncontrada) {
                    System.out.println("No encontrada");
                }

                System.out.println(tareas);
                System.out.println(completadas);

            } else if (opcionMenu == 3) {

                for (int i = 0; i < completadas.size(); i++) {
                    if (!completadas.get(i)) {
                        pendientes.add(tareas.get(i));
                    }
                }

                for (String pendiente : pendientes) {
                    arrayMostrable += pendiente + "|";
                }

                arrayMostrable = arrayMostrable.substring(0, arrayMostrable.length() - 1);
                System.out.println("Pendientes: " + arrayMostrable);

            } else if (opcionMenu == 4) {

                for (int i = 0; i < completadas.size(); i++) {
                    if (completadas.get(i)) {
                        hechas.add(tareas.get(i));
                    }
                }

                for (String hecha : hechas) {
                    arrayMostrable += hecha + " | ";
                }

                arrayMostrable = arrayMostrable.substring(0, arrayMostrable.length() - 1);
                System.out.println("Hechas: " + arrayMostrable);
            }

            System.out.println(menu);

            opcionMenu = Integer.parseInt(scanner.nextLine());
        }

        scanner.close();
        System.out.println("Programa terminado.");
    }
}
