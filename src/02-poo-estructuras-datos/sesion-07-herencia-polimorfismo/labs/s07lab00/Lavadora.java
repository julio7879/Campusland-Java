package s07lab00;

// TO DO 1: Hacer que Lavadora herede de Electrodomestico.
public class Lavadora extends Electrodomestico {
    private int capacidadKg;

    public Lavadora(String marca, int capacidadKg) {
        // TO DO 2: Invocar super(marca) primero y guardar capacidadKg con this.
        super(marca);
        this.capacidadKg = capacidadKg;
    }

    public String ficha() {
        // TO DO 3: Devolver la ficha usando describirMarca() y capacidadKg.
        return "Lavadora " + describirMarca() + " - capacidad: " + capacidadKg + " kg";
    }
}
