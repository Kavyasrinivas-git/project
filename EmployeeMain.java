package project_anp;

import java.util.Scanner;

public class EmployeeMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();
        int choice;

        do {
            System.out.println("\n--- EMPLOYEE MENU ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Delete Employee");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Search Employee by ID");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("DOB (yyyy-mm-dd): ");
                    String dob = sc.nextLine();
                    System.out.print("Gender: ");
                    String gender = sc.nextLine();
                    System.out.print("Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();
                    service.addEmployee(name, dob, gender, dept, salary);
                    break;

                case 2:
                    service.viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    service.deleteEmployee(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("New Salary: ");
                    double newSal = sc.nextDouble();
                    service.updateSalary(id, newSal);
                    break;

                case 5:
                    System.out.print("Enter ID to search: ");
                    service.searchEmployee(sc.nextInt());
                    break;

                case 6:
                    System.out.println("👋 Exiting...");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
