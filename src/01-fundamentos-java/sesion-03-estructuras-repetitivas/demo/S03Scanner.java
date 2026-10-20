import java.util.Scanner;

public class S03Scanner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int edad;

        do{
            System.out.print("Ingrese su edad: ");

            while(!scanner.hasNextInt()){
                System.out.println("Error: Debe ingresar un numero entero");
                scanner.next();
                System.out.println("Ingrese su edad nuevamente: ");
            }
            edad = scanner.nextInt();

            while (edad < 0 || edad > 100) {
                System.out.println("La edad debe estar entre 0 y 100.");
                System.out.print("Ingrese su edad nuevamente: ");
                edad = scanner.nextInt();
            }

            System.out.print("Ingrese su salario: ");
            while(!scanner.hasNextDouble()){
                System.out.println("Error: Debe ingresar un numero entero o decimal");
                scanner.next();
                System.out.println("Ingrese su salario nuevamente: ");
            }
            double salario = scanner.nextDouble();

            System.out.println("Edad: " + edad);
            System.out.println("Salario: " + salario);

            scanner.close();
        } while (edad < 0 || edad >100);
        System.out.println("Edad válida: " + edad);

    }
}
