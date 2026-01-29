package project_anp;

import java.sql.Date;

public class EmployeeDTO {
	private int id;
    private String name;
    private Date dob;
    private String gender;
    private String department;
    private double salary;

    public EmployeeDTO() {}

    public EmployeeDTO(String name, Date dob, String gender, String department, double salary) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
    }

    public EmployeeDTO(int id, String name, Date dob, String gender, String department, double salary) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

}
