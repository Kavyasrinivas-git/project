package project_anp;

import java.util.List;

public interface EmployeeDAO {

    void addEmployee(EmployeeDTO emp);
    List<EmployeeDTO> getAllEmployees();
    void deleteEmployee(int id);
    void updateEmployeeSalary(int id, double salary);
    EmployeeDTO getEmployeeById(int id);
}
