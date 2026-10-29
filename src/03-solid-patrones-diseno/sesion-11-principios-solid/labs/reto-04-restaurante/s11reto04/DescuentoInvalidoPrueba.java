package s11reto04;

/**
 * Implementación INCORRECTA a propósito, SOLO para pruebas:
 * devuelve un descuento mayor que el subtotal y viola el contrato (LSP).
 * CalculadoraCuenta debe detectarla.
 */
public class DescuentoInvalidoPrueba implements PoliticaDescuento {
    @Override
    public long calcularDescuento(long subtotal) {
        return subtotal + 1;
    }
}

