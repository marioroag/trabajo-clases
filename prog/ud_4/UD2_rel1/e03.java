package prog.ud_4.UD2_rel1;

import java.util.ArrayList;
import java.util.Arrays;

public class e03 {
    public static void main(String[] args) {
        ArrayList<String> colores = new ArrayList<String>();
        colores.addAll(Arrays.asList("rojo", "verde"));

        ArrayList<String> eliminado = new ArrayList<String>();
        eliminado.add(colores.get(colores.size() - 1));
        colores.remove(colores.size() - 1);

        System.out.println(colores);
        System.out.println(eliminado);
    }
}
