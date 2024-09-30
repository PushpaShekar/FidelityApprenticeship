import java.util.Scanner;

public class Concatenation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First String: ");
        String firstName = sc.nextLine();

        System.out.println("Enter Second String: ");
        String lastName = sc.nextLine();

        String fullName = firstName + " " + lastName;

        System.out.println("Full name is: " + fullName);

        sc.close();
    }
}
