package s09lab04;

public class S09Lab04Main {
    public static void main(String[] args) {
        Fotografia playa = new Fotografia("Playa");
        Fotografia montana = new Fotografia("Montana");
        Album vacaciones = new Album("Vacaciones");
        Album favoritas = new Album("Favoritas");
        vacaciones.agregar(playa);
        vacaciones.agregar(montana);
        favoritas.agregar(playa);
        System.out.println(vacaciones.resumen());
        System.out.println(favoritas.resumen());
        vacaciones.vaciar();
        System.out.println("Tras vaciar Vacaciones:");
        System.out.println(vacaciones.resumen());
        System.out.println(favoritas.resumen());
        System.out.println("Fotos originales: " + playa.getTitulo() + ", " + montana.getTitulo());
    }
}
