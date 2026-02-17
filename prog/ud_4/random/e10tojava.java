package prog.ud_4.random;
import java.util.Scanner;

public class e10tojava {

    public static double areaTriangulo(double base, double altura) {
        return base * altura / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double base = 0;
        double altura = 0;

        do {
            try {
                System.out.print("Introduce la base: ");
                base = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                base = -1;
                System.out.println("ERROR al leer numero");
            }
            if (base < 0) {
                System.out.println("ERROR: El número debe ser mayor o igual que cero");
            }
        } while (base < 0);

        do {
            try {
                System.out.print("Introduce la altura: ");
                altura = Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                // Para ver la excepción, si hiciera falta => e.printStackTrace();
                altura = -1;
                System.out.println("ERROR al leer numero");
            }
            if (altura < 0) {
                System.out.println("ERROR: El número debe ser mayor o igual que cero");
            }
        } while (altura < 0);

        scanner.close();
        System.out.println("El area es: " + areaTriangulo(base, altura));
    }
}
