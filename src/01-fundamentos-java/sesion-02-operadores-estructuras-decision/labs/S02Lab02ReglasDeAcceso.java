public class S02Lab02ReglasDeAcceso {
    public static void main(String[] args) {
        int edad = 18;
        boolean esMiembro = false;
        boolean tieneInvitacion = true;
        boolean bloqueado = false;

        // TODO 1: La regla de acceso en palabras normales:
        // Para entrar hay que:
        //   - tener 18 años o más, Y
        //   - ser miembro O tener invitación (al menos una de las dos), Y
        //   - no estar bloqueado (si estás bloqueado, no entras de ninguna manera)

        // TODO 2: Traducimos esa regla a código booleano.
        // Agrupamos las "formas de tener autorización" entre paréntesis con ||,
        // y las unimos con && a los otros requisitos.
        // El ! delante de bloqueado significa "que NO esté bloqueado".
        boolean puedeEntrar = (edad >= 18) && (esMiembro || tieneInvitacion) && !bloqueado;

        // TODO 3: Según el resultado de puedeEntrar, imprimimos el mensaje correspondiente.
        // if/else garantiza que solo salga una de las dos líneas, nunca las dos juntas.
        if (puedeEntrar) {
            System.out.println("Acceso permitido");
        } else {
            System.out.println("Acceso denegado");
        }

        // TODO 4: Pruebas realizadas (cambiando los valores de arriba):
        //   edad=18, esMiembro=false, tieneInvitacion=true,  bloqueado=false → Acceso permitido
        //   edad=17, esMiembro=false, tieneInvitacion=true,  bloqueado=false → Acceso denegado
        //   edad=18, esMiembro=false, tieneInvitacion=true,  bloqueado=true  → Acceso denegado

        // TODO 5: El bloqueo siempre gana porque usamos && con !bloqueado.
        // Aunque tengas invitación y edad suficiente, si bloqueado=true entonces !bloqueado=false,
        // y cualquier cosa && false es false. No hay forma de pasar si estás bloqueado.
    }
}
