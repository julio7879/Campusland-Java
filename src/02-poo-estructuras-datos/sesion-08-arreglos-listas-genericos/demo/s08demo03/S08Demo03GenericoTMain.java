package s08demo03;

public class S08Demo03GenericoTMain {
    public static void main(String[] args) {
        Caja<Integer> numero = new Caja<>(42);
        Caja<String> texto = new Caja<>("Hola, Java");
        int valor = numero.obtener();
        String mensaje = texto.obtener();
        System.out.println("Numero: " + valor);
        System.out.println("Texto: " + mensaje);
        System.out.println("Guardar otro numero: " + numero.guardar(7));
        System.out.println("Numero actual: " + numero.obtener());
        System.out.println("Guardar null: " + texto.guardar(null));
        System.out.println("Texto conservado: " + texto.obtener());

        // numero.guardar("siete"); // No compila: esta caja acepta Integer.
        // Caja<int> incorrecta; // Un parámetro de tipo requiere un tipo de referencia.
    }
}
