package s11reto04;

/**
 * Cliente de negocio: Responsable exclusivo de coordinar y liquidar la cuenta final de un pedido.
 * 
 * Principios aplicados:
 * - SRP (Responsabilidad Única): Solo calcula las operaciones numéricas de la cuenta. No pide datos al usuario ni imprime en pantalla.
 * - DIP (Inversión de Dependencias): Depende de la interfaz {@link PoliticaDescuento}, no de una implementación específica.
 * - LSP (Sustitución de Liskov): Verifica que cualquier política inyectada devuelva un descuento válido dentro del rango [0, subtotal].
 */
public class CalculadoraCuenta {
    private final PoliticaDescuento politicaDescuento;
    private final ReglaDomicilio reglaDomicilio;

    /**
     * Constructor con inyección de dependencias.
     * 
     * @param politicaDescuento contrato para calcular la rebaja comercial
     * @param reglaDomicilio regla para calcular el costo de envío
     * @throws IllegalArgumentException si alguna dependencia requerida es nula
     */
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

    /**
     * Liquida el pedido siguiendo el orden de negocio estricto:
     * 1. Subtotal = suma de productos por sus precios unitarios.
     * 2. Descuento = evaluación mediante la política inyectada.
     * 3. Neto = subtotal − descuento.
     * 4. Domicilio = evaluación sobre el importe neto.
     * 5. Total = neto + domicilio.
     * 
     * @param pedido comanda con los productos solicitados
     * @return objeto inmutable {@link Cuenta} con el desglose numérico completo
     * @throws IllegalStateException si la política viola el contrato LSP (descuento menor a 0 o mayor al subtotal)
     */
    public Cuenta calcular(Pedido pedido) {
        long subtotal = pedido.getSubtotal();
        long descuento = politicaDescuento.calcularDescuento(subtotal);

        // Validación estricta del contrato de sustitución de Liskov (LSP)
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


