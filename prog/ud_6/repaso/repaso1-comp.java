import java.util.ArrayList;

// ============================================================
// PARTE 1. CLASE ABSTRACTA
// ============================================================

abstract class PersonaAgrupacion {
    private String nombre;
    private int edad;
    private int antiguedad;

    PersonaAgrupacion(String nombre, int edad, int antiguedad) {
        this.nombre = nombre;
        this.edad = edad;
        this.antiguedad = antiguedad;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public int getAntiguedad() { return antiguedad; }
    public void setAntiguedad(int antiguedad) { this.antiguedad = antiguedad; }

    public abstract double calcularAportacion();
    public abstract boolean puedeParticipar();

    public void cumplirAnio() {
        edad++;
    }

    public void aumentarAntiguedad() {
        antiguedad++;
    }
}

// ============================================================
// PARTE 2. INTERFACES
// ============================================================

interface Asignable {
    boolean asignarInstrumento(String nombreInstrumento, double valorInstrumento);
    boolean quitarInstrumento(String nombreInstrumento, double valorInstrumento);
}

interface GestionHumana {
    boolean asignarMusico(PersonaAgrupacion persona);
    boolean expulsarMusico(String nombre);
}

// ============================================================
// PARTE 3. CLASE DIRECTOR
// ============================================================

class Director extends PersonaAgrupacion implements GestionHumana {
    private String especialidad;
    private int maximoMusicos;
    private ArrayList<PersonaAgrupacion> musicosAsignados;
    private double plusDireccion;

    Director(String nombre, int edad, int antiguedad,
             String especialidad, int maximoMusicos, double plusDireccion) {
        super(nombre, edad, antiguedad);
        this.especialidad = especialidad;
        this.maximoMusicos = maximoMusicos;
        this.plusDireccion = plusDireccion;
        this.musicosAsignados = new ArrayList<>();
    }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
    public int getMaximoMusicos() { return maximoMusicos; }
    public void setMaximoMusicos(int maximoMusicos) { this.maximoMusicos = maximoMusicos; }
    public ArrayList<PersonaAgrupacion> getMusicosAsignados() { return musicosAsignados; }
    public double getPlusDireccion() { return plusDireccion; }
    public void setPlusDireccion(double plusDireccion) { this.plusDireccion = plusDireccion; }

    @Override
    public double calcularAportacion() {
        double resultado = getAntiguedad() * 10 + plusDireccion + (musicosAsignados.size() * 5);
        return resultado;
    }

    @Override
    public boolean puedeParticipar() {
        boolean resultado = getEdad() >= 18;
        return resultado;
    }

    @Override
    public boolean asignarMusico(PersonaAgrupacion persona) {
        boolean exito = false;
        if (persona != null && musicosAsignados.size() < maximoMusicos) {
            boolean duplicado = false;
            for (PersonaAgrupacion p : musicosAsignados) {
                if (p.getNombre().equals(persona.getNombre())) {
                    duplicado = true;
                }
            }
            if (!duplicado) {
                musicosAsignados.add(persona);
                exito = true;
            }
        }
        return exito;
    }

    @Override
    public boolean expulsarMusico(String nombre) {
        boolean encontrado = false;
        for (int i = 0; i < musicosAsignados.size(); i++) {
            if (musicosAsignados.get(i).getNombre().equals(nombre)) {
                musicosAsignados.remove(i);
                encontrado = true;
            }
        }
        return encontrado;
    }

    public int contarMusicosAsignados() {
        int total = musicosAsignados.size();
        return total;
    }

    public double calcularValorTotalAportacionMusicos() {
        double total = 0;
        for (PersonaAgrupacion p : musicosAsignados) {
            total += p.calcularAportacion();
        }
        return total;
    }
}

// ============================================================
// PARTE 4. CLASE MUSICO
// ============================================================

class Musico extends PersonaAgrupacion {
    private String instrumentoPrincipal;
    private int nivel;
    private int asistenciaEnsayos;
    private double valorBase;

    Musico(String nombre, int edad, int antiguedad,
           String instrumentoPrincipal, int nivel, int asistenciaEnsayos, double valorBase) {
        super(nombre, edad, antiguedad);
        this.instrumentoPrincipal = instrumentoPrincipal;
        this.nivel = nivel;
        this.asistenciaEnsayos = asistenciaEnsayos;
        this.valorBase = valorBase;
    }

    public String getInstrumentoPrincipal() { return instrumentoPrincipal; }
    public void setInstrumentoPrincipal(String instrumentoPrincipal) { this.instrumentoPrincipal = instrumentoPrincipal; }
    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }
    public int getAsistenciaEnsayos() { return asistenciaEnsayos; }
    public void setAsistenciaEnsayos(int asistenciaEnsayos) { this.asistenciaEnsayos = asistenciaEnsayos; }
    public double getValorBase() { return valorBase; }
    public void setValorBase(double valorBase) { this.valorBase = valorBase; }

    @Override
    public double calcularAportacion() {
        double resultado = valorBase + (nivel * 2) + (asistenciaEnsayos * 1.5);
        return resultado;
    }

    @Override
    public boolean puedeParticipar() {
        boolean resultado = asistenciaEnsayos >= 3;
        return resultado;
    }

    public void registrarEnsayo() {
        asistenciaEnsayos++;
    }

    public void subirNivel() {
        nivel++;
    }
}

// ============================================================
// PARTE 5. CLASE TROMPETISTA
// ============================================================

class Trompetista extends Musico implements Asignable {
    private int numeroInstrumentos;
    private double valorInstrumentos;
    private int resistencia;
    private int numeroSolos;

    Trompetista(String nombre, int edad, int antiguedad,
                String instrumentoPrincipal, int nivel, int asistenciaEnsayos, double valorBase,
                int numeroInstrumentos, double valorInstrumentos, int resistencia, int numeroSolos) {
        super(nombre, edad, antiguedad, instrumentoPrincipal, nivel, asistenciaEnsayos, valorBase);
        this.numeroInstrumentos = numeroInstrumentos;
        this.valorInstrumentos = valorInstrumentos;
        this.resistencia = resistencia;
        this.numeroSolos = numeroSolos;
    }

    public int getNumeroInstrumentos() { return numeroInstrumentos; }
    public void setNumeroInstrumentos(int numeroInstrumentos) { this.numeroInstrumentos = numeroInstrumentos; }
    public double getValorInstrumentos() { return valorInstrumentos; }
    public void setValorInstrumentos(double valorInstrumentos) { this.valorInstrumentos = valorInstrumentos; }
    public int getResistencia() { return resistencia; }
    public void setResistencia(int resistencia) { this.resistencia = resistencia; }
    public int getNumeroSolos() { return numeroSolos; }
    public void setNumeroSolos(int numeroSolos) { this.numeroSolos = numeroSolos; }

    @Override
    public double calcularAportacion() {
        double resultado = super.calcularAportacion() + resistencia + (numeroSolos * 3) + (valorInstrumentos * 0.05);
        return resultado;
    }

    @Override
    public boolean puedeParticipar() {
        boolean resultado = super.puedeParticipar() && resistencia >= 5;
        return resultado;
    }

    @Override
    public boolean asignarInstrumento(String nombreInstrumento, double valorInstrumento) {
        boolean exito = false;
        if (nombreInstrumento != null && !nombreInstrumento.isEmpty() && valorInstrumento > 0) {
            numeroInstrumentos++;
            valorInstrumentos += valorInstrumento;
            exito = true;
        }
        return exito;
    }

    @Override
    public boolean quitarInstrumento(String nombreInstrumento, double valorInstrumento) {
        boolean exito = false;
        if (numeroInstrumentos > 0 && valorInstrumento > 0) {
            numeroInstrumentos--;
            valorInstrumentos -= valorInstrumento;
            if (valorInstrumentos < 0) {
                valorInstrumentos = 0;
            }
            exito = true;
        }
        return exito;
    }

    public void registrarSolo() {
        numeroSolos++;
    }

    public void aumentarResistencia(int cantidad) {
        if (cantidad > 0) {
            resistencia += cantidad;
        }
    }
}

// ============================================================
// PARTE 6. CLASE PERCUSIONISTA
// ============================================================

class Percusionista extends Musico implements Asignable {
    private int numeroInstrumentos;
    private double valorInstrumentos;
    private int potenciaGolpe;
    private int cambiosRitmoCorrectos;

    Percusionista(String nombre, int edad, int antiguedad,
                  String instrumentoPrincipal, int nivel, int asistenciaEnsayos, double valorBase,
                  int numeroInstrumentos, double valorInstrumentos, int potenciaGolpe, int cambiosRitmoCorrectos) {
        super(nombre, edad, antiguedad, instrumentoPrincipal, nivel, asistenciaEnsayos, valorBase);
        this.numeroInstrumentos = numeroInstrumentos;
        this.valorInstrumentos = valorInstrumentos;
        this.potenciaGolpe = potenciaGolpe;
        this.cambiosRitmoCorrectos = cambiosRitmoCorrectos;
    }

    public int getNumeroInstrumentos() { return numeroInstrumentos; }
    public void setNumeroInstrumentos(int numeroInstrumentos) { this.numeroInstrumentos = numeroInstrumentos; }
    public double getValorInstrumentos() { return valorInstrumentos; }
    public void setValorInstrumentos(double valorInstrumentos) { this.valorInstrumentos = valorInstrumentos; }
    public int getPotenciaGolpe() { return potenciaGolpe; }
    public void setPotenciaGolpe(int potenciaGolpe) { this.potenciaGolpe = potenciaGolpe; }
    public int getCambiosRitmoCorrectos() { return cambiosRitmoCorrectos; }
    public void setCambiosRitmoCorrectos(int cambiosRitmoCorrectos) { this.cambiosRitmoCorrectos = cambiosRitmoCorrectos; }

    @Override
    public double calcularAportacion() {
        double resultado = super.calcularAportacion() + (potenciaGolpe * 2) + (cambiosRitmoCorrectos * 4) + (valorInstrumentos * 0.03);
        return resultado;
    }

    @Override
    public boolean puedeParticipar() {
        boolean resultado = super.puedeParticipar() && potenciaGolpe >= 4;
        return resultado;
    }

    @Override
    public boolean asignarInstrumento(String nombreInstrumento, double valorInstrumento) {
        boolean exito = false;
        if (nombreInstrumento != null && !nombreInstrumento.isEmpty() && valorInstrumento > 0) {
            numeroInstrumentos++;
            valorInstrumentos += valorInstrumento;
            exito = true;
        }
        return exito;
    }

    @Override
    public boolean quitarInstrumento(String nombreInstrumento, double valorInstrumento) {
        boolean exito = false;
        if (numeroInstrumentos > 0 && valorInstrumento > 0) {
            numeroInstrumentos--;
            valorInstrumentos -= valorInstrumento;
            if (valorInstrumentos < 0) {
                valorInstrumentos = 0;
            }
            exito = true;
        }
        return exito;
    }

    public void registrarCambioRitmoCorrecto() {
        cambiosRitmoCorrectos++;
    }

    public void aumentarPotencia(int cantidad) {
        if (cantidad > 0) {
            potenciaGolpe += cantidad;
        }
    }
}

// ============================================================
// PARTE 7. MAIN
// ============================================================

public class Repaso1 {
    public static void main(String[] args) {

        // a) Crear objetos
        Director dir = new Director("Ana", 40, 10, "Viento", 20, 50.0);
        Trompetista t1 = new Trompetista("Luis", 25, 3, "Trompeta", 6, 4, 20.0, 0, 0, 7, 2);
        Trompetista t2 = new Trompetista("Carlos", 30, 5, "Trompeta", 7, 5, 25.0, 0, 0, 8, 3);
        Percusionista p1 = new Percusionista("Marta", 22, 2, "Caja", 5, 4, 15.0, 0, 0, 6, 1);
        Percusionista p2 = new Percusionista("Sara", 28, 4, "Timbal", 6, 3, 18.0, 0, 0, 5, 2);

        // b) Modificar estado
        t1.registrarEnsayo();
        t1.subirNivel();
        t1.asignarInstrumento("Bach Strad", 1200.0);
        t1.registrarSolo();
        t1.aumentarResistencia(3);

        t2.registrarEnsayo();
        t2.asignarInstrumento("Yamaha", 800.0);
        t2.quitarInstrumento("Yamaha", 800.0);

        p1.registrarEnsayo();
        p1.asignarInstrumento("Caja Pearl", 900.0);
        p1.registrarCambioRitmoCorrecto();
        p1.aumentarPotencia(2);

        p2.registrarEnsayo();
        p2.subirNivel();
        p2.aumentarPotencia(1);

        dir.asignarMusico(t1);
        dir.asignarMusico(t2);
        dir.asignarMusico(p1);
        dir.asignarMusico(p2);
        dir.expulsarMusico("Sara");

        // c) Coleccion polimorfica
        ArrayList<PersonaAgrupacion> todos = new ArrayList<>();
        todos.add(dir);
        todos.add(t1);
        todos.add(t2);
        todos.add(p1);
        todos.add(p2);

        // d) Recorrer y calcular
        double totalAportacion = 0;
        int puedenParticipar = 0;
        for (PersonaAgrupacion p : todos) {
            totalAportacion += p.calcularAportacion();
            if (p.puedeParticipar()) {
                puedenParticipar++;
            }
        }

        // e) Referencias polimorficas
        PersonaAgrupacion referencia1 = t1;
        Asignable referencia2 = t2;

        // f) Mostrar resultados
        System.out.println("Aportacion director: " + dir.calcularAportacion());
        System.out.println("Aportacion t1: " + t1.calcularAportacion());
        System.out.println("Aportacion t2: " + t2.calcularAportacion());
        System.out.println("Aportacion p1: " + p1.calcularAportacion());
        System.out.println("Aportacion p2: " + p2.calcularAportacion());
        System.out.println("Musicos asignados: " + dir.contarMusicosAsignados());
        System.out.println("Valor total musicos: " + dir.calcularValorTotalAportacionMusicos());
        System.out.println("Aportacion total: " + totalAportacion);
        System.out.println("Pueden participar: " + puedenParticipar);
    }
}
