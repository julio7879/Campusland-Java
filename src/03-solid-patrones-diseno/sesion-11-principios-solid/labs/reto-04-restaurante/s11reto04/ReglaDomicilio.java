package s11reto04;

/**
 * Regla de domicilio conservada de la sesión 3: se evalúa sobre el NETO.
 * 5000 si neto < 30000; pedido vacío no paga domicilio.
 *
 * No es interfaz: hoy no existe una variación real que lo justifique.
 */
public class ReglaDomicilio {
    private static final long TARIFA = 5000;
    private static final long MINIMO_SIN_RECARGO = 30000;

    public long calcular(long neto, boolean pedidoVacio) {
        if (pedidoVacio) {
            return 0;
        }
        if (neto < MINIMO_SIN_RECARGO) {
            return TARIFA;
        }
        return 0;
    }
}
