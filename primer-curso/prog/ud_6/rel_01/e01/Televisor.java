package prog.ud_6.rel_01.e01;

class Televisor extends Electrodomestico {

    private int tamanioPantalla;

    public Televisor(String marca, String modelo, int tamanioPantalla) {
        super(marca, modelo);
        this.tamanioPantalla = tamanioPantalla;
    }

    public double getTamanioPantalla() {
        return tamanioPantalla;
    }

    public void setTamanioPantalla(int tamañoPantalla) {
        this.tamanioPantalla = tamañoPantalla;
    }

    @Override
    public String toString() {
        return "Televisor: " + getMarca() + ", " + getModelo() + " | Tamaño: " + tamanioPantalla + "inch";
    }

}
