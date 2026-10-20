package s07demo04;

public class S07Demo04InterfacesMain {
    public static void avisar(Notificable canal, String mensaje) {
        canal.notificar(mensaje);
    }

    public static void main(String[] args) {
        Notificable correo = new AlertaEmail();
        Notificable sms = new AlertaSMS();
        avisar(correo, "Clase de Java a las 8");
        avisar(sms, "Clase de Java a las 8");
    }
}
