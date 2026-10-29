package s11reto04;

import java.util.Scanner;

/**
 * Clase principal (Punto de entrada de la aplicación).
 * 
 * Principio aplicado:
 * - DIP (Inversión de Dependencias): Actúa como el ensamblador (contenedor) del sistema.
 *   Instancia las dependencias concretas (DescuentoPorVolumen y ReglaDomicilio) y se las
 *   inyecta a la CalculadoraCuenta a través de la abstracción PoliticaDescuento.
 */
public class S11Reto04RestauranteMain {

    /**
     * Método principal que arranca el restaurante interactivo.
     * 
     * @param args argumentos de línea de comandos (no se requieren)
     */
    public static void main(String[] args) {
        // 1. Canal de entrada para la consola interactiva
        Scanner scanner = new Scanner(System.in);

        // 2. Selección de la política de descuento a aplicar (Punto de variación OCP)
        PoliticaDescuento politica = new DescuentoPorVolumen();

        // 3. Creación de la regla de domicilio fija
        ReglaDomicilio domicilio = new ReglaDomicilio();

        // 4. Inyección de dependencias en la calculadora de la cuenta
        CalculadoraCuenta calculadora = new CalculadoraCuenta(politica, domicilio);

        // 5. Inicialización y ejecución del flujo interactivo con el mesero/consola
        ConsolaRestaurante consola = new ConsolaRestaurante(scanner, calculadora);
        consola.ejecutarJornada();

        // 6. Cierre del recurso Scanner al terminar la jornada
        scanner.close();
    }
}


