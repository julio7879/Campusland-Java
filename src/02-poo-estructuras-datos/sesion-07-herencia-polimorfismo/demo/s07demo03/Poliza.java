package s07demo03;

public abstract class Poliza {
    private final String numero;
    private final int mesesVigencia;

    public Poliza(String numero) {
        // Los números de prueba son válidos; la vigencia del modelo es de 12 meses.
        this.numero = numero;
        this.mesesVigencia = 12;
    }

    public String getNumero() {
        return numero;
    }

    public int getMesesVigencia() {
        return mesesVigencia;
    }

    // Prima anual en pesos enteros; las variantes deben devolver un valor no negativo.
    public abstract long prima();
}
