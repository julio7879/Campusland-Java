package s07demo01;

public class EnvioExpress extends Envio {
    public EnvioExpress(String codigo, String destino) {
        super(codigo, destino);
    }

    @Override
    public long calcularCosto() {
        return super.calcularCosto() + 5000L;
    }
}
