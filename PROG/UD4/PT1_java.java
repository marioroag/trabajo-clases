import java.util.Scanner;

public class PT1_java {
    public static void main(String[] args) {

        // Crear objeto Scanner
        Scanner scanner = new Scanner(System.in);

        // Info del usuario
        System.out.print("Número de pedidos:");
        int numeroPedidos = scanner.nextInt();
        while (numeroPedidos <= 0) {
            System.out.print("Número de pedidos:");
            numeroPedidos = scanner.nextInt();
        }

        System.out.print("Stock de arroz (g):");
        int stockArroz = scanner.nextInt();
        while (stockArroz <= 0) {
            System.out.print("Stock de arroz (g):");
            stockArroz = scanner.nextInt();
        }

        System.out.print("Stock de agua (L):");
        int stockAgua = scanner.nextInt();
        while (stockAgua <= 0) {
            System.out.print("Stock de agua (L):");
            stockAgua = scanner.nextInt();
        }

        // Declaraciones
        double arrozGastadoAcumulado = 0, aguaGastadaAcumulada = 0;
        double importe = 0, arrozGastadoPedido = 0, aguaGastadoPedido = 0;
        final double ARROZMAKI = 120, AGUAMAKI = 0.1, PRECIOMAKI = 8;
        final double ARROZNIGIRI = 50, AGUANIGIRI = 0.05, PRECIONIGIRI = 10;
        final double ARROZSASHIMI = 0, AGUASASHIMI = 0.02, PRECIOSASHIMI = 12;
        String tipoPlato = "";
        int unidades = 0;
        int contadorPedidos = 0;
        int totalPiezasMaki = 0, totalPiezasNigiri = 0, totalPiezasSashimi = 0;
        double arrozRestante = 0, aguaRestante = 0;
        double importeCajaTotal = 0;
        boolean stockSuperado = false;

        for (int i = 1; i <= numeroPedidos && !stockSuperado; i++) {
            System.out.println("--- Pedido " + i + " ---");
            while (!tipoPlato.equalsIgnoreCase("maki") && !tipoPlato.equalsIgnoreCase("nigiri")
                    && !tipoPlato.equalsIgnoreCase("sashimi")) {
                System.out.print("Tipo de plato (maki/nigiri/sashimi):");
                tipoPlato = scanner.nextLine();
            }

            System.err.print("Unidades (≥ 0):");
            unidades = scanner.nextInt();
            while (unidades < 0) {
                System.err.print("Unidades (≥ 0):");
                unidades = scanner.nextInt();
            }

            if (tipoPlato == "maki") {

                arrozGastadoPedido = ARROZMAKI * unidades;
                aguaGastadoPedido = AGUAMAKI * unidades;
                importe = PRECIOMAKI * unidades;

            } else if (tipoPlato == "nigiri") {

                arrozGastadoPedido = ARROZNIGIRI * unidades;
                aguaGastadoPedido = AGUANIGIRI * unidades;
                importe = PRECIONIGIRI * unidades;

            } else {

                arrozGastadoPedido = ARROZSASHIMI * unidades;
                aguaGastadoPedido = AGUASASHIMI * unidades;
                importe = PRECIOSASHIMI * unidades;
            }

            if (stockArroz < arrozGastadoAcumulado + arrozGastadoPedido) {
                stockSuperado = true;
                System.out.println("¡Alerta! Has superado el stock de arroz");
            }
            if (stockAgua < aguaGastadaAcumulada + aguaGastadoPedido) {
                stockSuperado = true;
                System.out.println("¡Alerta! Has superado el stock de agua");

            }

            if (!stockSuperado) {

                ++contadorPedidos; // Se suguiere en clase tambien contadorPedidos = i
                arrozGastadoAcumulado += arrozGastadoPedido;
                aguaGastadaAcumulada += aguaGastadoPedido;
                importeCajaTotal += importe;

                if (tipoPlato == "maki")
                    totalPiezasMaki += unidades;
                else if (tipoPlato == "nigiri")
                    totalPiezasNigiri += unidades;
                else
                    totalPiezasSashimi += unidades;

                System.out.println(
                        "Plato: " + tipoPlato + " | Unidades: " + unidades + " | Importe cobrado: " + importe + " €");
                System.out.println("Arroz gastado en el pedido: " + arrozGastadoPedido + "g | Arroz acumulado: "
                        + arrozGastadoAcumulado + " g");
                System.out.println("Agua gastada en el pedido (L): " + aguaGastadoPedido/* .toFixed(2) */
                        + " | Agua acumulada (L): " + aguaGastadaAcumulada/* .toFixed(2) */);
            }

        }
        arrozRestante = stockArroz - arrozGastadoAcumulado;
        aguaRestante = stockAgua - aguaGastadaAcumulada;

        System.out.println("=== RESUMEN FINAL ===");
        System.out.println("Pedidos registrados: " + contadorPedidos + " de " + numeroPedidos);
        System.out.println("Unidades → Maki: " + totalPiezasMaki + " | Nigiri: " + totalPiezasNigiri + " | Sashimi: "
                + totalPiezasSashimi);
        System.out.println(
                "Consumo total → Arroz: " + arrozGastadoAcumulado + " g | Agua: " + aguaGastadaAcumulada + " L");
        System.out.println("Stock restante → Arroz: " + arrozRestante + " g | Agua: " + aguaRestante + " L");
        System.out.println("Caja del día: " + importeCajaTotal + " €");
        if (stockSuperado) {
            System.out.println("Mensaje final:  Registro interrumpido por superación de stock");
        } else {
            System.out.println("Mensaje final: Registro completado con éxito");
        }

    }
}