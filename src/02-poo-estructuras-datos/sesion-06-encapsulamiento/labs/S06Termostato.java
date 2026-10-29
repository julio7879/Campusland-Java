public class S06Termostato {
    // TO DO 1: Declarar temperaturaObjetivo como campo privado int.
    private int temperaturaObjetivo;

    public S06Termostato() {
        // TO DO 2: Inicializar la temperatura objetivo en 20.
        this.temperaturaObjetivo = 20;
    }

    public int getTemperaturaObjetivo() {
        // TO DO 3: Devolver la temperatura objetivo actual.
        return this.temperaturaObjetivo;
    }

    public boolean ajustarTemperatura(int nuevaTemperatura) {
        // TO DO 4: Aceptar solo de 16 a 30 inclusive; cambiar si acepta y devolver el
        // resultado.
        if (nuevaTemperatura < 16 || nuevaTemperatura > 30) {
            return false;
        }
        this.temperaturaObjetivo = nuevaTemperatura;
        return true;
    }
}
