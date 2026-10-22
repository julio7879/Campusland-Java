public class S05LibroPrestamo {
    // TO DO 1: Declarar titulo (String) y prestado (boolean) como campos privados.
    private String titulo;
    private boolean prestado;

    public S05LibroPrestamo(String titulo) {
        // TO DO 2: Guardar el titulo y establecer prestado en false.
        this.titulo = titulo;
        this.prestado = false;
    }

    public String obtenerTitulo() {
        // TO DO 3: Devolver el titulo del objeto.
        return this.titulo;
    }

    public boolean prestar() {
        // TO DO 4: Rechazar un segundo prestamo; si esta disponible, prestarlo.
        if (this.prestado) {
            return false;
        }
        this.prestado = true;
        return true;
    }

    public void devolver() {
        // TO DO 5: Marcar el libro como no prestado.
        this.prestado = false;
    }

    public boolean estaPrestado() {
        // TO DO 6: Devolver el estado prestado del objeto.
        return this.prestado;
    }
}
