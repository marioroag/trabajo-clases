package prog.ud_5.rel_03.e01;

import java.util.ArrayList;

public class Puerto {
    // [ Variables ]
    private String nombre;
    public String ubicacion;
    private int capacidadMaxima;
    public String telefonoContacto;

    private ArrayList<Amarre> amarres;
    private ArrayList<Embarcacion> embarcaciones;
    private ArrayList<String> matriculasAmarradas = new ArrayList<>();

    // [ Constructor ]
    public Puerto(String nombre, String ubicacion, int capacidadMaxima, String telefonoContacto,
            ArrayList<Amarre> amarres,
            ArrayList<Embarcacion> embarcaciones) {

        setNombre(nombre);
        this.ubicacion = ubicacion;
        this.telefonoContacto = telefonoContacto;
        setAmarres(amarres);
        setEmbarcaciones(embarcaciones);
        setCapacidadMaxima(capacidadMaxima);
    }

    // Constructor de creacion de un puerto vacío (this() usa el constructor arriba)
    public Puerto(String nombre, String ubicacion, int capacidadMaxima, String telefonoContacto) {
        this(nombre, ubicacion, capacidadMaxima, telefonoContacto, new ArrayList<>(), new ArrayList<>());
    }

    // [ Metodos ]
    /**
     * Registra una nueva embarcacion al puerto
     * 
     * @param embarcacion
     */
    public boolean registrarEmbarcacion(Embarcacion embarcacion) {
        boolean exito = false;
        if (!embarcaciones.contains(embarcacion)) {
            matriculasAmarradas.add("vacio");
            this.embarcaciones.add(embarcacion);
            exito = true;
        }

        return exito;
    }

    /**
     * Da de alta un nuevo amarre si el puerto tiene capacidad suficiente
     * 
     * @param amarre
     */
    public void altaAmarre(Amarre amarre) {
        if (amarres.size() < capacidadMaxima && !amarres.contains(amarre)) {
            this.amarres.add(amarre);
        } else {
            E01.imprimirMensaje("No se pudo agregar el amarre (Puerto alacanzó su capacidad máxima)");
        }
    }

    /**
     * Vincula una matricula con un amarre usando un solo array colocando matricula,
     * numeroAmarre de forma sucesiva
     * 
     * @param matricula
     * @param numeroAmarre
     */
    public void asignarAmarre(String matricula, int numeroAmarre) {
        if (buscarEmbarcacionEnPuerto(matricula) != null && numeroAmarre >= 0 && numeroAmarre <= amarres.size()) {
            matriculasAmarradas.add(matricula);
            matriculasAmarradas.add(Integer.toString(numeroAmarre));
            amarres.get(numeroAmarre).setOcupado(true);
            System.out.println(matriculasAmarradas);
        }
    }

    public void liberarAmarre(int numeroAmarre) {
        int indiceAmarre = matriculasAmarradas.indexOf(Integer.toString(numeroAmarre));
        if (indiceAmarre != -1) { // indexOf devuelve -1 si no encuentra el index
            matriculasAmarradas.remove(indiceAmarre);
            matriculasAmarradas.remove(indiceAmarre - 1);
            amarres.get(numeroAmarre).setOcupado(false);
            System.out.println(matriculasAmarradas);
        }
    }

    /**
     * Muestra los amarres sin ocupar
     * 
     * @return lista de amarres libres
     */
    public String mostrarAmarresLibres() {
        String amarresLibres = "";
        for (Amarre amarre : amarres) {
            if (!amarre.isOcupado()) {
                amarresLibres += "-- " + amarre + "\n";
            }
        }

        return amarresLibres;
    }

    

    /**
     * Muestra los amarres ocupados
     * 
     * @return lista de amarres ocupados
     */
    public String mostrarAmarresOcupados() {
        String amarresOcupados = "";
        for (Amarre amarre : amarres) {
            if (amarre.isOcupado()) {
                amarresOcupados += "-- " + amarre + "\n";
            }
        }

        return amarresOcupados;
    }

    /**
     * Recorre el array de embarcaciones hasta encontrar uno con la matricula
     * recibida
     * 
     * @param matricula matricula a buscar
     * @return embarcacion encontrada
     */
    public Embarcacion buscarEmbarcacionEnPuerto(String matricula) {
        Embarcacion embarcacionEncontrada = null;
        boolean encontrada = false;

        for (int i = 0; i < embarcaciones.size() && !encontrada; i++) {
            if (embarcaciones.get(i).getMatricula().equals(matricula)) {
                embarcacionEncontrada = embarcaciones.get(i);
                encontrada = true;
            }
        }

        return embarcacionEncontrada;
    }

    public String buscarEmbarcacion(String matricula) {
        String mensaje = "La embarcación no está amarrada";

        if (matriculasAmarradas.contains(matricula)) {
            String amarreDeEmbarcacion = matriculasAmarradas.get(matriculasAmarradas.indexOf(matricula) + 1);
            mensaje = "La embarcacion está amarrada en el amarre Nº" + amarreDeEmbarcacion;
        }

        return mensaje;
    }

    /**
     * Suma precioDia de amarres ocupados.
     * 
     * @return
     */
    public double calcularIngresosDiariosActuales() {
        double ingresosActuales = 0;
        for (Amarre amarre : amarres) {
            if (amarre.isOcupado()) {
                ingresosActuales += amarre.getPrecioDia();
            }
        }

        return ingresosActuales;
    }

    /**
     * Suma precioDia de todos los amarres.
     * 
     * @return
     */
    public double calcularIngresosDiariosMaximos() {
        double ingresosMaximos = 0;
        for (Amarre amarre : amarres) {
            ingresosMaximos += amarre.getPrecioDia();
        }

        return ingresosMaximos;
    }

    // [ Getters y Setters ]
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAmarres(ArrayList<Amarre> amarres) {
        if (capacidadMaxima != 0.0) {
            if (amarres.size() <= capacidadMaxima) {
                this.amarres = amarres;
                // Pone al día el array de matriculas amarradas con tantas posiciones como con
                // amarres hay
                for (int i = 0; i < amarres.size(); i++) {
                    matriculasAmarradas.set(i, "vacio");
                }
            }
        } else {
            this.amarres = amarres;
        }
    }

    public void setEmbarcaciones(ArrayList<Embarcacion> embarcaciones) {
        this.embarcaciones = embarcaciones;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        if (amarres != null) {
            if (amarres.size() <= capacidadMaxima) {
                this.capacidadMaxima = capacidadMaxima;
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public ArrayList<Amarre> getAmarres() {
        return amarres;
    }

    public ArrayList<Embarcacion> getEmbarcaciones() {
        return embarcaciones;
    }

    @Override
    public String toString() {
        String puertoMensaje = nombre + " | " + ubicacion + " | " + telefonoContacto + "\n";

        // return "Puerto [matriculasAmarradas=" + matriculasAmarradas + ", amarres=" +
        // amarres + ", embarcaciones="
        // + embarcaciones + "]";

        // puertoMensaje += "\n[ Matriculas Amarradas ]\n";
        // for (String matricula : matriculasAmarradas) {
        // puertoMensaje += "-- " + matricula + "\n";
        // }

        puertoMensaje += "\n[ Amarres ]\n";
        for (Amarre amarre : amarres) {
            puertoMensaje += "-- " + amarre + "\n";
        }

        puertoMensaje += "\n[ Embarcaciones ]\n";
        for (Embarcacion embarcacion : embarcaciones) {
            puertoMensaje += "-- " + embarcacion + "\n";
        }

        return puertoMensaje;
    }
}
