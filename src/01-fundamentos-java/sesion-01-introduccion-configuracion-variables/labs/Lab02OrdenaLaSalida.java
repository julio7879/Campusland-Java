public class Lab02OrdenaLaSalida {
    public static void main(String[] args) {

        // TODO 1: Lo que creo que va a salir antes de ejecutar:
        // Predicción:
        //   AB        <- print no salta de línea, así que A y B quedan juntos
        //   C         <- println sí salta, así que C aparece en la siguiente línea
        //
        // TODO 2: Al ejecutar confirmamos que la predicción fue correcta.
        // print("A") no agrega salto, así que B aparece justo después en la misma línea.
        // println("B") sí agrega salto, así que C empieza en la línea siguiente.

        // TODO 3: Necesitamos tres instrucciones porque el lab pide usar print para A y B
        // y println solo al final para C, así se ve la diferencia entre los dos.
        // Aunque el código tiene tres líneas, en la consola todo sale en UNA sola línea: A - B - C
        System.out.print("A - ");
        System.out.print("B - ");
        System.out.println("C");

        // TODO 4: Agregamos la segunda línea que cierra el laboratorio
        System.out.println("Fin del laboratorio");

        // TODO 5: Quien produce cada salto de línea:
        //   println("C")               → termina la primera línea "A - B - C"
        //   println("Fin del...") → termina la segunda línea y el cursor baja al final
        // print no genera ningún salto; println sí lo hace siempre al terminar.
    }
}
