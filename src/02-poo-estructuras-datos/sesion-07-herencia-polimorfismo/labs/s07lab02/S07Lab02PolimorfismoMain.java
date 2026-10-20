package s07lab02;

public class S07Lab02PolimorfismoMain {
    public static void mostrarDuracion(ServicioTecnico servicio) {
        // TODO 3: Imprimir la duracion consultando servicio.duracionMinutos().
    }

    public static void main(String[] args) {
        // TODO 4: Reemplazar null por objetos RevisionEquipo e InstalacionPrograma.
        ServicioTecnico revision = null;
        ServicioTecnico instalacion = null;
        mostrarDuracion(revision);
        mostrarDuracion(instalacion);
    }
}
