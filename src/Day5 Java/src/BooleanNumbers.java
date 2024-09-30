import java.util.Scanner;

public class BooleanNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x, y;

        System.out.print("Enter X value: ");
        x = scanner.nextInt();

        System.out.print("Enter Y value: ");
        y = scanner.nextInt();

        boolean result = x < y;

        System.out.println("The result of x is less than the y is " + result);

        scanner.close();
    }
}
