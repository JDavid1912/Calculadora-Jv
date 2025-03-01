//Joan Infante Velasquez,
//Santiago Bonilla Alonso
// Estiben Davila Niño
// Calculator

/// Otro forma sin interfaz grafica ///

import java.util.Scanner ;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean continuar1 = true ;
        while (continuar1) {


            System.out.println("Seleccion una operacion");
            System.out.println("1.SUMA ");
            System.out.println("2.RESTA");
            System.out.println("3. MULTIPLICACION!");
            System.out.println("4. DIVISION");
            System.out.println("5. POTENCIACION");
            System.out.println("6.RAIZ CUADARADA");
            System.out.println("7.MODULO");
            System.out.println("8.CONVERSION CELSIUS A FAHRENHEIT");
            System.out.println("Exit");

            System.out.print("Ingrese la opcion que necesitas");
            int opcion = scanner.nextInt();

            double num1 = 0, num2 = 0;
            if (opcion >= 1 && opcion <= 5 || opcion == 7) {
                System.out.print("Ingrese el primer número: ");
                num1 = scanner.nextDouble();
                System.out.print("Ingrese el segundo número: ");
                num2 = scanner.nextDouble();
            } else if (opcion == 6 || opcion == 8) {
                System.out.print("Ingrese el número: ");
                num1 = scanner.nextDouble();
            }

            double resultado = 0;
            switch (opcion) {
                case 1:
                    resultado = num1 + num2;
                    break;
                case 2:
                    resultado = num1 - num2;
                    break;
                case 3:
                    resultado = num1 * num2;
                    break;
                case 4:
                    resultado = num1 / num2;
                    break;
                case 5:
                    resultado = Math.pow(num1, num2);
                    break;
                case 6:
                    resultado = Math.sqrt(num1);
                    break;
                case 7:
                    resultado = num1 % num2;
                    break;
                case 8:
                    resultado = (num1 * 9 / 5) + 32;
                    break;
                default:
                    System.out.println("Opción no válida");
            }

            System.out.println("Resultado: " + resultado);
        }

        scanner.close();
        System.out.println("Calculadora finalizada.");


    }
}