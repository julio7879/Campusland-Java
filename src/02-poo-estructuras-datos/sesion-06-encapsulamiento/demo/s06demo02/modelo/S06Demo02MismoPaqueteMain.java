package s06demo02.modelo;

public class S06Demo02MismoPaqueteMain {
    public static void main(String[] args) {
        FichaAcceso ficha = new FichaAcceso();
        System.out.println("Consulta publica: " + ficha.getDatoPrivado());
        System.out.println("Acceso de paquete: " + ficha.datoDelPaquete);

        // System.out.println(ficha.datoPrivado); // No compila ni en el mismo paquete.
    }
}
