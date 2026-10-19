import java.util.ArrayList;

// ============================================================
// PARTE 1. CLASE ABSTRACTA
// ============================================================

abstract class MiembroBanda {
    private String nombreArtistico;
    private String localidad;
    private int anosEnLaAgrupacion;
    private double puntosBase;

    MiembroBanda(String nombreArtistico, String localidad, int anosEnLaAgrupacion, double puntosBase) {
        this.nombreArtistico = nombreArtistico;
        this.localidad = localidad;
        this.anosEnLaAgrupacion = anosEnLaAgrupacion;
        this.puntosBase = puntosBase;
    }

    public String getNombreArtistico() { return nombreArtistico; }
    public void setNombreArtistico(String nombreArtistico) { this.nombreArtistico = nombreArtistico; }
    public String getLocalidad() { return localidad; }
    public void setLocalidad(String localidad) { this.localidad = localidad; }
    public int getAnosEnLaAgrupacion() { return anosEnLaAgrupacion; }
    public void setAnosEnLaAgrupacion(int anosEnLaAgrupacion) { this.anosEnLaAgrupacion = anosEnLaAgrupacion; }
    public double getPuntosBase() { return puntosBase; }
    public void setPuntosBase(double puntosBase) { this.puntosBase = puntosBase; }

    public abstract double calcularRendimiento();
    public abstract boolean estaDisponible();

    public void sumarAnos() {
        anosEnLaAgrupacion++;
    }

    public void sumarPuntosBase(double puntos) {
        if (puntos > 0) {
            puntosBase += puntos;
        }
    }
}

// ============================================================
// PARTE 2. INTERFACES
// ============================================================

interface Tocable {
    boolean asignarInstrumento(String nombre, double valor);
    boolean retirarInstrumento(String nombre, double valor);
}

interface Coordinable {
    boolean asignarMiembro(MiembroBanda miembro);
    boolean quitarMiembro(String nombreArtistico);
}

interface Revisable {
    void sumarPartiturasRevisadas();
    void sumarErroresDetectados(int cantidad);
}

// ============================================================
// PARTE 3. CLASE RESPONSABLEMUSICAL
// ============================================================

class ResponsableMusical extends MiembroBanda implements Coordinable, Revisable {
    private String repertorioSemana;
    private int numeroIntegrantesACargo;
    private ArrayList<MiembroBanda> integrantes;
    private int partiturasRevisadas;
    private int erroresDetectados;

    ResponsableMusical(String nombreArtistico, String localidad, int anosEnLaAgrupacion, double puntosBase,
                       String repertorioSemana) {
        super(nombreArtistico, localidad, anosEnLaAgrupacion, puntosBase);
        this.repertorioSemana = repertorioSemana;
        this.numeroIntegrantesACargo = 0;
        this.integrantes = new ArrayList<>();
        this.partiturasRevisadas = 0;
        this.erroresDetectados = 0;
    }

    public String getRepertorioSemana() { return repertorioSemana; }
    public void setRepertorioSemana(String repertorioSemana) { this.repertorioSemana = repertorioSemana; }
    public int getNumeroIntegrantesACargo() { return numeroIntegrantesACargo; }
    public void setNumeroIntegrantesACargo(int n) { this.numeroIntegrantesACargo = n; }
    public ArrayList<MiembroBanda> getIntegrantes() { return integrantes; }
    public int getPartiturasRevisadas() { return partiturasRevisadas; }
    public void setPartiturasRevisadas(int p) { this.partiturasRevisadas = p; }
    public int getErroresDetectados() { return erroresDetectados; }
    public void setErroresDetectados(int e) { this.erroresDetectados = e; }

    @Override
    public double calcularRendimiento() {
        double resultado = getPuntosBase() + (getAnosEnLaAgrupacion() * 4) + (numeroIntegrantesACargo * 3)
                + (partiturasRevisadas * 2) - erroresDetectados;
        return resultado;
    }

    @Override
    public boolean estaDisponible() {
        boolean resultado = erroresDetectados <= 5;
        return resultado;
    }

    @Override
    public boolean asignarMiembro(MiembroBanda miembro) {
        boolean exito = false;
        if (miembro != null) {
            boolean duplicado = false;
            for (MiembroBanda m : integrantes) {
                if (m.getNombreArtistico().equals(miembro.getNombreArtistico())) {
                    duplicado = true;
                }
            }
            if (!duplicado) {
                integrantes.add(miembro);
                numeroIntegrantesACargo = integrantes.size();
                exito = true;
            }
        }
        return exito;
    }

    @Override
    public boolean quitarMiembro(String nombreArtistico) {
        boolean encontrado = false;
        for (int i = 0; i < integrantes.size(); i++) {
            if (integrantes.get(i).getNombreArtistico().equals(nombreArtistico)) {
                integrantes.remove(i);
                numeroIntegrantesACargo = integrantes.size();
                encontrado = true;
            }
        }
        return encontrado;
    }

    @Override
    public void sumarPartiturasRevisadas() {
        partiturasRevisadas++;
    }

    @Override
    public void sumarErroresDetectados(int cantidad) {
        if (cantidad > 0) {
            erroresDetectados += cantidad;
        }
    }

    public double calcularRendimientoEquipo() {
        double total = 0;
        for (MiembroBanda m : integrantes) {
            total += m.calcularRendimiento();
        }
        return total;
    }
}

// ============================================================
// PARTE 4. CLASE INSTRUMENTISTA
// ============================================================

class Instrumentista extends MiembroBanda {
    private String instrumentoPrincipal;
    private int nivelTecnico;
    private int ensayosAsistidos;
    private int actuacionesDisponibles;

    Instrumentista(String nombreArtistico, String localidad, int anosEnLaAgrupacion, double puntosBase,
                   String instrumentoPrincipal, int nivelTecnico, int ensayosAsistidos, int actuacionesDisponibles) {
        super(nombreArtistico, localidad, anosEnLaAgrupacion, puntosBase);
        this.instrumentoPrincipal = instrumentoPrincipal;
        this.nivelTecnico = nivelTecnico;
        this.ensayosAsistidos = ensayosAsistidos;
        this.actuacionesDisponibles = actuacionesDisponibles;
    }

    public String getInstrumentoPrincipal() { return instrumentoPrincipal; }
    public void setInstrumentoPrincipal(String instrumentoPrincipal) { this.instrumentoPrincipal = instrumentoPrincipal; }
    public int getNivelTecnico() { return nivelTecnico; }
    public void setNivelTecnico(int nivelTecnico) { this.nivelTecnico = nivelTecnico; }
    public int getEnsayosAsistidos() { return ensayosAsistidos; }
    public void setEnsayosAsistidos(int ensayosAsistidos) { this.ensayosAsistidos = ensayosAsistidos; }
    public int getActuacionesDisponibles() { return actuacionesDisponibles; }
    public void setActuacionesDisponibles(int actuacionesDisponibles) { this.actuacionesDisponibles = actuacionesDisponibles; }

    @Override
    public double calcularRendimiento() {
        double resultado = getPuntosBase() + (nivelTecnico * 5) + (ensayosAsistidos * 2);
        return resultado;
    }

    @Override
    public boolean estaDisponible() {
        boolean resultado = actuacionesDisponibles > 0;
        return resultado;
    }

    public void registrarEnsayo() {
        ensayosAsistidos++;
    }

    public void consumirActuacion() {
        if (actuacionesDisponibles > 0) {
            actuacionesDisponibles--;
        }
    }
}

// ============================================================
// PARTE 5. CLASE GUITARRISTA
// ============================================================

class Guitarrista extends Instrumentista implements Tocable, Revisable {
    private int numeroInstrumentos;
    private double valorInstrumentos;
    private int solosPreparados;
    private int partiturasRevisadas;
    private int erroresDetectados;

    Guitarrista(String nombreArtistico, String localidad, int anosEnLaAgrupacion, double puntosBase,
                String instrumentoPrincipal, int nivelTecnico, int ensayosAsistidos, int actuacionesDisponibles,
                int numeroInstrumentos, double valorInstrumentos, int solosPreparados) {
        super(nombreArtistico, localidad, anosEnLaAgrupacion, puntosBase,
              instrumentoPrincipal, nivelTecnico, ensayosAsistidos, actuacionesDisponibles);
        this.numeroInstrumentos = numeroInstrumentos;
        this.valorInstrumentos = valorInstrumentos;
        this.solosPreparados = solosPreparados;
        this.partiturasRevisadas = 0;
        this.erroresDetectados = 0;
    }

    public int getNumeroInstrumentos() { return numeroInstrumentos; }
    public void setNumeroInstrumentos(int n) { this.numeroInstrumentos = n; }
    public double getValorInstrumentos() { return valorInstrumentos; }
    public void setValorInstrumentos(double v) { this.valorInstrumentos = v; }
    public int getSolosPreparados() { return solosPreparados; }
    public void setSolosPreparados(int s) { this.solosPreparados = s; }
    public int getPartiturasRevisadas() { return partiturasRevisadas; }
    public void setPartiturasRevisadas(int p) { this.partiturasRevisadas = p; }
    public int getErroresDetectados() { return erroresDetectados; }
    public void setErroresDetectados(int e) { this.erroresDetectados = e; }

    @Override
    public double calcularRendimiento() {
        double resultado = super.calcularRendimiento() + (solosPreparados * 4) + (partiturasRevisadas * 1.5)
                - erroresDetectados + (valorInstrumentos * 0.02);
        return resultado;
    }

    @Override
    public boolean estaDisponible() {
        boolean resultado = super.estaDisponible() && solosPreparados >= 1;
        return resultado;
    }

    @Override
    public boolean asignarInstrumento(String nombre, double valor) {
        boolean exito = false;
        if (nombre != null && !nombre.isEmpty() && valor > 0) {
            numeroInstrumentos++;
            valorInstrumentos += valor;
            exito = true;
        }
        return exito;
    }

    @Override
    public boolean retirarInstrumento(String nombre, double valor) {
        boolean exito = false;
        if (numeroInstrumentos > 0 && valor > 0) {
            numeroInstrumentos--;
            valorInstrumentos -= valor;
            if (valorInstrumentos < 0) {
                valorInstrumentos = 0;
            }
            exito = true;
        }
        return exito;
    }

    @Override
    public void sumarPartiturasRevisadas() {
        partiturasRevisadas++;
    }

    @Override
    public void sumarErroresDetectados(int cantidad) {
        if (cantidad > 0) {
            erroresDetectados += cantidad;
        }
    }

    public void prepararSolo() {
        solosPreparados++;
    }

    public void corregirError() {
        if (erroresDetectados > 0) {
            erroresDetectados--;
        }
    }
}

// ============================================================
// PARTE 6. CLASE PIANISTA
// ============================================================

class Pianista extends Instrumentista implements Tocable {
    private int numeroInstrumentos;
    private double valorInstrumentos;
    private int acompanamientosPreparados;
    private int precision;

    Pianista(String nombreArtistico, String localidad, int anosEnLaAgrupacion, double puntosBase,
             String instrumentoPrincipal, int nivelTecnico, int ensayosAsistidos, int actuacionesDisponibles,
             int numeroInstrumentos, double valorInstrumentos, int acompanamientosPreparados, int precision) {
        super(nombreArtistico, localidad, anosEnLaAgrupacion, puntosBase,
              instrumentoPrincipal, nivelTecnico, ensayosAsistidos, actuacionesDisponibles);
        this.numeroInstrumentos = numeroInstrumentos;
        this.valorInstrumentos = valorInstrumentos;
        this.acompanamientosPreparados = acompanamientosPreparados;
        this.precision = precision;
    }

    public int getNumeroInstrumentos() { return numeroInstrumentos; }
    public void setNumeroInstrumentos(int n) { this.numeroInstrumentos = n; }
    public double getValorInstrumentos() { return valorInstrumentos; }
    public void setValorInstrumentos(double v) { this.valorInstrumentos = v; }
    public int getAcompanamientosPreparados() { return acompanamientosPreparados; }
    public void setAcompanamientosPreparados(int a) { this.acompanamientosPreparados = a; }
    public int getPrecision() { return precision; }
    public void setPrecision(int precision) { this.precision = precision; }

    @Override
    public double calcularRendimiento() {
        double resultado = super.calcularRendimiento() + (acompanamientosPreparados * 3) + precision + (valorInstrumentos * 0.015);
        return resultado;
    }

    @Override
    public boolean estaDisponible() {
        boolean resultado = super.estaDisponible() && precision >= 5;
        return resultado;
    }

    @Override
    public boolean asignarInstrumento(String nombre, double valor) {
        boolean exito = false;
        if (nombre != null && !nombre.isEmpty() && valor > 0) {
            numeroInstrumentos++;
            valorInstrumentos += valor;
            exito = true;
        }
        return exito;
    }

    @Override
    public boolean retirarInstrumento(String nombre, double valor) {
        boolean exito = false;
        if (numeroInstrumentos > 0 && valor > 0) {
            numeroInstrumentos--;
            valorInstrumentos -= valor;
            if (valorInstrumentos < 0) {
                valorInstrumentos = 0;
            }
            exito = true;
        }
        return exito;
    }

    public void prepararAcompanamiento() {
        acompanamientosPreparados++;
    }

    public void aumentarPrecision(int cantidad) {
        if (cantidad > 0) {
            precision += cantidad;
        }
    }
}

// ============================================================
// PARTE 7. MAIN
// ============================================================

public class Repaso2 {
    public static void main(String[] args) {

        // a) Crear objetos
        ResponsableMusical resp = new ResponsableMusical("ElMaestro", "Sevilla", 5, 30.0, "Rock sinfonico");

        Guitarrista g1 = new Guitarrista("Slash", "Malaga", 3, 20.0,
                "Guitarra electrica", 7, 4, 5, 0, 0, 2);
        Guitarrista g2 = new Guitarrista("Hendrix", "Cadiz", 2, 15.0,
                "Guitarra acustica", 5, 3, 3, 0, 0, 1);

        Pianista pi1 = new Pianista("Mozart", "Granada", 4, 25.0,
                "Piano cola", 8, 5, 4, 0, 0, 3, 6);
        Pianista pi2 = new Pianista("Chopin", "Cordoba", 1, 10.0,
                "Teclado", 4, 2, 2, 0, 0, 1, 4);

        // b) Modificar estado
        g1.registrarEnsayo();
        g1.consumirActuacion();
        g1.asignarInstrumento("Gibson Les Paul", 2500.0);
        g1.prepararSolo();
        g1.sumarPartiturasRevisadas();
        g1.sumarErroresDetectados(2);
        g1.corregirError();
        g1.sumarPuntosBase(5.0);

        g2.registrarEnsayo();
        g2.asignarInstrumento("Fender", 1800.0);
        g2.retirarInstrumento("Fender", 1800.0);
        g2.prepararSolo();

        pi1.registrarEnsayo();
        pi1.asignarInstrumento("Yamaha C7", 15000.0);
        pi1.prepararAcompanamiento();
        pi1.aumentarPrecision(2);

        pi2.registrarEnsayo();
        pi2.consumirActuacion();
        pi2.aumentarPrecision(3);
        pi2.prepararAcompanamiento();

        resp.asignarMiembro(g1);
        resp.asignarMiembro(g2);
        resp.asignarMiembro(pi1);
        resp.asignarMiembro(pi2);
        resp.quitarMiembro("Chopin");
        resp.sumarPartiturasRevisadas();
        resp.sumarPartiturasRevisadas();
        resp.sumarErroresDetectados(1);

        // c) Coleccion polimorfica
        ArrayList<MiembroBanda> todos = new ArrayList<>();
        todos.add(resp);
        todos.add(g1);
        todos.add(g2);
        todos.add(pi1);
        todos.add(pi2);

        // d) Recorrer y calcular
        double rendimientoTotal = 0;
        int disponibles = 0;
        for (MiembroBanda m : todos) {
            rendimientoTotal += m.calcularRendimiento();
            if (m.estaDisponible()) {
                disponibles++;
            }
        }

        // e) Referencias polimorficas obligatorias
        MiembroBanda referencia1 = g1;
        Tocable referencia2 = pi1;

        // f) Mostrar resultados
        System.out.println("Rendimiento responsable: " + resp.calcularRendimiento());
        System.out.println("Rendimiento g1: " + g1.calcularRendimiento());
        System.out.println("Rendimiento g2: " + g2.calcularRendimiento());
        System.out.println("Rendimiento pi1: " + pi1.calcularRendimiento());
        System.out.println("Rendimiento pi2: " + pi2.calcularRendimiento());
        System.out.println("Integrantes a cargo: " + resp.getNumeroIntegrantesACargo());
        System.out.println("Rendimiento equipo: " + resp.calcularRendimientoEquipo());
        System.out.println("Rendimiento total: " + rendimientoTotal);
        System.out.println("Miembros disponibles: " + disponibles);
    }
}
