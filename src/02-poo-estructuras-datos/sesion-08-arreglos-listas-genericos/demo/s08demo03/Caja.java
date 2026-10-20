package s08demo03;

public class Caja<T> {
    private T contenido;

    // Los ejemplos crean cajas con contenido no nulo.
    public Caja(T contenido) {
        this.contenido = contenido;
    }

    public boolean guardar(T nuevoContenido) {
        if (nuevoContenido == null) {
            return false;
        }
        contenido = nuevoContenido;
        return true;
    }

    public T obtener() {
        return contenido;
    }
}
