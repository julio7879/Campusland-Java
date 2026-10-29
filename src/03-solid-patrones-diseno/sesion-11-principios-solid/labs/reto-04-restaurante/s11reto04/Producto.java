package s11reto04;

/**
 * Catálogo del menú: opción, nombre y precio unitario.
 * Motivo de cambio: precios o productos del restaurante.
 */
public enum Producto {
    HAMBURGUESA(1, "Hamburguesa", 18000),
    PIZZA(2, "Pizza", 25000),
    ENSALADA(3, "Ensalada", 15000),
    BEBIDA(4, "Bebida", 6000);

    private final int opcion;
    private final String nombre;
    private final long precio;

    Producto(int opcion, String nombre, long precio) {
        this.opcion = opcion;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getOpcion() {
        return opcion;
    }

    public String getNombre() {
        return nombre;
    }

    public long getPrecio() {
        return precio;
    }

    /** Devuelve el producto de la opción o null si la opción no corresponde a un producto. */
    public static Producto desdeOpcion(int opcion) {
        for (Producto producto : values()) {
            if (producto.opcion == opcion) {
                return producto;
            }
        }
        return null;
    }
}

