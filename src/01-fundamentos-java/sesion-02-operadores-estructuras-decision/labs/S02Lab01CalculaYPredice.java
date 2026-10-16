public class S02Lab01CalculaYPredice {
    public static void main(String[] args) {
        int unidades = 7;
        int capacidad = 2;
        int contador = 3;

        // TODO 1: Antes de ejecutar, anotamos lo que creemos que va a salir:
        // Predicción:
        //   Suma: 9             (7 + 2 = 9)
        //   Resta: 5            (7 - 2 = 5)
        //   Producto: 14        (7 * 2 = 14)
        //   Division entera: 3  (7 / 2 = 3, sin decimales porque ambos son int)
        //   Division decimal: 3.5 (7.0 / 2 conserva los decimales)
        //   Resto: 1            (7 % 2 = 1, es lo que sobra al dividir)
        //   Sin parentesis: 14  (2 + 3 * 4 → primero * luego + → 2 + 12 = 14)
        //   Con parentesis: 20  ((2 + 3) * 4 → primero la suma → 5 * 4 = 20)
        //   Contador incrementado: 4
        //   Contador decrementado: 3

        // TODO 2: Calculamos y mostramos cada operación básica
        int suma = unidades + capacidad;
        int resta = unidades - capacidad;
        int producto = unidades * capacidad;
        int divisionEntera = unidades / capacidad; // ambos int → el resultado es int (se trunca)
        int resto = unidades % capacidad;          // el residuo de dividir 7 entre 2 es 1

        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Producto: " + producto);
        System.out.println("Division entera: " + divisionEntera);

        // TODO 3: Al escribir 7.0 en vez de 7, Java trata la división como decimal (double).
        // Si ambos fueran int, Java descartaría los decimales y daría 3 en vez de 3.5.
        // Con un double en la operación, Java hace la división "real" y conserva el .5.
        double divisionDecimal = 7.0 / capacidad;
        System.out.println("Division decimal: " + divisionDecimal);

        System.out.println("Resto: " + resto);

        // TODO 4: La diferencia entre con y sin paréntesis muestra que Java aplica
        // el orden normal de operaciones: primero multiplicación, luego suma.
        // Los paréntesis fuerzan que la suma se haga primero.
        System.out.println("Sin parentesis: " + (2 + 3 * 4));   // = 14
        System.out.println("Con parentesis: " + ((2 + 3) * 4)); // = 20

        // TODO 5: ++ suma 1 a la variable en una sola instrucción. -- le resta 1.
        // Es una forma corta de escribir contador = contador + 1.
        contador++;
        System.out.println("Contador incrementado: " + contador);
        contador--;
        System.out.println("Contador decrementado: " + contador);

        // TODO 7: La predicción fue correcta en todos los casos.
        // El único que suele sorprender es la división entera (7/2=3) porque
        // mucha gente espera 3.5, pero int no guarda decimales.
    }
}
