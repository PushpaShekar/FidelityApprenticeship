import java.util.Scanner;

public class RegistrationForm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your country: ");
        String country = scanner.nextLine();

        System.out.println("Welcome " + name + ". Your age is " + age + "  and you are from " + country + ".");

        scanner.close();
    }
}

