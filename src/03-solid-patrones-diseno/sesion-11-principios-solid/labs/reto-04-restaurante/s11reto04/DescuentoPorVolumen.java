package s11reto04;

/**
 * Política comercial original: un único descuento.
 * 15 % si subtotal > 150000; si no, 10 % si subtotal > 100000; si no, 0.
 * Se evalúa primero el umbral mayor.
 */
public class DescuentoPorVolumen implements PoliticaDescuento {
    private static final long UMBRAL_ALTO = 150000;
    private static final long UMBRAL_MEDIO = 100000;

    @Override
    public long calcularDescuento(long subtotal) {
        if (subtotal < 0) {
            throw new IllegalArgumentException("Subtotal inválido: " + subtotal);
        }
        if (subtotal > UMBRAL_ALTO) {
            return subtotal * 15 / 100;
        }
        if (subtotal > UMBRAL_MEDIO) {
            return subtotal * 10 / 100;
        }
        return 0;
    }
}

