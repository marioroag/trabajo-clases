package PROG.UD5.rel1;

public class e05 {
    // Ejercicio 5: Clase Termómetro. Crea una clase Termómetro con un atributo
    // temperatura. Agrega método convertirAFahrenheit().

    public static void main(String[] args) {
        Termometro termometro1 = new Termometro(10.1);

        System.out.println("Temperatura en Celsius: " + termometro1.temperatura);
        System.out.println("Temperatura en Fahrenheit: " + termometro1.convertirAFahrenheit());

        // Probando .toString()
        System.out.println(termometro1);
    }
}

class Termometro {
    double temperatura;

    Termometro(double temperatura) {
        this.temperatura = temperatura;
    }

    double convertirAFahrenheit() {
        return (temperatura + 9 / 5) + 32;
    }

    @Override
    public String toString() {
        return "Tiene la temperatura: " + this.temperatura + " ºC";
    }
}