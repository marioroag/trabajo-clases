package prog.ud_6.repaso;
/*
 * REPASO 2 - Agrupación Musical "Al cielo con Visual Studio"
 *
 * En este ejercicio vas a desarrollar un sistema para gestionar actuaciones,
 * reparto de instrumentos y control de responsables dentro de la agrupación.
 *

 * REGLAS GENERALES OBLIGATORIAS
 * 1. Debes crear todas las clases e interfaces necesarias.
 * 2. Cada clase debe tener como mínimo 3 atributos y 4 métodos.
 * 3. Los métodos no pueden limitarse a hacer System.out.println().
 * 4. Deben modificar datos, devolver valores calculados o gestionar relaciones entre objetos.
 * 5. Usa ArrayList.
 * 6. En el main debes comprobar todo.
 *
 * ============================================================
 * PARTE 1. CLASE ABSTRACTA
 * ============================================================
 *
 * 1) Crea una clase abstracta llamada MiembroBanda.
 *
 * Debe tener exactamente estos 4 atributos:
 * - private String nombreArtistico;
 * - private String localidad;
 * - private int anosEnLaAgrupacion;
 * - private double puntosBase;
 *
 * Debe tener constructor, getters y setters.
 *
 * Debe incluir exactamente estos 4 métodos:
 *
 * a) public abstract double calcularRendimiento();
 *    Debe devolver un valor numérico.
 *
 * b) public abstract boolean estaDisponible();
 *    Debe devolver true o false según la clase hija.
 *
 * c) public void sumarAnos()
 *    Debe aumentar anosEnLaAgrupacion en 1.
 *
 * d) public void sumarPuntosBase(double puntos)
 *    REGLAS:
 *    - Si puntos es positivo, se suma.
 *    - Si puntos es 0 o negativo, no cambia nada.
 *
 * ============================================================
 * PARTE 2. INTERFACES
 * ============================================================
 *
 * 2) Crea estas 3 interfaces:
 *
 * INTERFAZ 1: Tocable
 * Debe declarar exactamente estos 2 métodos:
 * - boolean asignarInstrumento(String nombre, double valor);
 * - boolean retirarInstrumento(String nombre, double valor);
 *
 * INTERFAZ 2: Coordinable
 * Debe declarar exactamente estos 2 métodos:
 * - boolean asignarMiembro(MiembroBanda miembro);
 * - boolean quitarMiembro(String nombreArtistico);
 *
 * INTERFAZ 3: Revisable
 * Debe declarar exactamente estos 2 métodos:
 * - void sumarPartiturasRevisadas();
 * - void sumarErroresDetectados(int cantidad);
 *
 * ============================================================
 * PARTE 3. CLASE RESPONSABLEMUSICAL
 * ============================================================
 *
 * 3) Crea una clase ResponsableMusical que herede de MiembroBanda
 *    e implemente Coordinable y Revisable.
 *
 * Debe tener exactamente estos 5 atributos propios:
 * - private String repertorioSemana;
 * - private int numeroIntegrantesACargo;
 * - private ArrayList<MiembroBanda> integrantes;
 * - private int partiturasRevisadas;
 * - private int erroresDetectados;
 *
 * Debe tener constructor, getters y setters.
 *
 * Debe implementar exactamente estos 7 métodos:
 *
 * a) @Override
 *    public double calcularRendimiento()
 *    Debe devolver:
 *    getPuntosBase() + (getAnosEnLaAgrupacion() * 4) + (numeroIntegrantesACargo * 3)
 *    + (partiturasRevisadas * 2) - erroresDetectados
 *
 * b) @Override
 *    public boolean estaDisponible()
 *    Debe devolver true si erroresDetectados es menor o igual que 5.
 *
 * c) @Override
 *    public boolean asignarMiembro(MiembroBanda miembro)
 *    REGLAS:
 *    - Si miembro es null, devuelve false.
 *    - Si ya existe otro integrante con el mismo nombreArtistico, devuelve false.
 *    - Si no, lo añade a la lista, actualiza numeroIntegrantesACargo con el tamaño real y devuelve true.
 *
 * d) @Override
 *    public boolean quitarMiembro(String nombreArtistico)
 *    REGLAS:
 *    - Si encuentra un integrante con ese nombre, lo elimina.
 *    - Debe actualizar numeroIntegrantesACargo.
 *    - Devuelve true si lo elimina, false si no lo encuentra.
 *
 * e) @Override
 *    public void sumarPartiturasRevisadas()
 *    Debe aumentar partiturasRevisadas en 1.
 *
 * f) @Override
 *    public void sumarErroresDetectados(int cantidad)
 *    REGLAS:
 *    - Si cantidad es positiva, se suma a erroresDetectados.
 *    - Si cantidad es 0 o negativa, no cambia nada.
 *
 * g) public double calcularRendimientoEquipo()
 *    Debe devolver la suma de calcularRendimiento() de todos los integrantes.
 *
 * ============================================================
 * PARTE 4. CLASE INSTRUMENTISTA
 * ============================================================
 *
 * 4) Crea una clase Instrumentista que herede de MiembroBanda.
 *
 * Debe tener exactamente estos 4 atributos propios:
 * - private String instrumentoPrincipal;
 * - private int nivelTecnico;
 * - private int ensayosAsistidos;
 * - private int actuacionesDisponibles;
 *
 * Debe tener constructor, getters y setters.
 *
 * Debe implementar exactamente estos 4 métodos:
 *
 * a) @Override
 *    public double calcularRendimiento()
 *    Debe devolver:
 *    getPuntosBase() + (nivelTecnico * 5) + (ensayosAsistidos * 2)
 *
 * b) @Override
 *    public boolean estaDisponible()
 *    Debe devolver true si actuacionesDisponibles es mayor que 0.
 *
 * c) public void registrarEnsayo()
 *    Debe aumentar ensayosAsistidos en 1.
 *
 * d) public void consumirActuacion()
 *    REGLAS:
 *    - Si actuacionesDisponibles es mayor que 0, resta 1.
 *    - Si es 0, no hace nada.
 *
 * ============================================================
 * PARTE 5. CLASE GUITARRISTA
 * ============================================================
 *
 * 5) Crea una clase Guitarrista que herede de Instrumentista
 *    e implemente Tocable y Revisable.
 *
 * Debe tener exactamente estos 5 atributos propios:
 * - private int numeroInstrumentos;
 * - private double valorInstrumentos;
 * - private int solosPreparados;
 * - private int partiturasRevisadas;
 * - private int erroresDetectados;
 *
 * Debe tener constructor, getters y setters.
 *
 * Debe implementar exactamente estos 8 métodos:
 *
 * a) @Override
 *    public double calcularRendimiento()
 *    Debe devolver:
 *    super.calcularRendimiento() + (solosPreparados * 4) + (partiturasRevisadas * 1.5)
 *    - erroresDetectados + (valorInstrumentos * 0.02)
 *
 * b) @Override
 *    public boolean estaDisponible()
 *    Debe devolver true si:
 *    - super.estaDisponible() es true
 *    - y solosPreparados es mayor o igual que 1
 *
 * c) @Override
 *    public boolean asignarInstrumento(String nombre, double valor)
 *    REGLAS:
 *    - Si nombre es null o vacío, devuelve false.
 *    - Si valor es menor o igual que 0, devuelve false.
 *    - Si no, aumenta numeroInstrumentos en 1, suma valor a valorInstrumentos y devuelve true.
 *
 * d) @Override
 *    public boolean retirarInstrumento(String nombre, double valor)
 *    REGLAS:
 *    - Si numeroInstrumentos es 0, devuelve false.
 *    - Si valor es menor o igual que 0, devuelve false.
 *    - Si no, resta 1 a numeroInstrumentos y resta valor a valorInstrumentos.
 *    - Si valorInstrumentos queda negativo, déjalo en 0.
 *    - Devuelve true.
 *
 * e) @Override
 *    public void sumarPartiturasRevisadas()
 *    Debe aumentar partiturasRevisadas en 1.
 *
 * f) @Override
 *    public void sumarErroresDetectados(int cantidad)
 *    REGLAS:
 *    - Si cantidad es positiva, se suma a erroresDetectados.
 *    - Si cantidad es 0 o negativa, no cambia nada.
 *
 * g) public void prepararSolo()
 *    Debe aumentar solosPreparados en 1.
 *
 * h) public void corregirError()
 *    REGLAS:
 *    - Si erroresDetectados es mayor que 0, resta 1.
 *    - Si es 0, no hace nada.
 *
 * ============================================================
 * PARTE 6. CLASE PIANISTA
 * ============================================================
 *
 * 6) Crea una clase Pianista que herede de Instrumentista e implemente Tocable.
 *
 * Debe tener exactamente estos 4 atributos propios:
 * - private int numeroInstrumentos;
 * - private double valorInstrumentos;
 * - private int acompanamientosPreparados;
 * - private int precision;
 *
 * Debe tener constructor, getters y setters.
 *
 * Debe implementar exactamente estos 6 métodos:
 *
 * a) @Override
 *    public double calcularRendimiento()
 *    Debe devolver:
 *    super.calcularRendimiento() + (acompanamientosPreparados * 3) + precision + (valorInstrumentos * 0.015)
 *
 * b) @Override
 *    public boolean estaDisponible()
 *    Debe devolver true si:
 *    - super.estaDisponible() es true
 *    - y precision es mayor o igual que 5
 *
 * c) @Override
 *    public boolean asignarInstrumento(String nombre, double valor)
 *    Debe seguir exactamente las mismas reglas que en Guitarrista.
 *
 * d) @Override
 *    public boolean retirarInstrumento(String nombre, double valor)
 *    Debe seguir exactamente las mismas reglas que en Guitarrista.
 *
 * e) public void prepararAcompanamiento()
 *    Debe aumentar acompanamientosPreparados en 1.
 *
 * f) public void aumentarPrecision(int cantidad)
 *    REGLAS:
 *    - Si cantidad es positiva, se suma a precision.
 *    - Si cantidad es 0 o negativa, no cambia nada.
 *
 * ============================================================
 * PARTE 7. MAIN OBLIGATORIO
 * ============================================================
 *
 * 7) En el main de Repaso2 debes hacer exactamente estas pruebas:
 *
 * a) Crear:
 *    - 1 ResponsableMusical
 *    - 2 Guitarristas
 *    - 2 Pianistas
 *
 * b) Llamar a métodos para modificar estado:
 *    - registrarEnsayo()
 *    - consumirActuacion()
 *    - asignarInstrumento(...)
 *    - retirarInstrumento(...)
 *    - sumarPartiturasRevisadas()
 *    - sumarErroresDetectados(...)
 *    - prepararSolo()
 *    - corregirError()
 *    - prepararAcompanamiento()
 *    - aumentarPrecision(...)
 *    - asignarMiembro(...)
 *    - quitarMiembro(...)
 *    - sumarPuntosBase(...)
 *
 * c) Crear un ArrayList<MiembroBanda> con varios objetos distintos.
 *
 * d) Recorrer la colección y calcular:
 *    - el rendimiento total
 *    - el número de miembros disponibles
 *
 * e) Debes incluir obligatoriamente estas dos referencias:
 *    - MiembroBanda referencia1 = un objeto hijo;
 *    - Tocable referencia2 = un objeto que implemente esa interfaz;
 *
 * f) Mostrar por pantalla únicamente:
 *    - rendimiento del responsable
 *    - rendimiento de cada guitarrista
 *    - rendimiento de cada pianista
 *    - número de integrantes a cargo
 *    - rendimiento del equipo del responsable
 *    - rendimiento total de toda la colección
 *    - número total de miembros disponibles
 *

 */

public class e02 {
    public static void main(String[] args) {
        // Desarrolla aquí tu solución.
    }
}
