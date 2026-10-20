package s07demo04;

public class AlertaEmail implements Notificable {
    @Override
    public void notificar(String mensaje) {
        // Solo simula el canal en consola; no envía mensajes reales.
        System.out.println("EMAIL: " + mensaje);
    }
}
