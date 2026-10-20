package s07demo01;

public class Envio {
    private final String codigo;
    private final String destino;

    public Envio(String codigo, String destino) {
        // Este demo usa códigos y destinos válidos y no vacíos.
        this.codigo = codigo;
        this.destino = destino;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDestino() {
        return destino;
    }

    public long calcularCosto() {
        return 10000L;
    }

    public String consultarEstado(Rastreador rastreador) {
        // Uso puntual del colaborador: no se conserva como campo del envío.
        return rastreador.obtenerEstado();
    }
}
