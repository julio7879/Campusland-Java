package s09lab03;

public class S09Lab03Main {
    public static void main(String[] args) {
        Cuestionario java = new Cuestionario("Java");
        Cuestionario git = new Cuestionario("Git");
        java.agregarPregunta("Que hace main?");
        java.agregarPregunta("Para que sirve private?");
        git.agregarPregunta("Que hace git pull?");
        System.out.println(java.resumen());
        System.out.println(git.resumen());
        System.out.println("Agregar texto en blanco: " + java.agregarPregunta("   "));
        System.out.println("Cantidad Java: " + java.cantidad());
        java.vaciar();
        System.out.println("Tras vaciar Java:");
        System.out.println(java.resumen());
        System.out.println(git.resumen());
    }
}
