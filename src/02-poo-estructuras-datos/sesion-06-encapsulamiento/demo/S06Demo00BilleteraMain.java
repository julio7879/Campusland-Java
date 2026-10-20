public class S06Demo00BilleteraMain {
    public static void main(String[] args) {
        S06Demo00Billetera billetera = new S06Demo00Billetera();

        // Si saldo fuera público, otra clase podría asignar un saldo inválido.
        // billetera.saldo = -5000L; // Con private, esta línea no compila.

        System.out.println("Saldo inicial: " + billetera.getSaldo());
        System.out.println("Recargar 50000: " + billetera.recargar(50000L));
        System.out.println("Saldo: " + billetera.getSaldo());
        System.out.println("Pagar 18000: " + billetera.pagar(18000L));
        System.out.println("Saldo: " + billetera.getSaldo());
        System.out.println("Pagar 40000: " + billetera.pagar(40000L));
        System.out.println("Saldo: " + billetera.getSaldo());
        System.out.println("Pagar -5000: " + billetera.pagar(-5000L));
        System.out.println("Saldo: " + billetera.getSaldo());
        System.out.println("Recargar 0: " + billetera.recargar(0L));
        System.out.println("Saldo: " + billetera.getSaldo());
    }
}
