package model;

import java.util.ArrayList;

/**
 * Created by ferenc on 2017. 02. 01..
 */
public class Employee extends Model {
    private final int ID;
    private String name;
    private int salary;
    private int departmentId;
    private String departmentName;
    private Department department;

    public static ArrayList<Employee> getAll() {
        connect();
        disconnect();
        return null;
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
