package s07demo01;

public class S07Demo01UmlMain {
    public static void main(String[] args) {
        EnvioLocal local = new EnvioLocal("L-01", "Bucaramanga");
        EnvioExpress express = new EnvioExpress("E-01", "Bogota");
        Rastreador rastreador = new Rastreador();

        System.out.println(local.getCodigo() + " - " + local.getDestino()
                + " - costo: " + local.calcularCosto() + " pesos");
        System.out.println("Estado local: " + local.consultarEstado(rastreador));
        System.out.println(express.getCodigo() + " - " + express.getDestino()
                + " - costo: " + express.calcularCosto() + " pesos");
        System.out.println("Estado express: " + express.consultarEstado(rastreador));
    }
}
