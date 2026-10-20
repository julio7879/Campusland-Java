package s07demo02;

import s07demo01.Envio;
import s07demo01.EnvioExpress;
import s07demo01.EnvioLocal;

public class S07Demo02PolimorfismoMain {
    public static void mostrarCosto(Envio envio) {
        System.out.println("Costo: " + envio.calcularCosto() + " pesos");
    }

    public static void escuchar(Animal animal) {
        animal.hacerSonido();
    }

    public static void main(String[] args) {
        Envio primerEnvio = new EnvioLocal("L-02", "Bucaramanga");
        Envio segundoEnvio = new EnvioExpress("E-02", "Bogota");
        mostrarCosto(primerEnvio);
        mostrarCosto(segundoEnvio);

        Animal primerAnimal = new Perro();
        Animal segundoAnimal = new Gato();
        escuchar(primerAnimal);
        escuchar(segundoAnimal);
    }
}
