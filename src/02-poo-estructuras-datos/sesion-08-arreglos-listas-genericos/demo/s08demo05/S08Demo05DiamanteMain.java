package s08demo05;

import s08demo03.Caja;

import java.util.ArrayList;
import java.util.List;

public class S08Demo05DiamanteMain {
    public static void main(String[] args) {
        List<String> explicita = new ArrayList<String>();
        List<String> inferida = new ArrayList<>();
        explicita.add("Java");
        inferida.add("Java");
        System.out.println("Tipo repetido: " + explicita);
        System.out.println("Con diamante: " + inferida);
        System.out.println("Mismo contenido: " + explicita.equals(inferida));

        Caja<String> saludo = new Caja<>("Hola");
        String contenido = saludo.obtener();
        System.out.println("Caja con diamante: " + contenido);

        // inferida.add(42); // No compila: <> no elimina el tipo String.
        // List<String> incorrecta = new List<>(); // List es una interfaz.
    }
}
