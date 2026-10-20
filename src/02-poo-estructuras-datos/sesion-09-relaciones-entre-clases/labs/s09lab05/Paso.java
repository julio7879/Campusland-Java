package s09lab05;

class Paso {
    private final String descripcion;
    private boolean completado;

    Paso(String descripcion) {
        this.descripcion = descripcion;
    }

    boolean completar() {
        if (completado) {
            return false;
        }
        completado = true;
        return true;
    }

    boolean estaCompletado() {
        return completado;
    }

    String resumen() {
        return descripcion + ": " + (completado ? "completado" : "pendiente");
    }
}
