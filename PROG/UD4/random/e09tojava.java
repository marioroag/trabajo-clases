package random;
import java.util.Scanner;

public class e09tojava {
    public static int menorDeTres(int num1, int num2, int num3) {
        int[] numeros = {num1, num2, num3};
        int actualMenor = 0;

        for (int i = 0; i < numeros.length; i++) {
            if (i == 0) actualMenor = numeros[i];
            if (numeros[i] < actualMenor) actualMenor = numeros[i];
        }

        return actualMenor;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Primer número");
        int numeroUsuario1 = scanner.nextInt();
        
        System.out.println("Segundo número");
        int numeroUsuario2 = scanner.nextInt();

        System.out.println("Tercer número");
        int numeroUsuario3 = scanner.nextInt();
        scanner.close();

        System.out.println("El número más pequeño ha sido: " + menorDeTres(numeroUsuario1, numeroUsuario2, numeroUsuario3));

    }
}
