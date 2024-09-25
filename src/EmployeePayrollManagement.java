import java.util.Scanner;

class Employee {
    int id;
    String name;
    float basicSalary;
    float bonus;
    float netSalary;

    public Employee(int id, String name, float basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
        this.bonus = 0.0f;
        this.netSalary = 0.0f;
    }

    public void calculateBonus() {

    }
    public void calculateNetSalary() {

    }
}
class PermanentEmployee extends Employee {
    int pf;

    public PermanentEmployee(int id, String name, float basicSalary, int pf) {
        super(id, name, basicSalary);
        this.pf = pf;
    }

    public void calculateBonus() {
        if(pf<1000){
            bonus = 0.10f * basicSalary;
        } else if(pf>=1000 && pf<1500) {
            bonus = 0.115f * basicSalary;
        } else if(pf>=1500 && pf<1800){
            bonus = 0.12f * basicSalary;
        } else {
            bonus = 0.15f * basicSalary;
        }
    }

    public void calculateNetSalary() {
        calculateBonus();
        netSalary = basicSalary-pf+bonus;
    }
}

class TemporaryEmployee extends Employee {
    int dailyWages;
    int noOfDays;

    public TemporaryEmployee(int id, String name, int dailyWages, int noOfDays) {
        super(id, name, 0);
        this.dailyWages = dailyWages;
        this.noOfDays=noOfDays;
    }

    public void calculateBonus() {
        float totalSalary = dailyWages * noOfDays;
        if(dailyWages<1000){
            bonus = 0.15f * totalSalary;
        } else if(dailyWages >= 1000 && dailyWages<1500) {
            bonus = 0.12f * totalSalary;
        } else if(dailyWages >= 1500 && dailyWages<1750) {
            bonus = 0.11f * totalSalary;
        } else{
            bonus = 0.08f * totalSalary;
        }
    }

    public void calculateNetSalary() {
        calculateBonus();
        netSalary = (dailyWages * noOfDays) + bonus;
    }
}

public class EmployeePayrollManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Employee type(Permanent/Temporary): ");
        String employeeType = scanner.nextLine();

        if(employeeType.equalsIgnoreCase("Permanent")){
            System.out.println("Enter the Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the Employee Name: ");
            String name = scanner.nextLine();
            System.out.println("Enter Basic Salary: ");
            float basicSalary = scanner.nextFloat();
            System.out.println("Enter PF: ");
            int pf = scanner.nextInt();

            PermanentEmployee emp = new PermanentEmployee(id, name, basicSalary, pf);
            emp.calculateNetSalary();
            System.out.printf("Permanent Employee %s (ID: %d)\n", emp.name, emp.id);
            System.out.printf("Net Salary: %.2f\n", emp.netSalary);
            System.out.printf("Bonus: %.2f\n", emp.bonus);
        }
        else if(
                employeeType.equalsIgnoreCase("Temporary")
        ){
            System.out.println("Enter the Employee ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter Employee Name: ");
            String name = scanner.nextLine();
            System.out.println("Enter Daily Wages: ");
            int dailyWages = scanner.nextInt();
            System.out.println("Enter No. of Days: ");
            int noOfDays = scanner.nextInt();

            TemporaryEmployee emp = new TemporaryEmployee(id, name, dailyWages, noOfDays);
            emp.calculateNetSalary();
            System.out.printf("Temporary Employee %s (ID: %d)\n", emp.name, emp.id);
            System.out.printf("Net Salary: %.2f\n", emp.netSalary);
            System.out.printf("Bonus: %.2f\n", emp.bonus);
//

        } else {
            System.out.println("Invalid Employee Type ");
        }
        scanner.close();
    }
}