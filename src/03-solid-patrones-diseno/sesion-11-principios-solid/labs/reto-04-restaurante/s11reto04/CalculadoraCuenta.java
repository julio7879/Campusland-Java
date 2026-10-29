package s11reto04;

/**
 * Cliente de negocio: arma la cuenta en el orden fijo
 * subtotal -> descuento -> neto -> domicilio -> total.
 * Depende de la abstracción PoliticaDescuento recibida desde Main (DIP).
 * No usa Scanner ni imprime.
 */
public class CalculadoraCuenta {
    private final PoliticaDescuento politicaDescuento;
    private final ReglaDomicilio reglaDomicilio;

    public CalculadoraCuenta(PoliticaDescuento politicaDescuento, ReglaDomicilio reglaDomicilio) {
        if (politicaDescuento == null) {
            throw new IllegalArgumentException("Se requiere una política de descuento");
        }
        if (reglaDomicilio == null) {
            throw new IllegalArgumentException("Se requiere una regla de domicilio");
        }
        this.politicaDescuento = politicaDescuento;
        this.reglaDomicilio = reglaDomicilio;
    }

    public Cuenta calcular(Pedido pedido) {
        long subtotal = pedido.getSubtotal();
        long descuento = politicaDescuento.calcularDescuento(subtotal);
        if (descuento < 0 || descuento > subtotal) {
            throw new IllegalStateException("La política violó su contrato: descuento " + descuento
                    + " para subtotal " + subtotal);
        }
        long neto = subtotal - descuento;
        long domicilio = reglaDomicilio.calcular(neto, pedido.estaVacio());
        long total = neto + domicilio;
        return new Cuenta(pedido.getUnidades(), subtotal, descuento, neto, domicilio, total);
    }
}

