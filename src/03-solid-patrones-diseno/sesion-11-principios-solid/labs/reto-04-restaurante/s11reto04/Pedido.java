package s11reto04;

import java.util.HashMap;
import java.util.Map;

/**
 * Estado de un pedido: cantidades por producto.
 * No lee teclado, no imprime y no conoce descuentos ni domicilio.
 */
public class Pedido {
    private final Map<Producto, Long> cantidades = new HashMap<>();

    /** Agrega unidades; una cantidad no positiva se rechaza sin modificar el pedido. */
    public void agregar(Producto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("Producto inexistente");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser un entero mayor que cero");
        }
        cantidades.put(producto, cantidadDe(producto) + cantidad);
    }

    public long cantidadDe(Producto producto) {
        return cantidades.getOrDefault(producto, 0L);
    }

    /** Unidades = productos individuales, no selecciones de menú. */
    public long getUnidades() {
        long unidades = 0;
        for (long cantidad : cantidades.values()) {
            unidades += cantidad;
        }
        return unidades;
    }

    public long getSubtotal() {
        long subtotal = 0;
        for (Producto producto : Producto.values()) {
            subtotal += producto.getPrecio() * cantidadDe(producto);
        }
        return subtotal;
    }

    public boolean estaVacio() {
        return cantidades.isEmpty();
    }
}
