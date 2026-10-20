public class S05Demo02ConversorTemperaturaMain {
    public static void main(String[] args) {
        double primeraTemperatura = S05Demo02ConversorTemperatura.celsiusAFahrenheit(0);
        double segundaTemperatura = S05Demo02ConversorTemperatura.celsiusAFahrenheit(25);
        System.out.println("0 C: " + primeraTemperatura + " F");
        System.out.println("25 C: " + segundaTemperatura + " F");
    }
}
