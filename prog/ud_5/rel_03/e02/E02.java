package prog.ud_5.rel_03.e02;

import java.util.ArrayList;
import java.util.Arrays;

import prog.ud_5.rel_03.Faker;

public class E02 {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(10, "Juan", "12345N", "Granada", "979797979", "hola@gmail.com");
        Cliente cliente2 = new Cliente(11, "Pepe", "12345J", "Granada", "979797979", "hola@gmail.com");

        Tramite tramite1 = new Tramite("nombre tram", 10, false, 30);

        Expediente expediente1 = new Expediente(cliente1, tramite1, "ABIERTO", "10/27/26");

        Gestoria gestoria1 = new Gestoria("Gestoria MR", "Granada", "987654321", "8:20 - 20:30");

        ArrayList<Cliente> clientesMas = new ArrayList<>(Arrays.asList(cliente1, cliente2));
        gestoria1.setClientes(clientesMas);
        System.out.println(gestoria1);
        System.out.println(gestoria1.mostrarClientes());

        gestoria1.abrirExpediente(cliente2, tramite1);

        gestoria1.abrirExpediente(cliente1, tramite1);
        System.out.println(gestoria1.getExpedientes());
        gestoria1.cambiarEstado(1, "EN_PROCESO");
        gestoria1.marcarPagado(1);
        System.out.println(gestoria1.getExpedientes());

        gestoria1.listarPorEstado();

        // Tramite tramite;
        // for (int i = 0; i < 50; i++) {
        // tramite = new Tramite(Faker.tramite(),
        // Faker.precio(20, 200), Faker.booleano(),
        // Faker.entero(10, 30));
        // }

        // Cliente cliente;
        // for (int i = 0; i < 50; i++) {
        // cliente = new Cliente(Faker.entero(i, i), null, null, null, null, null)
        // }
    }
}
