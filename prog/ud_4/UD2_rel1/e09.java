package prog.ud_4.ud2_rel1;

import java.util.ArrayList;
import java.util.Arrays;

public class e09 {
    public static void main(String[] args) {
        ArrayList<String> cola = new ArrayList<>(Arrays.asList("cliente1", "cliente2", "cliente3"));
        String clienteAtendido = "";

        while (!cola.isEmpty()) {
            clienteAtendido = cola.remove(0);
            System.out.println("Cliente atendido: " + String.join(" - ", clienteAtendido));
            System.out.println("Longitud de cola: " + cola.size());
        }
    }
}
