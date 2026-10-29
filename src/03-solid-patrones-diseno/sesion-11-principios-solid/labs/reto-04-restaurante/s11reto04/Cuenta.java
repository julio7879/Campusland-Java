package s11reto04;

/** Resultado de liquidar un pedido. Sus valores no cambian después de crearse. */
public class Cuenta {
    private final long unidades;
    private final long subtotal;
    private final long descuento;
    private final long neto;
    private final long domicilio;
    private final long total;

    public Cuenta(long unidades, long subtotal, long descuento, long neto, long domicilio, long total) {
        this.unidades = unidades;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.neto = neto;
        this.domicilio = domicilio;
        this.total = total;
    }

    public long getUnidades() {
        return unidades;
    }

    public long getSubtotal() {
        return subtotal;
    }

    public long getDescuento() {
        return descuento;
    }

    public long getNeto() {
        return neto;
    }

    public long getDomicilio() {
        return domicilio;
    }

    public long getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "unidades=" + unidades + ", subtotal=" + subtotal + ", descuento=" + descuento
                + ", neto=" + neto + ", domicilio=" + domicilio + ", total=" + total;
    }
}
