import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.util.Scanner;

class Person {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public LocalDate getDob() {
        return birthDate;
    }
    public void setDob(LocalDate dob) {
        this.birthDate = dob;
    }

    public String getAdult() {
        int age = GetAge(this.birthDate);
        if (age >= 18) {
            return "Adult";
        } else {
            return "Child";
        }
    }

    public int GetAge(LocalDate dob) {
//        LocalDate
//
//        if (dob != null) {
//            return Period.between(dob, currentDate).getYears();
//        }
//        return 0;
    }

    public void DisplayDetails() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        int age = GetAge(this.birthDate);
        System.out.println("Age: " + age);
        System.out.println(getAdult());
    }
}
public class CalculateAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Person person = new Person();

        System.out.print("Enter first name: ");
        person.setFirstName(sc.nextLine());

        System.out.print("Enter last name: ");
        person.setLastName(sc.nextLine());

        System.out.print("Enter birth date in yyyy-mm-dd: ");
        String dobInput = sc.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dob = LocalDate.parse(dobInput, formatter);

        person.setDob(dob);

        person.DisplayDetails();

        sc.close();
    }
}
