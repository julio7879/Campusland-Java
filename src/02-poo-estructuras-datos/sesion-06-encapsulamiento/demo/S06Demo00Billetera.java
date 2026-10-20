public class S06Demo00Billetera {
    private long saldo;
    private final long limiteSaldo = 1_000_000L;

    public S06Demo00Billetera() {
        saldo = 0L;
    }

    public long getSaldo() {
        return saldo;
    }

    public boolean recargar(long valor) {
        // Validar antes de sumar también evita un desbordamiento.
        if (valor <= 0 || valor > limiteSaldo - saldo) {
            System.out.println("El valor es menor a 0 o supera el limite de saldo");
            return false;
        }
        saldo += valor;
        return true;
    }

    public boolean pagar(long valor) {
        // Sin la condición positiva, restar un negativo aumentaría el saldo.
        if (valor <= 0 || valor > saldo) {
            System.out.println("El valor es menor a 0 o el valor supera el saldo pdte");
            return false;
        }
        saldo -= valor;
        return true;
    }
}
