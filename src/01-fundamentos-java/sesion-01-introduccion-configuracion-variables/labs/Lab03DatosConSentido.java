public class Lab03DatosConSentido {
    public static void main(String[] args) {

        // TODO 1: Elegimos cada tipo según lo que va a guardar:
        //   String  → nombre,      porque el nombre es texto (puede tener espacios, letras, etc.)
        //   int     → edad,        porque la edad es un número entero, nunca tiene decimales
        //   double  → temperatura, porque la temperatura sí puede tener parte decimal (23.5)
        //   char    → inicial,     porque solo guardamos un carácter, la primera letra del nombre
        //   boolean → activo,      porque solo hay dos opciones: está activo o no lo está

        // TODO 2: Declaramos e inicializamos las cinco variables con el caso A del README
        String nombre = "Ana";
        int edad = 20;
        double temperatura = 23.5;
        char inicial = 'A';
        boolean activo = true;

        // TODO 3: Mostramos cada dato en su propia línea con su etiqueta
        // Usamos + para unir la etiqueta (texto) con la variable (su valor)
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Temperatura: " + temperatura);
        System.out.println("Inicial: " + inicial);
        System.out.println("Activo: " + activo);

        // TODO 4: Probamos el caso A — la salida coincide con la del README:
        // Nombre: Ana
        // Edad: 20
        // Temperatura: 23.5
        // Inicial: A
        // Activo: true

        // TODO 5: String no es un tipo primitivo porque en realidad es una clase de Java.
        // Los primitivos (int, double, char, boolean) guardan el valor directamente en memoria.
        // String en cambio es un objeto — guarda una referencia a un texto que puede ser
        // tan largo como se necesite. Por eso empieza con mayúscula y tiene métodos propios.
    }
}
