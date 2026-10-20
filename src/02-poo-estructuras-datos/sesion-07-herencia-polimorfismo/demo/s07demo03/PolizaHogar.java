package s07demo03;

public class PolizaHogar extends Poliza {
    public PolizaHogar(String numero) {
        super(numero);
    }

    @Override
    public long prima() {
        // Tarifa didáctica: no representa una cotización real.
        return 240000L;
    }
}
