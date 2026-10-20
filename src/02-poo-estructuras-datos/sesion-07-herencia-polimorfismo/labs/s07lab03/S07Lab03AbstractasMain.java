package s07lab03;

public class S07Lab03AbstractasMain {
    public static void mostrarPlan(PlanEntrenamiento plan) {
        // TODO 5: Imprimir nombre y duracion mediante los metodos del plan.
    }

    public static void main(String[] args) {
        PlanEntrenamiento fuerza = new PlanFuerza();
        PlanEntrenamiento cardio = new PlanCardio();
        mostrarPlan(fuerza);
        mostrarPlan(cardio);
    }
}
