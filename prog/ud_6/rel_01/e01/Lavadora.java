package prog.ud_6.rel_01.e01;

class Lavadora extends Electrodomestico {

    private double capacidadCarga;

    public Lavadora(String marca, String modelo, double capacidadCarga) {
        super(marca, modelo);
        this.capacidadCarga = capacidadCarga;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String toString() {
        return "Lavadora: " + getMarca() + ", " + getModelo() + " | Tamaño: " + capacidadCarga + "watts";
    }

}
