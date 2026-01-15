public class e18tojava {
    public static int contarVocalesEnCadena(String cadenaTexto) {
        cadenaTexto = cadenaTexto.toUpperCase();
        char[] vocales = {'A', 'E', 'I', 'O', 'U'};
        int cantidadTotalVocales = 0;

        for (int i = 0; i < cadenaTexto.length(); i++) {
            char letra = cadenaTexto.charAt(i);
            for (int j = 0; j < vocales.length; j++) {
                if (letra == vocales[j]) {
                    cantidadTotalVocales++;
                }
            }
        }
        
        return cantidadTotalVocales;
    }

    public static void main(String[] args) {
    System.out.println(contarVocalesEnCadena("MURCIELAGO"));
    }
}
