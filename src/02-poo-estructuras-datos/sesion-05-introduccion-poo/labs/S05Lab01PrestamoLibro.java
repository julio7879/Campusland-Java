
public class S05Lab01PrestamoLibro {

    public static void main(String[] args) {
        // TO DO 7: Crear primerLibro con El principito y segundoLibro con Matilda.
        S05LibroPrestamo primerLibro = new S05LibroPrestamo("El principito");
        S05LibroPrestamo segundoLibro = new S05LibroPrestamo("Matilda");

        // TO DO 8: Mostrar titulo, dos intentos de prestamo y estado del primer libro.
        System.out.println("Libro: " + primerLibro.obtenerTitulo());
        System.out.println("Primer prestamo: " + primerLibro.prestar());
        System.out.println("Segundo intento: " + primerLibro.prestar());
        System.out.println("Prestado antes de devolver: " + primerLibro.estaPrestado());

        // TO DO 9: Devolver el primer libro y mostrar el estado de ambos libros.
        primerLibro.devolver();
        System.out.println("Prestado despues de devolver: " + primerLibro.estaPrestado());
        System.out.println("Segundo libro prestado: " + segundoLibro.estaPrestado());
    }
}
