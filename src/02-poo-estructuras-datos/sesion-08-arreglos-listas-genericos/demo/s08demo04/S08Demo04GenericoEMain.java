package s08demo04;

public class S08Demo04GenericoEMain {
    public static void main(String[] args) {
        Grupo<String> nombres = new Grupo<>();
        nombres.agregar("Ana");
        nombres.agregar("Luis");
        Grupo<Integer> edades = new Grupo<>();
        edades.agregar(20);
        edades.agregar(24);

        for (int i = 0; i < nombres.cantidad(); i++) {
            System.out.println("Nombre: " + nombres.obtener(i));
        }
        System.out.println("Primera edad: " + edades.obtener(0));
        System.out.println("Agregar null: " + nombres.agregar(null));
        System.out.println("Cantidad de nombres: " + nombres.cantidad());
        System.out.println("Indice inexistente: " + nombres.obtener(2));
        // nombres.agregar(25); // No compila: E fue concretado como String.
    }
}
