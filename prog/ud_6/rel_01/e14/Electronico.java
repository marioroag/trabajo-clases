package prog.ud_6.rel_01.e14;

public class Electronico extends Producto {
    public int garantia;

    public Electronico(int garantia, String nombre, double precio) {
        super(nombre, precio);
        this.garantia = garantia;
    }

    @Override
    public String toString() {
        return nombre + " cuesta " + precio + " € y tiene " + garantia + " años de garantía.";
    }
}
