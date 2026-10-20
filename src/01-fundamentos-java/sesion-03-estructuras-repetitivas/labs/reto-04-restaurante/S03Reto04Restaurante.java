import java.util.Scanner;

public class S03Reto04Restaurante {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Precios fijos de cada producto del menú
        final long PRECIO_HAMBURGUESA = 18000;
        final long PRECIO_PIZZA = 25000;
        final long PRECIO_ENSALADA = 15000;
        final long PRECIO_BEBIDA = 6000;
        final long TARIFA_DOMICILIO = 5000;

        // Acumuladores de la jornada completa
        int totalClientesAtendidos = 0;
        long totalRecaudadoJornada = 0;
        int totalUnidadesJornada = 0;
        int totalHamburguesasJornada = 0;
        int totalPizzasJornada = 0;
        int totalEnsaladasJornada = 0;
        int totalBebidasJornada = 0;

        boolean continuarJornada = true;

        System.out.println("======================================================");
        System.out.println("       SISTEMA DE PEDIDOS - RESTAURANTE CAMPUS        ");
        System.out.println("======================================================");

        // Ciclo de la jornada: permite atender varios clientes consecutivamente
        while (continuarJornada) {
            totalClientesAtendidos++;
            System.out.println("\n------------------------------------------------------");
            System.out.println(" ATENDIENDO CLIENTE #" + totalClientesAtendidos);
            System.out.println("------------------------------------------------------");

            // Variables acumuladoras que se reinician para cada cliente
            long subtotal = 0;
            int unidadesSolicitadas = 0;
            int cantHamburguesa = 0;
            int cantPizza = 0;
            int cantEnsalada = 0;
            int cantBebida = 0;

            int opcion = 0;

            // Ciclo del menú interactivo: se repite hasta que el cliente elija 5
            do {
                System.out.println("\n--- Menú de Productos ---");
                System.out.println("1 = Hamburguesa, 18000 pesos");
                System.out.println("2 = Pizza, 25000 pesos");
                System.out.println("3 = Ensalada, 15000 pesos");
                System.out.println("4 = Bebida, 6000 pesos");
                System.out.println("5 = Finalizar pedido");
                System.out.print("Seleccione una opción: ");

                opcion = scanner.nextInt();

                // Validación 1: Verificar que la opción pertenezca al menú
                if (opcion < 1 || opcion > 5) {
                    System.out.println("Error: Opción no válida. Por favor elija un número entre 1 y 5.");
                    continue; // Vuelve al menú sin pedir cantidad ni modificar acumuladores
                }

                // Opción 5: Finalizar pedido inmediatamente sin pedir cantidad
                if (opcion == 5) {
                    break;
                }

                // Validación 2: Para opciones 1 a 4, solicitar cantidad entera mayor que cero
                int cantidad = 0;
                do {
                    System.out.print("Ingrese la cantidad (entera mayor que cero): ");
                    cantidad = scanner.nextInt();

                    if (cantidad <= 0) {
                        System.out.println("Error: La cantidad debe ser un número entero mayor que cero.");
                    }
                } while (cantidad <= 0);

                // Determinación del producto y cálculo del importe
                long precioUnitario = 0;
                String nombreProducto = "";

                switch (opcion) {
                    case 1:
                        precioUnitario = PRECIO_HAMBURGUESA;
                        nombreProducto = "Hamburguesa";
                        cantHamburguesa += cantidad;
                        break;
                    case 2:
                        precioUnitario = PRECIO_PIZZA;
                        nombreProducto = "Pizza";
                        cantPizza += cantidad;
                        break;
                    case 3:
                        precioUnitario = PRECIO_ENSALADA;
                        nombreProducto = "Ensalada";
                        cantEnsalada += cantidad;
                        break;
                    case 4:
                        precioUnitario = PRECIO_BEBIDA;
                        nombreProducto = "Bebida";
                        cantBebida += cantidad;
                        break;
                }

                long importeAgregado = precioUnitario * cantidad;
                subtotal += importeAgregado;
                unidadesSolicitadas += cantidad;

                System.out.println(
                        "-> Agregado: " + cantidad + " x " + nombreProducto + " = " + importeAgregado + " pesos");
                System.out.println(
                        "-> Subtotal actual: " + subtotal + " pesos | Unidades acumuladas: " + unidadesSolicitadas);

            } while (opcion != 5);

            // Liquidación final del pedido
            long descuento = 0;
            String detalleDescuento = "No aplica descuento";
            long neto = 0;
            long domicilio = 0;
            String detalleDomicilio = "Gratis";
            long total = 0;

            if (unidadesSolicitadas == 0) {
                // Caso especial: pedido finalizado en 5 al inicio sin productos
                descuento = 0;
                detalleDescuento = "No aplica (pedido vacío)";
                neto = 0;
                domicilio = 0;
                detalleDomicilio = "No aplica (pedido vacío)";
                total = 0;
            } else {
                // Escala de descuentos por volumen:
                // Se evalúa primero el mayor (>150.000) para evitar que compras altas caigan en
                // el 10%
                if (subtotal > 150000) {
                    descuento = (subtotal * 15) / 100;
                    detalleDescuento = "Aplica 15%";
                } else if (subtotal > 100000) {
                    descuento = (subtotal * 10) / 100;
                    detalleDescuento = "Aplica 10%";
                } else {
                    descuento = 0;
                    detalleDescuento = "No aplica descuento";
                }

                neto = subtotal - descuento;

                // Regla de domicilio: se cobra $5000 si el neto es menor a 30000
                if (neto < 30000) {
                    domicilio = TARIFA_DOMICILIO;
                    detalleDomicilio = "Aplica recargo (neto < 30000)";
                } else {
                    domicilio = 0;
                    detalleDomicilio = "Gratis (neto >= 30000)";
                }

                total = neto + domicilio;
            }

            // Resumen detallado del pedido del cliente actual
            System.out.println("\n=================================");
            System.out.println("       RESUMEN DEL PEDIDO        ");
            System.out.println("=================================");
            System.out.println("Productos seleccionados:");
            if (unidadesSolicitadas == 0) {
                System.out.println("  (Ninguno - Pedido vacío)");
            } else {
                if (cantHamburguesa > 0)
                    System.out.println("  - Hamburguesa x " + cantHamburguesa);
                if (cantPizza > 0)
                    System.out.println("  - Pizza x " + cantPizza);
                if (cantEnsalada > 0)
                    System.out.println("  - Ensalada x " + cantEnsalada);
                if (cantBebida > 0)
                    System.out.println("  - Bebida x " + cantBebida);
            }
            System.out.println("---------------------------------");
            System.out.println("Unidades solicitadas : " + unidadesSolicitadas);
            System.out.println("Subtotal             : " + subtotal + " pesos");
            System.out.println("Descuento            : " + descuento + " pesos (" + detalleDescuento + ")");
            System.out.println("Domicilio            : " + domicilio + " pesos (" + detalleDomicilio + ")");
            System.out.println("Total a pagar        : " + total + " pesos");
            System.out.println("=================================");

            // Acumular a la jornada completa
            totalRecaudadoJornada += total;
            totalUnidadesJornada += unidadesSolicitadas;
            totalHamburguesasJornada += cantHamburguesa;
            totalPizzasJornada += cantPizza;
            totalEnsaladasJornada += cantEnsalada;
            totalBebidasJornada += cantBebida;

            // Extensión opcional: Preguntar si desea registrar otro cliente
            int respuestaCliente = 0;
            do {
                System.out.print("\n¿Desea registrar otro cliente? (1=Sí, 2=No): ");
                respuestaCliente = scanner.nextInt();
                if (respuestaCliente != 1 && respuestaCliente != 2) {
                    System.out.println("Error: Ingrese 1 para Sí o 2 para No.");
                }
            } while (respuestaCliente != 1 && respuestaCliente != 2);

            if (respuestaCliente == 2) {
                continuarJornada = false;
            }
        }

        // Resumen final de la jornada completa (Extensión opcional)
        System.out.println("\n======================================================");
        System.out.println("           RESUMEN GENERAL DE LA JORNADA              ");
        System.out.println("======================================================");
        System.out.println("Total clientes atendidos : " + totalClientesAtendidos);
        System.out.println("Total unidades vendidas  : " + totalUnidadesJornada);
        System.out.println("Productos vendidos en la jornada:");
        System.out.println("  - Hamburguesas : " + totalHamburguesasJornada);
        System.out.println("  - Pizzas       : " + totalPizzasJornada);
        System.out.println("  - Ensaladas    : " + totalEnsaladasJornada);
        System.out.println("  - Bebidas      : " + totalBebidasJornada);
        System.out.println("Total dinero recaudado   : " + totalRecaudadoJornada + " pesos");
        System.out.println("======================================================");
        System.out.println("Jornada finalizada exitosamente.");

        scanner.close();
    }
}
