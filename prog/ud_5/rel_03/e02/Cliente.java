package prog.ud_5.rel_03.e02;

public class Cliente {
    private int id;
    private String nombre;
    private String dni;
    private String direccion;
    // cambio a privados porque requieren restriccion
    private String telefono;
    private String email;

    public Cliente(int id, String nombre, String dni, String direccion, String telefono, String email) {
        setId(id);
        this.nombre = nombre;
        setDni(dni);
        this.direccion = direccion;
        setTelefono(telefono);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        } else {
            // Cualquier id que esté a -1 es error
            this.id = -1;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public boolean setDni(String dni) {
        boolean exito = false;
        if (!dni.isBlank() && dni != null) {
            this.dni = dni;
            exito = true;
        } else {
            this.dni = "invalid";
        }

        return exito;
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

    public boolean setTelefono(String telefono) {
        boolean exito = false;
        if (telefono.length() == 9) {
            this.telefono = telefono;
            exito = true;
        }

        return exito;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        boolean exito = false;
        if (email.contains("@")) {
            this.email = email;
            exito = true;
        } else {
            this.email = "invalid";
        }

        return exito;
    }

    @Override
    public String toString() {
        return nombre + "\nID: " + id + " DNI: " + dni + " | Direccion" + direccion + "\nContacto: Tlf. "
                + telefono + " | E-mail: " + email + "\n";
    }

}
