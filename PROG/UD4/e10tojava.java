import java.util.Scanner;

public class e10tojava {
    public static double areaTriangulo(double base, double altura) {
        return (base * altura) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Base del triangulo:");
        double baseUser = scanner.nextDouble();
        System.out.println("Altura del triangulo:");
        double alturaUser = scanner.nextDouble();
        scanner.close();

        System.err.println("Area: " + (areaTriangulo(baseUser, alturaUser)));
    }
}
