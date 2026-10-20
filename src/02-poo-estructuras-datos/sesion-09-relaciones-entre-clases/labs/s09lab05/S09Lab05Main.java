package s09lab05;

public class S09Lab05Main {
    public static void main(String[] args) {
        OrdenTrabajo primera = new OrdenTrabajo("OT-01");
        OrdenTrabajo segunda = new OrdenTrabajo("OT-02");
        primera.agregarPaso("Revisar cable");
        primera.agregarPaso("Probar encendido");
        segunda.agregarPaso("Limpiar filtro");
        System.out.println(primera.resumen());
        System.out.println(segunda.resumen());
        System.out.println("Completar indice 0: " + primera.completarPaso(0));
        System.out.println("Repetir indice 0: " + primera.completarPaso(0));
        System.out.println("Completar indice 8: " + primera.completarPaso(8));
        System.out.println(primera.resumen());
        System.out.println(segunda.resumen());
    }
}
