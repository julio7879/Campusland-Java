public class S05Demo01VehiculosMain {
    public static void main(String[] args) {
        S05Demo01Vehiculo carro = new S05Demo01Vehiculo("Carro", "rojo");
        S05Demo01Vehiculo moto = new S05Demo01Vehiculo("Moto", "negra");
        S05Demo01Vehiculo bicicleta = new S05Demo01Vehiculo("Bicicleta", "azul");
        S05Demo01Vehiculo camion = new S05Demo01Vehiculo("Camion", "blanco");

        carro.recorrer(12);
        carro.recorrer(3);
        bicicleta.recorrer(4);

        carro.mostrarResumen();
        moto.mostrarResumen();
        bicicleta.mostrarResumen();
        camion.mostrarResumen();

        // Esta asignación comparte el objeto; no crea un segundo carro.
        S05Demo01Vehiculo otroNombre = carro;
        otroNombre.recorrer(2);
        System.out.println("Despues de usar otra referencia:");
        carro.mostrarResumen();
    }
}
