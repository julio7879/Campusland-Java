package s09lab05;

import java.util.ArrayList;
import java.util.List;

public class OrdenTrabajo {
    private final String codigo;
    private final List<Paso> pasos = new ArrayList<>();

    public OrdenTrabajo(String codigo) {
        this.codigo = codigo;
    }

    public boolean agregarPaso(String descripcion) {
        if (descripcion == null || descripcion.isBlank()) {
            return false;
        }
        pasos.add(new Paso(descripcion.strip()));
        return true;
    }

    public boolean completarPaso(int indice) {
        if (indice < 0 || indice >= pasos.size()) {
            return false;
        }
        return pasos.get(indice).completar();
    }

    public int pendientes() {
        int cantidad = 0;
        for (Paso paso : pasos) {
            if (!paso.estaCompletado()) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public String resumen() {
        String texto = codigo + " - pendientes: " + pendientes();
        for (Paso paso : pasos) {
            texto += " [" + paso.resumen() + "]";
        }
        return texto;
    }
}
