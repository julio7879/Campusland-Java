package s11reto04;

/** Pruebas de regresión sin JUnit. Cada caso usa un pedido nuevo. */
public class S11Reto04PruebasRegresion {
    private static int aprobadas = 0;
    private static int fallidas = 0;

    public static void main(String[] args) {
        CalculadoraCuenta calculadora = new CalculadoraCuenta(new DescuentoPorVolumen(), new ReglaDomicilio());

        System.out.println("== Regresión de reglas originales ==");
        verificarFila(calculadora, "Bebida x1", pedido(Producto.BEBIDA, 1), 1, 6000, 0, 5000, 11000);
        verificarFila(calculadora, "Ensalada x2", pedido(Producto.ENSALADA, 2), 2, 30000, 0, 0, 30000);
        verificarFila(calculadora, "Pizza x4", pedido(Producto.PIZZA, 4), 4, 100000, 0, 0, 100000);
        verificarFila(calculadora, "Pizza x6", pedido(Producto.PIZZA, 6), 6, 150000, 15000, 0, 135000);
        verificarFila(calculadora, "Pizza x7", pedido(Producto.PIZZA, 7), 7, 175000, 26250, 0, 148750);
        Pedido mixto = pedido(Producto.HAMBURGUESA, 4);
        mixto.agregar(Producto.PIZZA, 2);
        verificarFila(calculadora, "Hamburguesa x4 + Pizza x2", mixto, 6, 122000, 12200, 0, 109800);
        verificarFila(calculadora, "Pedido vacío", new Pedido(), 0, 0, 0, 0, 0);

        System.out.println("\n== Entradas inválidas no alteran el pedido ==");
        verificar("Opción 7 no es producto", Producto.desdeOpcion(7) == null);
        Pedido conRechazo = pedido(Producto.BEBIDA, 1);
        try {
            conRechazo.agregar(Producto.PIZZA, -2);
            verificar("Cantidad -2 rechazada", false);
        } catch (IllegalArgumentException e) {
            verificar("Cantidad -2 rechazada sin cambios",
                    conRechazo.getUnidades() == 1 && conRechazo.getSubtotal() == 6000);
        }

        System.out.println("\n== Contrato LSP de DescuentoPorVolumen ==");
        PoliticaDescuento original = new DescuentoPorVolumen();
        long[] limites = {0, 6000, 100000, 100001, 150000, 150001, 175000};
        long[] esperados = {0, 0, 0, 10000, 15000, 22500, 26250};
        boolean contratoOk = true;
        for (int i = 0; i < limites.length; i++) {
            long descuento = original.calcularDescuento(limites[i]);
            if (descuento != esperados[i] || descuento < 0 || descuento > limites[i]) {
                contratoOk = false;
            }
        }
        verificar("Límites y rango 0..subtotal", contratoOk);

        System.out.println("\n== Colaborador controlado (prueba el armado, no la política) ==");
        CalculadoraCuenta conFija = new CalculadoraCuenta(new DescuentoFijoPrueba(), new ReglaDomicilio());
        // 30000 - 2000 = 28000 (neto < 30000) -> domicilio 5000.
        // Demuestra que el domicilio se evalúa sobre el neto, después del descuento.
        verificarFila(conFija, "Descuento fijo 2000 sobre Ensalada x2",
                pedido(Producto.ENSALADA, 2), 2, 30000, 2000, 5000, 33000);
        CalculadoraCuenta conInvalida = new CalculadoraCuenta(new DescuentoInvalidoPrueba(), new ReglaDomicilio());
        try {
            conInvalida.calcular(pedido(Producto.BEBIDA, 1));
            verificar("Política que viola el contrato es detectada", false);
        } catch (IllegalStateException e) {
            verificar("Política que viola el contrato es detectada", true);
        }

        System.out.println("\nResultado: " + aprobadas + " aprobadas, " + fallidas + " fallidas");
    }

    private static Pedido pedido(Producto producto, int cantidad) {
        Pedido pedido = new Pedido();
        pedido.agregar(producto, cantidad);
        return pedido;
    }

    private static void verificarFila(CalculadoraCuenta calculadora, String nombre, Pedido pedido,
            long unidades, long subtotal, long descuento, long domicilio, long total) {
        Cuenta c = calculadora.calcular(pedido);
        boolean ok = c.getUnidades() == unidades
                && c.getSubtotal() == subtotal
                && c.getDescuento() == descuento
                && c.getDomicilio() == domicilio
                && c.getTotal() == total
                && c.getNeto() == c.getSubtotal() - c.getDescuento()
                && c.getTotal() == c.getNeto() + c.getDomicilio();
        verificar(nombre + " -> " + c, ok);
    }

    private static void verificar(String nombre, boolean condicion) {
        if (condicion) {
            aprobadas++;
            System.out.println("[OK]    " + nombre);
        } else {
            fallidas++;
            System.out.println("[FALLA] " + nombre);
        }
    }
}
