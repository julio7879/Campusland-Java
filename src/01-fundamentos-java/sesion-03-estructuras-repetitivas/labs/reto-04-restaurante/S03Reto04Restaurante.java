import java.util.Scanner;

public class S03Reto04Restaurante {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Precios de cada producto que ofrecemos en el menú
        long precioHamburguesa = 18000;
        long precioPizza = 25000;
        long precioEnsalada = 15000;
        long precioBebida = 6000;

        // Variables para ir acumulando lo que el cliente va pidiendo
        // Usamos long porque estamos manejando dinero y queremos evitar desbordamientos
        long subtotal = 0;
        int unidadesTotales = 0;

        int opcion = 0;

        System.out.println("=== Bienvenido al Sistema de Pedidos del Restaurante ===");

        // Ciclo principal: mostramos el menú una y otra vez hasta que el cliente elija la opción 5 para salir
        do {
            System.out.println("\n--- Menú de Productos ---");
            System.out.println("1. Hamburguesa ($18.000)");
            System.out.println("2. Pizza ($25.000)");
            System.out.println("3. Ensalada ($15.000)");
            System.out.println("4. Bebida ($6.000)");
            System.out.println("5. Finalizar pedido");
            System.out.print("Por favor, selecciona una opción (1-5): ");

            opcion = scanner.nextInt();

            // Validamos primero que la opción sea válida antes de hacer cualquier otra cosa
            if (opcion < 1 || opcion > 5) {
                System.out.println("Error: La opción elegida no existe en el menú. Intenta de nuevo.");
                continue; // Volvemos a mostrar el menú sin alterar nada
            }

            // Si el cliente eligió la opción 5, no pedimos cantidad y salimos del ciclo de compras
            if (opcion == 5) {
                System.out.println("Has elegido finalizar el pedido.");
                break;
            }

            // Si llegó aquí es porque eligió una comida o bebida válida (1 al 4)
            // Ahora le pedimos cuántas unidades va a llevar y nos aseguramos de que sea un número positivo
            int cantidad = 0;
            do {
                System.out.print("Ingresa la cantidad que deseas llevar (mayor a 0): ");
                cantidad = scanner.nextInt();

                if (cantidad <= 0) {
                    System.out.println("Error: La cantidad debe ser al menos 1. Intenta nuevamente.");
                }
            } while (cantidad <= 0);

            // Determinamos qué producto eligió para saber su precio y su nombre
            long precioUnitario = 0;
            String nombreProducto = "";

            switch (opcion) {
                case 1:
                    nombreProducto = "Hamburguesa";
                    precioUnitario = precioHamburguesa;
                    break;
                case 2:
                    nombreProducto = "Pizza";
                    precioUnitario = precioPizza;
                    break;
                case 3:
                    nombreProducto = "Ensalada";
                    precioUnitario = precioEnsalada;
                    break;
                case 4:
                    nombreProducto = "Bebida";
                    precioUnitario = precioBebida;
                    break;
            }

            // Calculamos el costo de lo que acaba de agregar en este paso
            long importeAgregado = precioUnitario * cantidad;

            // Sumamos al total acumulado y contamos las unidades de producto llevadas
            subtotal += importeAgregado;
            unidadesTotales += cantidad;

            System.out.println("Agregaste: " + cantidad + " x " + nombreProducto + " ($" + importeAgregado + ")");
            System.out.println("Subtotal acumulado hasta el momento: $" + subtotal);

        } while (opcion != 5);

        // Ya terminamos de tomar el pedido. Ahora hacemos la liquidación final
        long descuento = 0;
        long neto = 0;
        long domicilio = 0;
        long total = 0;

        // Caso especial: si el cliente entró y de una marcó 5 sin pedir nada, todo queda en 0
        if (unidadesTotales == 0) {
            System.out.println("\nEl pedido finalizó sin productos registrados.");
        } else {
            // Aplicamos los descuentos según el monto acumulado.
            // Es muy importante revisar primero el descuento más alto (más de 150.000)
            // porque si revisáramos primero el de 100.000, una compra de 160.000 entraría en el de 10% por error.
            if (subtotal > 150000) {
                // 15% de descuento
                descuento = (subtotal * 15) / 100;
            } else if (subtotal > 100000) {
                // 10% de descuento
                descuento = (subtotal * 10) / 100;
            } else {
                descuento = 0;
            }

            // El neto es el valor que queda tras restar el descuento
            neto = subtotal - descuento;

            // Regla de domicilio elegida:
            // Cobramos los $5.000 de envío si el valor neto a pagar por los productos es menor a $30.000.
            // Esta regla premia el consumo real del cliente después de aplicar sus descuentos.
            if (neto < 30000) {
                domicilio = 5000;
            } else {
                domicilio = 0;
            }

            // El total definitivo a pagar suma el neto de los productos más el costo de entrega
            total = neto + domicilio;
        }

        // Mostramos el resumen final de la cuenta con todos los detalles claros
        System.out.println("\n=================================");
        System.out.println("       RESUMEN DE TU PEDIDO      ");
        System.out.println("=================================");
        System.out.println("Unidades solicitadas : " + unidadesTotales);
        System.out.println("Subtotal             : $" + subtotal);
        System.out.println("Descuento            : $" + descuento);
        System.out.println("Domicilio            : $" + domicilio);
        System.out.println("Total a pagar        : $" + total);
        System.out.println("=================================");
        System.out.println("¡Gracias por tu compra, vuelve pronto!");

        scanner.close();
    }
}
