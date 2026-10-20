public class S03DemoFor {
    public static void main(String[] args) {
        int limite = 8;
        int detenerEn = 7;
        int suma = 0;
        int procesados = 0;

        for (int numero = 1; numero <= limite; numero++) {
            if (numero == detenerEn) {
                break;
            }
            if (numero % 3 == 0) {
                continue;
            }
            System.out.println("Procesado: " + numero);
            suma += numero;
            procesados++;
        }
        System.out.println("Cantidad procesada: " + procesados);
        System.out.println("Suma: " + suma);
    }
}
