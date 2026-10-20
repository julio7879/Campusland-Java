public class S06Demo01PerfilUsuarioMain {
    public static void main(String[] args) {
        S06Demo01PerfilUsuario perfil = new S06Demo01PerfilUsuario();

        // perfil.nombre = ""; // No compila: nombre es privado.

        System.out.println("Nombre inicial: " + perfil.getNombre());
        System.out.println("Cambiar a Ana con espacios: " + perfil.cambiarNombre("  Ana  "));
        System.out.println("Nombre: [" + perfil.getNombre() + "]");
        System.out.println("Cambiar a espacios: " + perfil.cambiarNombre("   "));
        System.out.println("Nombre: [" + perfil.getNombre() + "]");
        System.out.println("Cambiar a null: " + perfil.cambiarNombre(null));
        System.out.println("Nombre: [" + perfil.getNombre() + "]");
    }
}
