public class S06Inventario {
    // TO DO 1: Declarar existencias como int privado y capacidad como final int
    // privado igual a 100.
    private int existencias;
    private final int capacidad = 100;

    public S06Inventario() {
        // TO DO 2: Inicializar las existencias en cero.
        this.existencias = 0;
    }

    public int getExistencias() {
        // TO DO 3: Devolver las existencias actuales.
        return this.existencias;
    }

    public boolean ingresar(int cantidad) {
        // TO DO 4: Validar cantidad positiva y espacio disponible antes de sumar.
        if (cantidad <= 0 || cantidad > this.capacidad - this.existencias) {
            return false;
        }
        this.existencias += cantidad;
        return true;
    }

    public boolean retirar(int cantidad) {
        // TO DO 5: Validar cantidad positiva y existencias suficientes antes de restar.
        if (cantidad <= 0 || cantidad > this.existencias) {
            return false;
        }
        this.existencias -= cantidad;
        return true;
    }
}
