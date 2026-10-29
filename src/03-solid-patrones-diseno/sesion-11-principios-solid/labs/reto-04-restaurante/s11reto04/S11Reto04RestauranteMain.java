package s11reto04;

import java.util.Scanner;

/** Punto de ensamblaje: elige la política concreta y la inyecta (DIP). */
public class S11Reto04RestauranteMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PoliticaDescuento politica = new DescuentoPorVolumen();
        CalculadoraCuenta calculadora = new CalculadoraCuenta(politica, new ReglaDomicilio());
        new ConsolaRestaurante(scanner, calculadora).ejecutarJornada();
        scanner.close();
    }
}

