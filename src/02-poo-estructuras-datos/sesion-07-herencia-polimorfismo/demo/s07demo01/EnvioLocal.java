package s07demo01;

public class EnvioLocal extends Envio {
    public EnvioLocal(String codigo, String destino) {
        super(codigo, destino);
    }

    @Override
    public long calcularCosto() {
        return 8000L;
    }
}
