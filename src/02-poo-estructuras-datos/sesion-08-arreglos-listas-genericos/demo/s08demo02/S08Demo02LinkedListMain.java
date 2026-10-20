package s08demo02;

import java.util.LinkedList;
import java.util.List;

public class S08Demo02LinkedListMain {
    public static void main(String[] args) {
        LinkedList<String> visitas = new LinkedList<>();
        visitas.addLast("Ana");
        visitas.addLast("Luis");
        visitas.addFirst("Marta");
        System.out.println("Fila: " + visitas);
        System.out.println("Siguiente: " + visitas.peekFirst());
        System.out.println("Atendida: " + visitas.pollFirst());
        System.out.println("Pendientes: " + visitas);

        // La misma implementación también cumple el contrato List.
        List<String> comoLista = visitas;
        comoLista.set(0, "Luisa");
        System.out.println("Actualizada como List: " + visitas);
        for (String persona : comoLista) {
            System.out.println("Por atender: " + persona);
        }
        visitas.pollFirst();
        visitas.pollFirst();
        System.out.println("Consulta vacia: " + visitas.peekFirst());
        System.out.println("Retiro vacio: " + visitas.pollFirst());
    }
}
