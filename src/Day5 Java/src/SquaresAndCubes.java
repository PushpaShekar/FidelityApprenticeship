import java.util.Scanner;

public class SquaresAndCubes {
    public static double FindSquare(double number) {
        return number * number;
    }

    public static double FindCube(double number){
        return number * number * number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number : ");
        double number = scanner.nextDouble();

        double square = FindSquare(number);
        double cube = FindCube(number);

        System.out.println("The square of " + number +" is: " + square);
        System.out.println("The cube of " + number +" is: " + cube);

        scanner.close();
    }
}
