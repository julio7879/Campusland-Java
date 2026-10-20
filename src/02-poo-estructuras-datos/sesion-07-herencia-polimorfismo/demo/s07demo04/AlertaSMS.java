package s07demo04;

public class AlertaSMS implements Notificable {
    @Override
    public void notificar(String mensaje) {
        // Solo simula el canal en consola; no envía mensajes reales.
        System.out.println("SMS: " + mensaje);
    }
}
