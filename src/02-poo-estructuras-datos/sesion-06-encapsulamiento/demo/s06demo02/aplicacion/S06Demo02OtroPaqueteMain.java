package s06demo02.aplicacion;

import s06demo02.modelo.FichaAcceso;

public class S06Demo02OtroPaqueteMain {
    public static void main(String[] args) {
        FichaAcceso ficha = new FichaAcceso();
        System.out.println("Consulta publica: " + ficha.getDatoPrivado());

        //System.out.println(ficha.datoPrivado); // No compila: private.
        //System.out.println(ficha.datoDelPaquete); // No compila: otro paquete.
    }
}
