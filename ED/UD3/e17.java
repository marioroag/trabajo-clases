package UD3_rel0;

public class e17 {
    /**
     * 
     * <p>
     * HOLA
     * </p>
     * 
     * @param cadenaTexto String original a revertir
     * @return cadena de texto invertida
     */
    public static String revertirCadena(String cadenaTexto) {
        int cadena = cadenaTexto.length();
        String cadenaInvertida = "";
        for (int i = 1; i <= cadena; i++) {
            cadenaInvertida += cadenaTexto.charAt(cadena - i);
        }
        return cadenaInvertida;
    }

    public static void main(String[] args) {
        System.out.println(revertirCadena("Hola"));
    }
}