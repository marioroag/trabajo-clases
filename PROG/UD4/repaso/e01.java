package repaso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class e01 {
    /*
     * EJERCICIO 1 — TractoMatch
     * Objetivo
     * 
     * Gestionar un historial de tractores y evaluar si cada tractor es adecuado
     * para un tipo de trabajo agrícola.
     * Datos a almacenar (listas paralelas)
     * 
     * Marca (ArrayList<String>)
     * Potencia en CV (ArrayList<Integer>)
     * Trabajo (ArrayList<String>) → arado, transporte, siembra
     * 
     * Menú
     * 
     * 1. Añadir tractor
     * 
     * Pedir marca, potencia (CV) y tipo de trabajo.
     * Validar: potencia > 0 y trabajo válido (arado, transporte, siembra).
     * Guardar los 3 datos en sus ArrayList en la misma posición.
     * 
     * 2. Listar tractores
     * 
     * Mostrar todos los tractores con su índice.
     * Formato sugerido: 0 -> Marca | 110 CV | trabajo: transporte.
     * 
     * 3. Evaluar tractor (por índice)
     * 
     * Pedir un índice y validarlo (0 ≤ índice < tamaño).
     * Con el trabajo guardado y la potencia, calcular APTO o NO APTO.
     * Mostrar el tractor evaluado + el resultado + un mensaje final aleatorio.
     * 
     * 4. Eliminar tractor
     * 
     * Pedir índice y validarlo.
     * Eliminar el tractor borrando el elemento en ese índice en las 3 listas.
     * Confirmar por pantalla.
     * 
     * 0. Salir
     * 
     * Terminar el programa.
     * 
     * Evaluación
     * 
     * arado: potencia ≥ 120 → APTO, si no NO APTO
     * transporte: potencia ≥ 90 → APTO, si no NO APTO
     * siembra: potencia ≥ 70 → APTO, si no NO APTO
     * 
     * Mensaje final
     * 
     * Mínimo 2 mensajes distintos para APTO
     * Mínimo 2 mensajes distintos para NO APTO
     */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> marca = new ArrayList<>();
        ArrayList<String> cvPotencia = new ArrayList<>();
        ArrayList<String> trabajoAsignado = new ArrayList<>();

        int opcionMenu = -1;
        String menu;

        // Tractores de prueba (placeholder)
        marca.add("John Deere");
        cvPotencia.add("120");
        trabajoAsignado.add("arado");

        marca.add("Kubota");
        cvPotencia.add("85");
        trabajoAsignado.add("transporte");

        marca.add("Massey Ferguson");
        cvPotencia.add("70");
        trabajoAsignado.add("siembra");
        while (opcionMenu != 0) {
            menu = """
                    \n1. Añadir tractor.
                    2. Listar tractores.
                    3. Evaluar tractor (por índice).
                    4. Eliminar tractor.
                    0. Salir.
                        """;

            if (opcionMenu == 1) {
                System.out.println("Introduce la marca");
                marca.add(scanner.nextLine());
                System.out.println("Introduce la potencia (cv)");
                cvPotencia.add(scanner.nextLine());
                System.out.println("Introduce el trabajo que desempeña");
                trabajoAsignado.add(scanner.nextLine());

            } else if (opcionMenu == 2) {
                for (int i = 0; i < marca.size(); i++) {
                    System.err.println((i + 1) + ". " + marca.get(i) + " | CV: " + cvPotencia.get(i) + " | Trabajo: "
                            + trabajoAsignado.get(i));
                }

            } else if (opcionMenu == 3) {

            }

            System.out.println(menu);

            opcionMenu = Integer.parseInt(scanner.nextLine());
        }

        scanner.close();
        System.out.println("Programa terminado.");

    }
}
