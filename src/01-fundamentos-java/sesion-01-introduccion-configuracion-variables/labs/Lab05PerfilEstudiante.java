public class Lab05PerfilEstudiante {
    public static void main(String[] args) {

        // TODO 1: Los tipos que elegimos para cada dato del perfil:
        //   String  → nombre,   porque es texto con varias letras
        //   int     → edad,     porque la edad siempre es un número entero
        //   String  → ciudad,   porque el nombre de una ciudad es texto
        //   double  → promedio, porque el promedio puede tener decimales (4.2)
        //   boolean → activo,   porque solo puede ser true o false

        // TODO 2: Declaramos e inicializamos con los datos del perfil A
        String nombre = "Ana";
        int edad = 20;
        String ciudad = "Cucuta";
        double promedio = 4.2;
        boolean activo = true;

        // TODO 3: Declaramos CURSO como final — esto significa que no se puede cambiar jamás
        // Es como grabar algo en piedra: una vez que dices "Java", siempre será "Java".
        final String CURSO = "Java";

        // TODO 4: Mostramos la ficha inicial del estudiante con todas sus etiquetas
        System.out.println("=== Perfil del estudiante ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Promedio: " + promedio);
        System.out.println("Activo: " + activo);
        System.out.println("Curso: " + CURSO);

        // TODO 5: El estudiante se mudó, así que actualizamos la ciudad.
        // No volvemos a escribir "String ciudad" — esa variable ya existe, solo le cambiamos el valor.
        ciudad = "Bogota";
        System.out.println("Ciudad actualizada: " + ciudad);

        // TODO 6: Probamos el perfil A y la salida coincidió con la del README.

        // TODO 7: Si colocamos un breakpoint justo antes de la línea "ciudad = Bogota",
        // el debugger nos muestra que ciudad todavía vale "Cucuta".
        // Después de hacer Step Over, la variable cambia a "Bogota" — se puede ver en el panel de variables.

        // TODO 8: Elegimos double para promedio porque los promedios casi siempre tienen decimales.
        // final en CURSO garantiza que nadie (ni nosotros mismos) pueda cambiar ese valor después.
        // Si alguien intenta hacer CURSO = "Python", el compilador lo rechaza de inmediato.
    }
}
