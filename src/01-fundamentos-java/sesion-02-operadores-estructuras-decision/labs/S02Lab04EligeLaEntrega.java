public class S02Lab04EligeLaEntrega {
    public static void main(String[] args) {
        String tipoEntrega = "EXPRESS";

        // TODO 1: Usamos switch para asignar el costo según el tipo de entrega.
        // Cada case cubre una opción válida. break evita que Java "se resbale"
        // hacia el siguiente case sin querer.
        long costoCentavos;
        switch (tipoEntrega) {
            case "ESTANDAR":
                costoCentavos = 500;
                break;
            case "EXPRESS":
                costoCentavos = 1200;
                break;
            case "RECOGIDA":
                costoCentavos = 0;
                break;
            default:
                // TODO 2: Si el tipo no es ninguno de los válidos, usamos -1 como señal interna.
                // No mostramos -1 al usuario, solo nos sirve para saber que algo salió mal.
                costoCentavos = -1;
        }

        // Separamos el caso inválido del válido
        if (costoCentavos == -1) {
            // TODO 5 (rama inválida): Solo mostramos este mensaje, nada más
            System.out.println("Tipo de entrega invalido");
        } else {
            // TODO 3: Mostramos el costo solo cuando el tipo es válido
            System.out.println("Costo (centavos): " + costoCentavos);

            // TODO 4: El operador ternario es como un if/else en una sola línea.
            // Si el tipo es RECOGIDA → "Retiro en tienda", si no → "Entrega a domicilio".
            // Usamos equals() para comparar textos (no == porque los String son objetos).
            String etiqueta = tipoEntrega.equals("RECOGIDA") ? "Retiro en tienda" : "Entrega a domicilio";

            // TODO 5 (rama válida): Mostramos la etiqueta
            System.out.println("Etiqueta: " + etiqueta);
        }

        // TODO 6: Pruebas realizadas:
        //   ESTANDAR → Costo: 500,  Etiqueta: Entrega a domicilio
        //   EXPRESS  → Costo: 1200, Etiqueta: Entrega a domicilio
        //   RECOGIDA → Costo: 0,    Etiqueta: Retiro en tienda
        //   DRON     → Tipo de entrega invalido
        //
        // break en switch clásico: evita que la ejecución "caiga" al siguiente case.
        // Las flechas (switch moderno): cada flecha ya tiene un scope propio, no hace falta break.
    }
}
