public class S06Lab02InventarioMain {
    public static void main(String[] args) {
        // TO DO 6: Crear un inventario y mostrar sus existencias iniciales.
        S06Inventario inventario = new S06Inventario();
        System.out.println("Existencias iniciales: " + inventario.getExistencias());

        // TO DO 7: Ingresar 10, retirar 11 y retirar 10; mostrar resultado y
        // existencias tras cada accion.
        System.out.println("Ingresar 10: " + inventario.ingresar(10));
        System.out.println("Existencias: " + inventario.getExistencias());
        System.out.println("Retirar 11: " + inventario.retirar(11));
        System.out.println("Existencias: " + inventario.getExistencias());
        System.out.println("Retirar 10: " + inventario.retirar(10));
        System.out.println("Existencias: " + inventario.getExistencias());

        // TO DO 8: Intentar ingresar 0 y 101; mostrar resultado y existencias tras cada
        // accion.
        System.out.println("Ingresar 0: " + inventario.ingresar(0));
        System.out.println("Existencias: " + inventario.getExistencias());
        System.out.println("Ingresar 101: " + inventario.ingresar(101));
        System.out.println("Existencias: " + inventario.getExistencias());
    }
}
