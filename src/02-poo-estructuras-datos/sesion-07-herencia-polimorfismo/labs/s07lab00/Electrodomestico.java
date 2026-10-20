package s07lab00;

public class Electrodomestico {
    private final String marca;

    public Electrodomestico(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    protected String describirMarca() {
        return marca;
    }
}
