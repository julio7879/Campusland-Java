package s09lab04;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private final String nombre;
    private final List<Fotografia> fotografias = new ArrayList<>();

    public Album(String nombre) {
        this.nombre = nombre;
    }

    public boolean agregar(Fotografia fotografia) {
        if (fotografia == null) {
            return false;
        }
        for (Fotografia actual : fotografias) {
            if (actual == fotografia) {
                return false;
            }
        }
        fotografias.add(fotografia);
        return true;
    }

    public void vaciar() {
        fotografias.clear();
    }

    public int cantidad() {
        return fotografias.size();
    }

    public String resumen() {
        String texto = nombre + " (" + cantidad() + "):";
        for (Fotografia fotografia : fotografias) {
            texto += " " + fotografia.getTitulo();
        }
        return texto;
    }
}
