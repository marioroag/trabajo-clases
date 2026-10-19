package prog.ud_5.rel_03.e02;

import java.util.ArrayList;
import java.util.Arrays;

public class Expediente {
    private int numeroExpediente;
    private Cliente cliente;
    private Tramite tramite;
    public String estado;
    private boolean pagado;
    public String fechaApertura;

    public Expediente(Cliente cliente, Tramite tramite, String estado,
            String fechaApertura) {
        setNumeroExpediente(numeroExpediente);
        this.cliente = cliente;
        this.tramite = tramite;
        setEstado(estado);
        this.pagado = false;
        this.fechaApertura = fechaApertura;
    }

    // tipos estado
    private ArrayList<String> tiposEstado = new ArrayList<>(
            Arrays.asList("ABIERTO", "EN_PROCESO", "FINALIZADO"));

    // contador
    private static int cantidadExpedientes;

    public int getNumeroExpediente() {
        return numeroExpediente;
    }

    public void setNumeroExpediente(int numeroExpediente) {
        this.numeroExpediente = cantidadExpedientes;
        cantidadExpedientes++;

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public String getEstado() {
        return estado;
    }

    public boolean setEstado(String estado) {
        boolean exito = false;
        if (tiposEstado.contains(estado)) {
            if (!(this.estado == tiposEstado.get(0) && estado == tiposEstado.get(2))) {
                this.estado = estado;
                exito = true;
            }
        }

        return exito;
    }

    public boolean isPagado() {
        return pagado;
    }

    public boolean setPagado() {
        boolean exito = false;
        if (estado != tiposEstado.get(0) && !this.pagado) {
            this.pagado = true;
            exito = true;
        }
        return exito;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    @Override
    public String toString() {
        return "Expediente [numeroExpediente=" + numeroExpediente + ", cliente=" + cliente.getNombre() + ", tramite="
                + tramite.getNombreTramite()
                + ", estado=" + estado + ", pagado=" + pagado + ", fechaApertura=" + fechaApertura + "]";
    }

}
