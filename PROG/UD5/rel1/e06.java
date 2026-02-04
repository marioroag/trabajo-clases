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

    public static int controlEntero() {
        Scanner scanner = new Scanner(System.in);
        int numero = -1;

        do {
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero < 0) {
                    imprimirMensaje("El numero introducido no es mayor o igual que 0");
                }
            } else {
                scanner.nextLine();
                imprimirMensaje("Introduce un numero: ");
            }
        } while (numero < 0);

        return numero;
    }

    public static void imprimirMensaje(String mensaje) {
        System.out.print(mensaje);
    }

    public static void main(String[] args) {
        Reloj reloj1 = new Reloj(9, 45, 00);
        Scanner scanner = new Scanner(System.in);

        int cantidad = -1;
        int opcion = -1;

        do {
            imprimirMensaje("\nHora del reloj: " + reloj1);
            imprimirMensaje(
                    "\n0. Salir\n1. Sumar minutos\n2. Restar minutos\n3. Sumar segundos\n4. Restar segundos\nSelecciona la opción: ");

            // opcion = Integer.parseInt(scanner.nextLine());
            opcion = controlEntero();

            if (opcion == 1) {
                imprimirMensaje("Minutos a sumar: ");
                cantidad = controlEntero();
                reloj1.sumarMinutos(cantidad);

            } else if (opcion == 2) {
                imprimirMensaje("Minutos a restar: ");
                cantidad = controlEntero();
                reloj1.restarMinutos(cantidad);

            } else if (opcion == 3) {
                imprimirMensaje("Segundos a sumar: ");
                cantidad = controlEntero();
                reloj1.sumarSegundos(cantidad);

            } else if (opcion == 4) {
                imprimirMensaje("Segundos a restar: ");
                cantidad = controlEntero();
                reloj1.restarSegundos(cantidad);

            } else if (opcion == 0) {
                imprimirMensaje("Saliendo..");

            } else {
                imprimirMensaje("Selecciona una opción del menu");
            }
        } while (opcion != 0);

        scanner.close();
        System.out.println(reloj1);
    }
}

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
        String minutoMostrar = String.valueOf(minuto), segundoMostrar = String.valueOf(segundo);

        // Corrigo mostrar minutos y segundos con un solo dígito
        if (minutoMostrar.length() == 1) {
            minutoMostrar += "0";
        } else if (segundoMostrar.length() == 1) {
            segundoMostrar += "0";
        }
        return hora + ":" + minutoMostrar + ":" + segundoMostrar;
    }
}