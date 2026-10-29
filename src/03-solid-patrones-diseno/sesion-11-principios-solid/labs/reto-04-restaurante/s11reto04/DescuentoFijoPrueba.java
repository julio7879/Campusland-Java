package s11reto04;

/**
 * Colaborador controlado SOLO para pruebas: descuento fijo de 2000
 * (o el subtotal si es menor). Cumple el contrato de PoliticaDescuento.
 * Sirve para probar cómo se arma la cuenta, no la política comercial.
 */
public class DescuentoFijoPrueba implements PoliticaDescuento {
    private static final long IMPORTE = 2000;

    @Override
    public long calcularDescuento(long subtotal) {
        if (subtotal < IMPORTE) {
            return subtotal;
        }
        return IMPORTE;
    }
}

