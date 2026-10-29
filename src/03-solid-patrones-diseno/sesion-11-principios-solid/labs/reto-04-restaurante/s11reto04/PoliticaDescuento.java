package s11reto04;

/**
 * Punto de variación (OCP/DIP) con contrato mínimo (ISP).
 *
 * Contrato (LSP) que toda implementación debe cumplir:
 * - Recibe un subtotal válido (>= 0).
 * - Devuelve un importe de descuento entre 0 y subtotal (inclusive).
 * - Para subtotal 0 (pedido vacío) devuelve 0.
 * - No modifica productos ni unidades y no agrega domicilio.
 *
 * Solo promete un importe; no asume que el descuento sea un porcentaje.
 */
public interface PoliticaDescuento {
    long calcularDescuento(long subtotal);
}
