package prog.ud_5.pt5;

import java.util.ArrayList;

/**
 * Clase zoologico que tiene muchos objetos Animal
 * Contiene métodos de gestion de animales
 */
public class Zoologico {
    // [ Variables ]
    private ArrayList<Animal> animales;

    // [ Constructores ]
    public Zoologico(ArrayList<Animal> animales) {
        this.animales = animales;
    }

    public Zoologico() {
        this.animales = new ArrayList<>();
    }

    // [ Getter y Setters ]
    public ArrayList<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(ArrayList<Animal> animales) {
        this.animales = animales;
    }

    // [ Métodos ]
    /**
     * Busca un animal a partir de su código de identificación
     * 
     * @param codigoAnimal ID del objeto animal que pertenece a la clase Animal
     * @return Animal si lo encuentra
     */
    public Animal buscarPorCodigo(String codigoAnimal) {
        Animal animalEncontrado = null;
        boolean encontrado = false;

        for (int i = 0; i < animales.size() && encontrado == false; i++) {
            if (animales.get(i).getCodigo().equals(codigoAnimal)) {
                animalEncontrado = animales.get(i);
                encontrado = true;
            }
        }

        return animalEncontrado;
    }

    /**
     * Añade un nuevo animal al zoologico si no recibe null
     * 
     * @param animalAniadir el animal a añadir
     * @return booleano de exito para control de errores en el futuro
     */
    public boolean aniadirAnimal(Animal animalAniadir) {
        boolean exito = false;

        if (animalAniadir != null) {
            animales.add(animalAniadir);
        }

        return exito;
    }

    /**
     * Elimina un animal a partir de su código
     * Utiliza la funcion buscarPorCódigo para encontrarlo
     * 
     * @param codigoAnimal ID del objeto animal que pertenece a la clase Animal
     */
    public boolean eliminarAnimal(Animal animalEliminar) {
        // Se podría hacer en una línea pero lo hago en dos para favorecer legibilidad
        boolean exito = false;

        if (animalEliminar != null) {
            animales.remove(animalEliminar);
            exito = true;
        }

        return exito;
    }

    // [ toString ]
    @Override
    public String toString() {
        String mensajeZoologico = "\n[ Zoológico ]\n";
        for (Animal animal : animales) {
            mensajeZoologico += animal + "\n";
        }
        return mensajeZoologico;
    }

}
