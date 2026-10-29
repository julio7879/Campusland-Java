package s11reto04;

import java.util.Scanner;

/**
 * Captura y presentación por consola. Único lugar que conoce Scanner y textos.
 * Cambiar el texto del menú solo toca esta clase (y Producto para nombres/precios);
 * no afecta el cálculo. Los textos son los mismos de la sesión 3.
 */
public class ConsolaRestaurante {
    private static final int OPCION_FINALIZAR = 5;

    private final Scanner scanner;
    private final CalculadoraCuenta calculadora;

    public ConsolaRestaurante(Scanner scanner, CalculadoraCuenta calculadora) {
        this.scanner = scanner;
        this.calculadora = calculadora;
    }

    public void ejecutarJornada() {
        Jornada jornada = new Jornada();
        System.out.println("======================================================");
        System.out.println("       SISTEMA DE PEDIDOS - RESTAURANTE CAMPUS        ");
        System.out.println("======================================================");

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n------------------------------------------------------");
            System.out.println(" ATENDIENDO CLIENTE #" + (jornada.getClientes() + 1));
            System.out.println("------------------------------------------------------");

            Pedido pedido = capturarPedido();
            Cuenta cuenta = calculadora.calcular(pedido);
            mostrarResumen(pedido, cuenta);
            jornada.registrar(pedido, cuenta);

            continuar = preguntarOtroCliente();
        }
        mostrarJornada(jornada);
    }

    private Pedido capturarPedido() {
        Pedido pedido = new Pedido();
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            if (opcion == OPCION_FINALIZAR) {
                return pedido;
            }
            Producto producto = Producto.desdeOpcion(opcion);
            if (producto == null) {
                System.out.println("Error: Opción no válida. Por favor elija un número entre 1 y 5.");
                continue;
            }
            int cantidad = leerCantidad();
            pedido.agregar(producto, cantidad);
            long importeAgregado = producto.getPrecio() * cantidad;
            System.out.println("-> Agregado: " + cantidad + " x " + producto.getNombre() + " = "
                    + importeAgregado + " pesos");
            System.out.println("-> Subtotal actual: " + pedido.getSubtotal() + " pesos | Unidades acumuladas: "
                    + pedido.getUnidades());
        }
    }

    private void mostrarMenu() {
        System.out.println("\n--- Menú de Productos ---");
        for (Producto producto : Producto.values()) {
            System.out.println(producto.getOpcion() + " = " + producto.getNombre() + ", "
                    + producto.getPrecio() + " pesos");
        }
        System.out.println(OPCION_FINALIZAR + " = Finalizar pedido");
        System.out.print("Seleccione una opción: ");
    }

    private int leerCantidad() {
        int cantidad;
        do {
            System.out.print("Ingrese la cantidad (entera mayor que cero): ");
            cantidad = scanner.nextInt();
            if (cantidad <= 0) {
                System.out.println("Error: La cantidad debe ser un número entero mayor que cero.");
            }
        } while (cantidad <= 0);
        return cantidad;
    }

    private void mostrarResumen(Pedido pedido, Cuenta cuenta) {
        System.out.println("\n=================================");
        System.out.println("       RESUMEN DEL PEDIDO        ");
        System.out.println("=================================");
        System.out.println("Productos seleccionados:");
        if (pedido.estaVacio()) {
            System.out.println("  (Ninguno - Pedido vacío)");
        } else {
            for (Producto producto : Producto.values()) {
                if (pedido.cantidadDe(producto) > 0) {
                    System.out.println("  - " + producto.getNombre() + " x " + pedido.cantidadDe(producto));
                }
            }
        }
        System.out.println("---------------------------------");
        System.out.println("Unidades solicitadas : " + cuenta.getUnidades());
        System.out.println("Subtotal             : " + cuenta.getSubtotal() + " pesos");
        System.out.println("Descuento            : " + cuenta.getDescuento() + " pesos ("
                + detalleDescuento(pedido, cuenta) + ")");
        System.out.println("Domicilio            : " + cuenta.getDomicilio() + " pesos ("
                + detalleDomicilio(pedido, cuenta) + ")");
        System.out.println("Total a pagar        : " + cuenta.getTotal() + " pesos");
        System.out.println("=================================");
    }

    /**
     * Texto informativo: muestra el porcentaje EFECTIVO que resultó (descuento / subtotal).
     * No depende de cómo calcula la política; solo describe el importe obtenido.
     */
    private String detalleDescuento(Pedido pedido, Cuenta cuenta) {
        if (pedido.estaVacio()) {
            return "No aplica (pedido vacío)";
        }
        if (cuenta.getDescuento() == 0) {
            return "No aplica descuento";
        }
        long porcentajeEfectivo = cuenta.getDescuento() * 100 / cuenta.getSubtotal();
        return "Aplica " + porcentajeEfectivo + "%";
    }

    private String detalleDomicilio(Pedido pedido, Cuenta cuenta) {
        if (pedido.estaVacio()) {
            return "No aplica (pedido vacío)";
        }
        if (cuenta.getDomicilio() > 0) {
            return "Aplica recargo (neto < 30000)";
        }
        return "Gratis (neto >= 30000)";
    }

    private boolean preguntarOtroCliente() {
        int respuesta;
        do {
            System.out.print("\n¿Desea registrar otro cliente? (1=Sí, 2=No): ");
            respuesta = scanner.nextInt();
            if (respuesta != 1 && respuesta != 2) {
                System.out.println("Error: Ingrese 1 para Sí o 2 para No.");
            }
        } while (respuesta != 1 && respuesta != 2);
        return respuesta == 1;
    }

    private void mostrarJornada(Jornada jornada) {
        System.out.println("\n======================================================");
        System.out.println("           RESUMEN GENERAL DE LA JORNADA              ");
        System.out.println("======================================================");
        System.out.println("Total clientes atendidos : " + jornada.getClientes());
        System.out.println("Total unidades vendidas  : " + jornada.getUnidades());
        System.out.println("Productos vendidos en la jornada:");
        System.out.println("  - Hamburguesas : " + jornada.vendidosDe(Producto.HAMBURGUESA));
        System.out.println("  - Pizzas       : " + jornada.vendidosDe(Producto.PIZZA));
        System.out.println("  - Ensaladas    : " + jornada.vendidosDe(Producto.ENSALADA));
        System.out.println("  - Bebidas      : " + jornada.vendidosDe(Producto.BEBIDA));
        System.out.println("Total dinero recaudado   : " + jornada.getRecaudado() + " pesos");
        System.out.println("======================================================");
        System.out.println("Jornada finalizada exitosamente.");
    }
}
