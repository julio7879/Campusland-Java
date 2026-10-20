package s07demo03;

public class S07Demo03AbstractasMain {
    public static void mostrarPoliza(Poliza poliza) {
        System.out.println(poliza.getNumero() + " - vigencia: " + poliza.getMesesVigencia() + " meses - prima anual: " + poliza.prima() + " pesos");
    }

    public static void main(String[] args) {
        Poliza hogar = new PolizaHogar("H-01");
        Poliza auto = new PolizaAuto("A-01");
        mostrarPoliza(hogar);
        mostrarPoliza(auto);

        // Poliza general = new Poliza("P-01"); // No compila: Poliza es abstracta.
    }
}
