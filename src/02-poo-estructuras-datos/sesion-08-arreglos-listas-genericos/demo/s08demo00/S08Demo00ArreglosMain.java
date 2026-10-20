package s08demo00;

import java.util.Arrays;

public class S08Demo00ArreglosMain {
    public static void main(String[] args) {
        int[] tiempos = new int[4];
        tiempos[0] = 12;
        tiempos[1] = 18;
        tiempos[2] = 10;
        tiempos[3] = 20;

        System.out.println("Longitud: " + tiempos.length);
        System.out.println("Primer tiempo: " + tiempos[0]);
        int total = 0;
        for (int i = 0; i < tiempos.length; i++) {
            System.out.println("Viaje " + (i + 1) + ": " + tiempos[i] + " min");
            total += tiempos[i];
        }
        System.out.println("Total: " + total + " min");
        System.out.println("Promedio: " + (double) total / tiempos.length + " min");

        int mayor = tiempos[0];
        for (int tiempo : tiempos) {
            if (tiempo > mayor) {
                mayor = tiempo;
            }
        }
        System.out.println("Mayor: " + mayor + " min");

        int indice = 4;
        if (indice >= 0 && indice < tiempos.length) {
            System.out.println(tiempos[indice]);
        } else {
            System.out.println("Indice rechazado: " + indice);
        }
        // System.out.println(tiempos[4]); // No es una posición válida.

        // Ordenar una copia conserva el orden cronológico de los viajes.
        int[] ordenados = Arrays.copyOf(tiempos, tiempos.length);
        Arrays.sort(ordenados);
        System.out.println("Original: " + Arrays.toString(tiempos));
        System.out.println("Copia ordenada: " + Arrays.toString(ordenados));
    }
}
