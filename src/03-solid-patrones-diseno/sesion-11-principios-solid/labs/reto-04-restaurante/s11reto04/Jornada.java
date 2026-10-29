package s11reto04;

import java.util.HashMap;
import java.util.Map;

/** Acumulados de la jornada (extensión opcional de la sesión 3). */
public class Jornada {
    private int clientes;
    private long unidades;
    private long recaudado;
    private final Map<Producto, Long> vendidos = new HashMap<>();

    public void registrar(Pedido pedido, Cuenta cuenta) {
        clientes++;
        unidades += cuenta.getUnidades();
        recaudado += cuenta.getTotal();
        for (Producto producto : Producto.values()) {
            vendidos.put(producto, vendidosDe(producto) + pedido.cantidadDe(producto));
        }
    }

    public int getClientes() {
        return clientes;
    }

    public long getUnidades() {
        return unidades;
    }

    public long getRecaudado() {
        return recaudado;
    }

    public long vendidosDe(Producto producto) {
        return vendidos.getOrDefault(producto, 0L);
    }
}
