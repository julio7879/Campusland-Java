package s07demo03;

public class PolizaAuto extends Poliza {
    public PolizaAuto(String numero) {
        super(numero);
    }

    @Override
    public long prima() {
        // Tarifa didáctica: no representa una cotización real.
        return 600000L;
    }
}
