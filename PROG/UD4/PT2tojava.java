import java.util.ArrayList;
import java.util.Scanner;

public class PT2tojava {
    public static void main(String[] args) {
        // Constantes
        final String DIENTE = "D", DIENTESANO = "DS", DIENTEDANIADO = "DD";
        final int NUMDIENTES = 10, MAXDIENTESPICADOS = 5;
        final int DIENTESPICADOS = (int) Math.floor(Math.random() * MAXDIENTESPICADOS) + 1;

        final int DIENTESNOPICADOS = NUMDIENTES - DIENTESPICADOS;
        final String JUGADOR1 = "Jugador 1", JUGADOR2 = "Jugador 2";

        // Declaraciones
        boolean juegoPerdido = false;
        String jugadorActual = JUGADOR1, mensajeFinPrograma = "Enhorabuena, ambos ganan";
        int posicionSeleccionada = 0, dientesPicdadosIntroducidos = 0, posicionDienteIntroducir = 0;

        boolean inputInvalido = false;

        // Array
        ArrayList<Integer> tableroInterno = new ArrayList<Integer>();
        ArrayList<String> tableroVisible = new ArrayList<String>();

        // Scanner
        Scanner scanner = new Scanner(System.in);

        // Creación del tablero vacío
        for (int i = 0; i < NUMDIENTES; i++) {
            tableroInterno.add(0);
        }

        // Introduzco los dientes picados
        while (dientesPicdadosIntroducidos < DIENTESPICADOS) {
            posicionDienteIntroducir = (int) Math.floor(Math.random() * NUMDIENTES);
            if (tableroInterno.get(posicionDienteIntroducir) == 0) {
                tableroInterno.set(posicionDienteIntroducir, 1);
                dientesPicdadosIntroducidos++;
            }
        }

        System.out.println(tableroInterno);

        // Creación del tablero visible al usuario
        for (int i = 0; i < NUMDIENTES; i++) {
            tableroVisible.add(DIENTE);
        }

        for (int i = 0; i < DIENTESNOPICADOS && !juegoPerdido; i++) {

            // Sigue preguntando por posiciones hasta que el juego acaba
            do {
                // Control de errores si es string o null
                try {
                    System.out.print(jugadorActual + " elige: ");
                    posicionSeleccionada = Integer.parseInt(scanner.nextLine());
                    inputInvalido = false;
                } catch (Exception e) {
                    inputInvalido = true;
                    System.out.println("Input invalido, porfavor introduce un número entero");
                }
            } while (inputInvalido || posicionSeleccionada < 0 || posicionSeleccionada > NUMDIENTES
                    || tableroVisible.get(posicionSeleccionada) != DIENTE);

            // Cambia el tablero visible para mostrar el progreso
            if (tableroInterno.get(posicionSeleccionada) == 0) {
                tableroVisible.set(posicionSeleccionada, DIENTESANO);
            } else {
                tableroVisible.set(posicionSeleccionada, DIENTEDANIADO);
                mensajeFinPrograma = "¡El cocodrilo mordió! " + jugadorActual + " pierde.";
                juegoPerdido = true;
            }

            // Muestra al usuario el tablero actual
            System.out.print("[");
            for (String elemento : tableroVisible) {
                System.out.print("  " + elemento);
            }
            System.out.println("  ]");

            // Feedback de cambio de jugador
            if (jugadorActual == JUGADOR1) {
                jugadorActual = JUGADOR2;
            } else {
                jugadorActual = JUGADOR1;
            }
        }

        scanner.close();

        // Fin
        System.err.println(mensajeFinPrograma);
    }
}