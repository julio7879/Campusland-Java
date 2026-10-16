public class S02Lab05MotorPromociones {
    public static void main(String[] args) {
        long subtotalCentavos = 18_500;
        int cantidad = 4;
        boolean esMiembro = true;
        String tipoEntrega = "EXPRESS";

        // TODO 1: Predicción antes de programar:
        // Miembro con subtotal >= 10000 → 10% de descuento
        // Descuento = 18500 * 10 / 100 = 1850 centavos
        // Neto = 18500 - 1850 = 16650 centavos
        // Envío EXPRESS = 1200 (el neto no llega a 25000, así que no aplica envío gratis)
        // Total = 16650 + 1200 = 17850 centavos

        // TODO 2: Validamos que los datos tengan sentido.
        // Un subtotal negativo o una cantidad de 0 no tiene lógica en un pedido real.
        boolean datosValidos = (subtotalCentavos >= 0 && subtotalCentavos <= 1_000_000) && (cantidad > 0);

        if (!datosValidos) {
            System.out.println("Pedido invalido: subtotal o cantidad fuera de rango");
        } else {

            // TODO 3: Elegimos el costo de envío según el tipo de entrega.
            // Si el tipo no existe en nuestra lista, lo marcamos con -1 (señal interna de error).
            long envioCentavos;
            switch (tipoEntrega) {
                case "ESTANDAR":
                    envioCentavos = 500;
                    break;
                case "EXPRESS":
                    envioCentavos = 1200;
                    break;
                case "RECOGIDA":
                    envioCentavos = 0;
                    break;
                default:
                    envioCentavos = -1;
            }

            if (envioCentavos < 0) {
                // Si el tipo de entrega no existe, lo avisamos y no mostramos nada más
                System.out.println("Pedido invalido: tipo de entrega desconocido");
            } else {

                // TODO 4: Elegimos el porcentaje de descuento según las reglas del negocio.
                // Las reglas son excluyentes entre sí, por eso usamos if/else if/else.
                int porcentajeDescuento;
                if (esMiembro && subtotalCentavos >= 10_000) {
                    // Miembros con compra mayor a 100 pesos → 10% de descuento
                    porcentajeDescuento = 10;
                } else if (!esMiembro && subtotalCentavos >= 20_000) {
                    // No miembros pero con compra grande → 5% de descuento
                    porcentajeDescuento = 5;
                } else {
                    // En cualquier otro caso no hay descuento
                    porcentajeDescuento = 0;
                }

                // TODO 5: Calculamos el descuento y el importe neto en centavos.
                // La división entera en Java descarta los decimales automáticamente,
                // así que 18500 * 10 / 100 = 1850 (sin redondeos raros).
                long descuentoCentavos = subtotalCentavos * porcentajeDescuento / 100;
                long netoCentavos = subtotalCentavos - descuentoCentavos;

                // TODO 6: Aplicamos envío gratis solo al ESTANDAR cuando el neto llega a 25000.
                // El envío gratis depende del neto (no del subtotal) porque el descuento
                // ya se aplicó — queremos saber cuánto paga realmente el cliente.
                if (tipoEntrega.equals("ESTANDAR") && netoCentavos >= 25_000) {
                    envioCentavos = 0;
                }

                long totalCentavos = netoCentavos + envioCentavos;

                // TODO 7: Mostramos el desglose completo con las etiquetas exactas del README
                System.out.println("Subtotal (centavos): " + subtotalCentavos);
                System.out.println("Descuento (%): " + porcentajeDescuento);
                System.out.println("Descuento (centavos): " + descuentoCentavos);
                System.out.println("Neto (centavos): " + netoCentavos);
                System.out.println("Envio (centavos): " + envioCentavos);
                System.out.println("Total (centavos): " + totalCentavos);

                // TODO 8: Resultados de las cinco pruebas mínimas:
                // Prueba 1: subtotal=18500, cantidad=4, miembro=true,  entrega=EXPRESS
                //           descuento=1850, neto=16650, envío=1200, total=17850
                // Prueba 2: subtotal=26314, cantidad=1, miembro=false, entrega=ESTANDAR
                //           descuento=1315, neto=24999, envío=500,  total=25499
                // Prueba 3: subtotal=26315, cantidad=1, miembro=false, entrega=ESTANDAR
                //           descuento=1315, neto=25000, envío=0 (gratis!), total=25000
                // Prueba 4: cambiando solo cantidad=0 → Pedido invalido: subtotal o cantidad fuera de rango
                // Prueba 5: cambiando solo tipoEntrega=DRON → Pedido invalido: tipo de entrega desconocido

                // TODO 10: El envío gratis depende del neto (no del subtotal) porque el
                // descuento ya redujo el precio — evaluamos lo que el cliente paga de verdad,
                // no lo que costaba antes de aplicar el descuento.
            }
        }
    }
}
