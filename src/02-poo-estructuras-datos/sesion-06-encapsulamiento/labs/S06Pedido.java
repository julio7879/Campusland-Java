public class S06Pedido {
    // TO DO 1: Declarar estado como campo privado String.
    private String estado;

    public S06Pedido() {
        // TO DO 2: Inicializar el estado en PENDIENTE.
        this.estado = "PENDIENTE";
    }

    public String getEstado() {
        // TO DO 3: Devolver el estado actual.
        return this.estado;
    }

    public boolean enviar() {
        // TO DO 4: Enviar solo un pedido PENDIENTE; cambiar a ENVIADO y devolver si
        // acepta.
        if (!"PENDIENTE".equals(this.estado)) {
            return false;
        }
        this.estado = "ENVIADO";
        return true;
    }

    public boolean cancelar() {
        // TO DO 5: Cancelar solo un pedido PENDIENTE; cambiar a CANCELADO y devolver si
        // acepta.
        if (!"PENDIENTE".equals(this.estado)) {
            return false;
        }
        this.estado = "CANCELADO";
        return true;
    }
}
