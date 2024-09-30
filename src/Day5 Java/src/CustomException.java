import java.util.Scanner;

class AgeException extends Exception {
    public AgeException(String message) {
        super(message);
    }
}

public class CustomException {
    public static void main(String[] args) {
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter age: ");
            int age = sc.nextInt();
            if(age<18)
            {
                throw new AgeException ("You are  not eligible");
            }
            else {
                System.out.println("You are eligible to vote");
            }
        }
        catch (AgeException ex) {
            System.out.println(ex);
        }
    }
}
