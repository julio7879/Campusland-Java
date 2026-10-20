public class S06Demo01PerfilUsuario {
    private String nombre;

    public S06Demo01PerfilUsuario() {
        nombre = "Sin nombre";
    }

    public String getNombre() {
        return nombre;
    }

    public boolean cambiarNombre(String nuevoNombre) {
        if (!esNombreValido(nuevoNombre)) {
            return false;
        }
        nombre = nuevoNombre.strip();
        return true;
    }

    private boolean esNombreValido(String texto) {
        // El cortocircuito evita llamar isBlank si texto es null.
        return texto != null && !texto.isBlank();
    }

    // Un setter que solo hiciera nombre = nuevoNombre permitiría nombres inválidos.
}
