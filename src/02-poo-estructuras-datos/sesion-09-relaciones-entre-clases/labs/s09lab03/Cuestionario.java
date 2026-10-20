package s09lab03;

import java.util.ArrayList;
import java.util.List;

public class Cuestionario {
    private final String titulo;
    private final List<Pregunta> preguntas = new ArrayList<>();

    public Cuestionario(String titulo) {
        this.titulo = titulo;
    }

    public boolean agregarPregunta(String texto) {
        if (texto == null || texto.isBlank()) {
            return false;
        }
        preguntas.add(new Pregunta(texto.strip()));
        return true;
    }

    public int cantidad() {
        return preguntas.size();
    }

    public void vaciar() {
        preguntas.clear();
    }

    public String resumen() {
        String texto = titulo + " (" + cantidad() + "):";
        for (Pregunta pregunta : preguntas) {
            texto += " [" + pregunta.getTexto() + "]";
        }
        return texto;
    }
}
