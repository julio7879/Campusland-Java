package s07demo00.aplicacion;

import s07demo00.base.Usuario;

public class Estudiante extends Usuario {
    private final String curso;

    public Estudiante(String nombre, String curso) {
        super(nombre);
        this.curso = curso;
    }

    public void mostrarFicha() {
        System.out.println(describirIdentidad() + " - curso: " + curso);
        // System.out.println(nombre); // No compila: el campo de Usuario es privado.
    }
}
