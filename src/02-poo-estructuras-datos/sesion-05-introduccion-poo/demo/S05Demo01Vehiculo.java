public class S05Demo01Vehiculo {
    private String tipo;
    private String color;
    private int kilometrosRecorridos;

    public S05Demo01Vehiculo(String tipo, String color) {
        this.tipo = tipo;
        this.color = color;
        this.kilometrosRecorridos = 0;
    }

    // En este demo se proporcionan distancias positivas pequeñas.
    public void recorrer(int kilometros) {
        kilometrosRecorridos += kilometros;
    }

    public void mostrarResumen() {
        System.out.println(tipo + " " + color + ": " + kilometrosRecorridos + " km");
    }
}
