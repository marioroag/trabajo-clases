package prog.ud_5.rel_02.e01;

import java.util.ArrayList;

// Luego, crea una clase Universidad que tenga un array de estudiantes y métodos para:

//     Agregar estudiantes
//     Mostrar todos los estudiantes
//     Buscar un estudiante por su número de matrícula

public class Universidad {

    ArrayList<Estudiante> alumnado;

    public Universidad() {
        this.alumnado = new ArrayList<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        alumnado.add(estudiante);
    }

    @Override
    public String toString() {
        String stringAlumnado = "";
        for (Estudiante estudiante : alumnado) {
            stringAlumnado += "--" + estudiante + "\n";
        }
        return stringAlumnado;
    }

    public Estudiante buscarEstudiante(String numeroDeMatricula) {
        Estudiante estudianteEncontrado = null;
        boolean encontrado = false;
        for (int i = 0; i < alumnado.size() && !encontrado; i++) {
            if (alumnado.get(i).getNumeroDeMatricula().equals(numeroDeMatricula)) {
                estudianteEncontrado = alumnado.get(i);
                encontrado = true;
            }
        }

        return estudianteEncontrado;
    }

}
