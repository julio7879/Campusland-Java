public class Lab04DiagnosticaYCorrige {
    public static void main(String[] args) {

        // CASO 1 (TODO 1): El error original era usar comillas simples para un texto String.
        // String nombre = 'Ana';  ← esto falla porque las comillas simples son solo para char (un carácter)
        // La corrección es usar comillas dobles, que es como Java identifica un texto (String).
        String nombre = "Ana";
        System.out.println("Nombre: " + nombre);

        // CASO 2 (TODO 2): El error era guardar un número con decimal en una variable int.
        // int temperatura = 23.5;  ← int solo acepta números enteros, 23.5 no cabe ahí
        // Usamos double, que sí acepta decimales, y así no perdemos el .5.
        double temperatura = 23.5;
        System.out.println("Temperatura: " + temperatura);

        // CASO 3 (TODO 3): El error era usar una variable (edad) sin haberle dado un valor antes.
        // Java no inventa valores — si intentas leer algo que no inicializaste, no compila.
        // La solución es asignarle un valor antes de imprimirla.
        int edad = 20;
        System.out.println("Edad: " + edad);

        // CASO 4 (TODO 4): El error era intentar cambiarle el valor a una variable final.
        // final String CURSO = "Java";
        // CURSO = "Python";  ← esto falla porque final significa que el valor no puede cambiar nunca
        // La solución es simplemente no reasignarlo y usarlo tal como está.
        final String CURSO = "Java";
        System.out.println("Curso: " + CURSO);

        // TODO 5: Resumen de los cuatro errores que encontramos:
        // Caso 1: pusimos 'Ana' con comillas simples y Java dijo "incompatible types".
        //         El problema es que las comillas simples son para char (un solo carácter),
        //         no para texto. La solución fue cambiar a "Ana" con comillas dobles.
        // Caso 2: intentamos guardar 23.5 en un int y Java dijo "possible lossy conversion".
        //         El int no acepta decimales así que lo cambiamos a double.
        // Caso 3: declaramos edad sin valor y Java dijo "variable might not have been initialized".
        //         Java no inventa valores, hay que darle uno antes de leerlo. Lo solucionamos con int edad = 20.
        // Caso 4: intentamos reasignar CURSO que es final y Java dijo "cannot assign a value to final variable".
        //         final significa que el valor queda fijo para siempre, así que simplemente eliminamos la reasignación.
    }
}
