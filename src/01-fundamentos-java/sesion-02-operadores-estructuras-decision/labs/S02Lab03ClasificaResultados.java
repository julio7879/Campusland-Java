public class S02Lab03ClasificaResultados {
    public static void main(String[] args) {
        int nota = 85;

        // TODO 1: Primero revisamos si la nota está en el rango válido (0 a 100).
        // Si no lo está, no tiene sentido clasificarla — la rechazamos de una vez.
        if (nota < 0 || nota > 100) {
            System.out.println("Nota invalida");

        // TODO 2 y 3: Si la nota es válida, la clasificamos de mayor a menor.
        // Evaluamos primero el rango más alto (A desde 90) y bajamos.
        // Esto importa porque si nota=95, la primera condición que se cumple es >=90 → A.
        // Si pusiéramos >=60 antes que >=90, una nota de 95 caería en D cuando debería ser A.
        } else if (nota >= 90) {
            System.out.println("Categoria A");
        } else if (nota >= 80) {
            System.out.println("Categoria B");
        } else if (nota >= 70) {
            System.out.println("Categoria C");
        } else if (nota >= 60) {
            System.out.println("Categoria D");
        } else {
            // Aquí caen todas las notas válidas menores a 60 → categoría E
            System.out.println("Categoria E");
        }

        // TODO 4: Pruebas realizadas:
        //   nota = 85  → Categoria B  ✓
        //   nota = 90  → Categoria A  ✓
        //   nota = 101 → Nota invalida ✓

        // TODO 5: Con nota = 95, si hubiéramos puesto >=60 antes que >=90,
        // el programa entraría en la primera condición que se cumpla, que sería >=60 (D),
        // y nunca llegaría a comprobar si es >=90 (A). Por eso el orden de arriba a abajo importa:
        // siempre ponemos el rango más alto primero.
    }
}
