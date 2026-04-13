// EJERCICIO 6 - Dispositivos Inteligentes

interface DispositivoInteligente {
    String encender();
    String apagar();
    String conectarWiFi();
}

class Smartphone implements DispositivoInteligente {
    String marca;

    Smartphone(String marca) {
        this.marca = marca;
    }

    public String encender() {
        String resultado = "El smartphone " + marca + " se ha encendido.";
        return resultado;
    }

    public String apagar() {
        String resultado = "El smartphone " + marca + " se ha apagado.";
        return resultado;
    }

    public String conectarWiFi() {
        String resultado = "El smartphone " + marca + " se ha conectado al WiFi.";
        return resultado;
    }
}

class SmartTV implements DispositivoInteligente {
    String marca;

    SmartTV(String marca) {
        this.marca = marca;
    }

    public String encender() {
        String resultado = "La SmartTV " + marca + " se ha encendido.";
        return resultado;
    }

    public String apagar() {
        String resultado = "La SmartTV " + marca + " se ha apagado.";
        return resultado;
    }

    public String conectarWiFi() {
        String resultado = "La SmartTV " + marca + " se ha conectado al WiFi.";
        return resultado;
    }
}

public class Ejercicio06 {
    public static void main(String[] args) {
        Smartphone s = new Smartphone("Samsung");
        SmartTV tv = new SmartTV("LG");

        System.out.println(s.encender());
        System.out.println(s.conectarWiFi());
        System.out.println(s.apagar());

        System.out.println(tv.encender());
        System.out.println(tv.conectarWiFi());
        System.out.println(tv.apagar());
    }
}
