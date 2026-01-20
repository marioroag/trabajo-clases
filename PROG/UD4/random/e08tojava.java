package random;
import java.util.Scanner;

public class e08tojava {
    public static int mayor(int num1, int num2) {
        int maximo = num1;

        if (num2 > num1) {
            maximo = num2;
        }
        return maximo;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Primer numero");
        int primerNumero = scanner.nextInt();

        System.out.println("Segundo numero");
        int segundoNumero = scanner.nextInt();

        System.out.println("El número mas grande es: " + mayor(primerNumero, segundoNumero));
        scanner.close();
    }
}