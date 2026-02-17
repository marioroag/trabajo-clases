package prog.ud_4.UD2_rel1;

import java.util.ArrayList;

public class e16 {
    public static void main(String[] args) {
        ArrayList<Integer> secuencia = new ArrayList<>();
        final int debeTener = 5;

        for (int i = 0; i < debeTener; i++) {
            secuencia.addLast(i + 1);
            System.out.println(secuencia);
        }
    }
}
