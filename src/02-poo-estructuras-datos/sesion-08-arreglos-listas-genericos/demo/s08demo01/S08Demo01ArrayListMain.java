package s08demo01;

import java.util.ArrayList;
import java.util.List;

public class S08Demo01ArrayListMain {
    public static void main(String[] args) {
        List<String> compras = new ArrayList<>();
        System.out.println("Vacia: " + compras.isEmpty());
        compras.add("Pan");
        compras.add("Leche");
        compras.add("Pan");
        System.out.println("Compras: " + compras);
        System.out.println("Cantidad: " + compras.size());
        System.out.println("Primera: " + compras.get(0));

        compras.set(1, "Fruta");
        System.out.println("Tras set: " + compras);
        System.out.println("Contiene Pan: " + compras.contains("Pan"));
        compras.remove("Pan");
        System.out.println("Tras quitar primer Pan: " + compras);
        compras.remove(0);
        System.out.println("Tras quitar indice 0: " + compras);

        for (String compra : compras) {
            System.out.println("Pendiente: " + compra);
        }

        // remove(int) quita por índice; remove(Integer) quita por valor.
        List<Integer> numeros = new ArrayList<>();
        numeros.add(10);
        numeros.add(20);
        numeros.add(10);
        numeros.remove(1);
        System.out.println("Quitar indice 1: " + numeros);
        numeros.remove(Integer.valueOf(10));
        System.out.println("Quitar valor 10: " + numeros);

        compras.clear();
        System.out.println("Vacia al terminar: " + compras.isEmpty());
        // compras.get(0); // Ya no existe ese índice: comprobar size antes de acceder.
    }
}
