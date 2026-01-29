package project_anp;

import java.sql.Date;
import java.util.List;

public class EmployeeService {

    EmployeeDAO dao = new EmployeeDAOImpl();

    public void addEmployee(String name, String dob, String gender, String dept, double salary) {
        Date date = Date.valueOf(dob); // format: yyyy-mm-dd
        dao.addEmployee(new EmployeeDTO(name, date, gender, dept, salary));
    }

    public void viewEmployees() {
        List<EmployeeDTO> list = dao.getAllEmployees();
        for (EmployeeDTO e : list) {
            System.out.println(e.getId() + " | " + e.getName() + " | " + e.getDob() + " | " +
                    e.getGender() + " | " + e.getDepartment() + " | ₹" + e.getSalary());
        }
    }

    public void deleteEmployee(int id) {
        dao.deleteEmployee(id);
    }

    public void updateSalary(int id, double salary) {
        dao.updateEmployeeSalary(id, salary);
    }

    public void searchEmployee(int id) {
        EmployeeDTO e = dao.getEmployeeById(id);
        if (e != null) {
            System.out.println(e.getId() + " | " + e.getName() + " | " + e.getDob() + " | " +
                    e.getGender() + " | " + e.getDepartment() + " | ₹" + e.getSalary());
        } else {
            System.out.println("❌ Employee not found!");
        }
    }
}
