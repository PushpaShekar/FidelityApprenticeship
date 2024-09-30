
import java.util.Scanner;

class Calculator {
    public int Addition(int a, int b) {
        return a + b;
    }
    public int Subtraction(int a, int b) {
        return a - b;
    }
    public int Multiplication(int a, int b) {
        return a * b;
    }

    public double Division(int a, int b, double[] remainder){
        remainder[0] = a%b;
        return (double) a/b;
    }
}

public class CalculatorProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.print("Enter the first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = sc.nextInt();

        System.out.print("Enter the operator (+, -, *, /): ");
        char operator = sc.next().charAt(0);

        switch(operator){

            case '+':
                System.out.print("Result: " + calculator.Addition(num1, num2));
                break;

            case '-':
                    System.out.print("Result: " + calculator.Subtraction(num1, num2));
                    break;

            case '*':
                System.out.print("Result: " + calculator.Multiplication(num1, num2));
                break;

            case '/':
                if (num2 != 0) {
                    double[] remainder = new double[1];
                    double quotient = calculator.Division(num1, num2, remainder);

                    System.out.println("Quotient: " + quotient);
                    System.out.println("Remainder: " + remainder[0]);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Error: Invalid operator.");
                break;
        }

        sc.close();
    }
}