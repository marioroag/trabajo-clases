package PROG.UD5.rel1;

import java.util.Scanner;

public class e06 {
    /*
     * Ejercicio 6: Clase Reloj
     * 
     * Crea una clase Reloj con atributos hora, minuto y segundo. Agrega un método
     * toString() que devuelva la hora en formato hh:mm:ss. Agrega el método
     * sumarMinutos(minutos) , restarMinutos(minutos) , sumarSegundos(segundos) y
     * restarSegundos(segundos)
     */

    public static void main(String[] args) {
        Reloj reloj1 = new Reloj(9, 45, 00);
        Scanner scanner = new Scanner(System.in);

        int opcion = -1;

        do {
            System.out.println("Hora del reloj: " + reloj1);
            System.out.println(
                    "Selecciona la opción:\n1. Sumar minutos\n2. Restar minutos\n3. Sumar segundos\n4. Restar segundos");
            opcion = Integer.parseInt(scanner.nextLine());

            if (opcion == 1) {

            } else if (opcion == 2) {

            } else if (opcion == 3) {

            } else if (opcion == 4) {

            } else {
                System.out.println("Introduce un número válido");
            }
        } while (opcion != 0);
        System.out.println(reloj1);
    }
}

/*
 * Ejercicio 6: Clase Reloj
 * 
 * Crea una clase Reloj con atributos hora, minuto y segundo. Agrega un método
 * toString() que devuelva la hora en formato hh:mm:ss. Agrega el método
 * sumarMinutos(minutos) , restarMinutos(minutos) , sumarSegundos(segundos) y
 * restarSegundos(segundos)
 */
class Reloj {
    int hora, minuto, segundo;

    Reloj(int hora, int minuto, int segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    int sumarMinutos(int cantidad) {
        return 0;
    }

    int restarMinutos(int cantidad) {
        return 0;
    }

    int sumarSegundos(int cantidad) {
        return 0;
    }

    int restarSegundos(int cantidad) {
        return 0;
    }

    @Override
    public String toString() {
        return hora + ":" + minuto + ":" + segundo;
    }
}