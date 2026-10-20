package s08demo04;

import java.util.ArrayList;
import java.util.List;

public class Grupo<E> {
    private final List<E> elementos = new ArrayList<>();

    public boolean agregar(E elemento) {
        if (elemento == null) {
            return false;
        }
        elementos.add(elemento);
        return true;
    }

    public int cantidad() {
        return elementos.size();
    }

    public E obtener(int indice) {
        if (indice < 0 || indice >= elementos.size()) {
            return null; // Consulta sin resultado; el cliente debe comprobarlo.
        }
        return elementos.get(indice);
    }
}
