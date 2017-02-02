package model;

import java.sql.SQLException;
import java.util.ArrayList;

public class Employee extends Model {
    private final int ID;
    private String name;
    private int salary;
    private int departmentId;
    private String departmentName;
    private Department department;

    public static ArrayList<Employee> getAll() throws ClassNotFoundException, SQLException {
        connect();
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Aladár Aladár", 10000, 100, "Valami"));
        list.add(new Employee(2, "Béla Aladár", 12000, 101, "Valami más"));
        disconnect();
        return list;
    }

    public Employee(int id, String name, int salary,
            int departmentId, String departmentName) {
        this.ID=id;
        this.name=name;
        this.salary=salary;
        this.departmentId=departmentId;
        this.departmentName=departmentName;
    }

    public boolean update() {
        return false;
    }

    public void setSalary(int salary) {
        this.salary=salary;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Department getDepartment() {
        return department;
    }
}
