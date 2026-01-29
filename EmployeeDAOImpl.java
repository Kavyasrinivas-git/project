package project_anp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void addEmployee(EmployeeDTO emp) {
        String sql = "INSERT INTO employee(name, dob, gender, department, salary) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, emp.getName());
            ps.setDate(2, emp.getDob());
            ps.setString(3, emp.getGender());
            ps.setString(4, emp.getDepartment());
            ps.setDouble(5, emp.getSalary());

            ps.executeUpdate();
            System.out.println("✅ Employee added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM employee";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new EmployeeDTO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("dob"),
                        rs.getString("gender"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("🗑️ Employee deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployeeSalary(int id, double salary) {
        String sql = "UPDATE employee SET salary=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, salary);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("💰 Salary updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE id=?";
        EmployeeDTO emp = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                emp = new EmployeeDTO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("dob"),
                        rs.getString("gender"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return emp;
    }
}
