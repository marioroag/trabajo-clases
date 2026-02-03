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

    // TODO: Control de errores en los inputs del usuario.

    public static void main(String[] args) {
        Reloj reloj1 = new Reloj(9, 45, 00);
        Scanner scanner = new Scanner(System.in);

        int cantidad = -1;
        int opcion = -1;

        do {
            System.out.println("Hora del reloj: " + reloj1);
            System.out.println(
                    "Selecciona la opción:\n1. Sumar minutos\n2. Restar minutos\n3. Sumar segundos\n4. Restar segundos");
            opcion = Integer.parseInt(scanner.nextLine());

            if (opcion == 1) {
                System.out.print("Minutos a sumar: ");
                cantidad = Integer.parseInt(scanner.nextLine());
                reloj1.sumarMinutos(cantidad);
            } else if (opcion == 2) {
                System.out.print("Minutos a restar: ");
                cantidad = Integer.parseInt(scanner.nextLine());
                reloj1.restarMinutos(cantidad);
            } else if (opcion == 3) {
                System.out.print("Segundos a sumar: ");
                cantidad = Integer.parseInt(scanner.nextLine());
                reloj1.sumarSegundos(cantidad);
            } else if (opcion == 4) {
                System.out.print("Segundos a restar: ");
                cantidad = Integer.parseInt(scanner.nextLine());
                reloj1.restarSegundos(cantidad);
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

    void sumarMinutos(int cantidad) {
        this.minuto += cantidad;

        // Elimina excedente de minutos y suma a las horas
        if (this.minuto >= 60) {
            do {
                this.minuto -= 60;
                this.hora++;

                // Si ha completado un dia lo resetea
                if (this.hora >= 24) {
                    this.hora -= 24;
                }
            } while (this.minuto > 60);
        }

    }

    void restarMinutos(int cantidad) {
        this.minuto -= cantidad;
        if (this.minuto < 0) {
            do {
                this.hora--;
                this.minuto += 60;

                // Arregla horas si baja de 0
                if (this.hora < 0) {
                    this.hora += 24;
                }
            } while (this.minuto < 0);
        }
    }

    void sumarSegundos(int cantidad) {
        this.segundo += cantidad;
        if (this.segundo >= 60) {
            do {
                this.segundo -= 60;
                sumarMinutos(1);
            } while (this.segundo >= 60);
        }
    }

    void restarSegundos(int cantidad) {
        this.segundo -= cantidad;
        if (this.segundo < 0) {
            do {
                sumarMinutos(1);
                this.segundo += 60;
            } while (this.segundo < 0);
        }
    }

    @Override
    public String toString() {
        return hora + ":" + minuto + ":" + segundo;
    }
}