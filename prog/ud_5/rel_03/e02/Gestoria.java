package prog.ud_5.rel_03.e02;

import java.util.ArrayList;
import java.time.LocalDate;

public class Gestoria {
    // Reglas del sistema:

    // No se repiten codigos
    // Un cliente puede tener muchos expedientes.
    // No se permiten DNIs repetidos.
    // Un expediente siempre pertenece a un cliente y a un trámite.

    private String nombre;
    public String direccion;
    public String telefono;
    private String horario;
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Tramite> tramites = new ArrayList<>();
    private ArrayList<Expediente> expedientes = new ArrayList<>();

    // []
    public Gestoria(String nombre, String direccion, String telefono, String horario, ArrayList<Cliente> clientes,
            ArrayList<Tramite> tramites, ArrayList<Expediente> expedientes) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horario = horario;
        setClientes(clientes);
        this.tramites = tramites;
        this.expedientes = expedientes;
    }

    public Gestoria(String nombre, String direccion, String telefono, String horario) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horario = horario;
    }

    // [ Metodos ]
    // Métodos mínimos obligatorios:

    // Listar pendientes de pago
    // Calcular facturación total (solo expedientes pagados)

    // Da de alta un nuevo cliente a la gestoria
    public int altaCliente(Cliente cliente) {
        int resultado = 0;

        // No puede medir el size de clientes si todavia no hay ninguno
        if (clientes.size() == 0) {
            this.clientes.add(cliente);
        } else {
            for (int i = 0; i < clientes.size(); i++) {
                if (!clientes.get(i).getDni().equalsIgnoreCase(cliente.getDni())) {
                    this.clientes.add(cliente);
                    resultado = 1;
                }
            }
        }

        return resultado;
    }

    // Da de alta un trámite en la gestoria
    public void altaTramite(Tramite tramite) {
        this.tramites.add(tramite);
    }

    // Abre un expediente relacionando cliente y tramite
    public void abrirExpediente(Cliente cliente, Tramite tramite) {
        LocalDate fechaApertura = LocalDate.now();
        Expediente expedienteAgregar;
        this.expedientes.add(expedienteAgregar = new Expediente(cliente, tramite, "ABIERTO", fechaApertura.toString()));
    }

    // Busca un expediente
    public Expediente buscarExpediente(int numeroExpediente) {
        Expediente expedienteEncontrado = null;
        boolean encontrado = false;

        // Buscar expediente
        for (int i = 0; i < expedientes.size() && !encontrado; i++) {
            if (numeroExpediente == expedientes.get(i).getNumeroExpediente()) {
                expedienteEncontrado = expedientes.get(i);
                encontrado = true;
            }
        }

        return expedienteEncontrado;
    }

    // Cambia el estado de un expediente
    public void cambiarEstado(int numExpediente, String estado) {
        Expediente expedienteEncontrado = buscarExpediente(numExpediente);
        boolean encontrado = false;

        // Cambiar estado
        expedienteEncontrado.setEstado(estado);
    }

    // Marca un expediente como pagado
    public void marcarPagado(int numExpediente) {
        Expediente expedienteEncontrado = buscarExpediente(numExpediente);
        boolean encontrado = false;

        // Marcar como pagado
        expedienteEncontrado.setPagado();
    }

    // TODO: REVISAR PARA TERMINAR
    // Lista los expedientes segun su estado
    public void listarPorEstado() {
        String listadoFinal = "";
        String listadoAbierto = "[ Abierto ]\n";
        String listadoProceso = "[ En proceso ]\n";
        String listadoFinalizado = "[ Finalizado ]\n";
        for (Expediente expediente : expedientes) {
            if (expediente.getEstado() == "ABIERTO") {
                listadoAbierto += expediente + "\n";
            } else if (expediente.getEstado() == "EN_PROCESO") {
                listadoProceso += expediente + "\n";
            } else if (expediente.getEstado() == "FINALIZADO") {
                listadoFinalizado += expediente + "\n";
            }
        }

        listadoFinal = "[ Listado ]\n" + listadoAbierto + listadoProceso + listadoFinalizado;
        System.out.println(listadoFinal);
    }

    // Muestra clientes de lka gestoria
    public String mostrarClientes() {
        String mensaje = "";
        for (Cliente cliente : clientes) {
            mensaje += "[ " + cliente.getNombre() + " ]" + "\nID: " + cliente.getId() + " | DNI: " + cliente.getDni()
                    + " | Direccion: "
                    + cliente.getDireccion() + "\nTlf. "
                    + cliente.getTelefono() + " | E-mail: " + cliente.getEmail() + "\n";
        }

        return mensaje;
    }

    // Listar pendientes de pago

    // Calcular facturación total (solo expedientes pagados)

    // [ Getter y Setters]
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Tramite> getTramites() {
        return tramites;
    }

    public void setTramites(ArrayList<Tramite> tramites) {
        this.tramites = tramites;
    }

    public ArrayList<Expediente> getExpedientes() {
        return expedientes;
    }

    public void setExpedientes(Expediente expediente) {
        this.expedientes.add(expediente);
    }

    @Override
    public String toString() {
        return "-- Gestoria --\n" + nombre + " | En " + direccion + " | Contacto: " + telefono + " | Horario: "
                + horario;
    }

}
