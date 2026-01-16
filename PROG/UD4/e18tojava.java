public class e18tojava {
    public static int contarVocalesEnCadena(String cadenaTexto) {
        cadenaTexto = cadenaTexto.toUpperCase();
        int cantidadTotalVocales = 0;

        for (int i = 0; i < cadenaTexto.length(); i++) {
            char letra = cadenaTexto.charAt(i);
            if (letra == 'A' || letra == 'E' || letra == 'I' ||
                    letra == 'O' || letra == 'U') {
                cantidadTotalVocales++;
            }
        }
        return cantidadTotalVocales;
    }

    public static void main(String[] args) {
        System.out.println(contarVocalesEnCadena("MURCIELAGO"));
    }
}