package model;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ferenc on 2017. 02. 01..
 */
public class View extends JFrame {
    private JTable tEmployees=new JTable();

    public View() {
        super("Title");
        setSize(600, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        listeners();
    }

    public void showDialog(Employee employee) {
        ;
    }

    public void listeners() {
        ;
    }

    public void setEmployees(EmployeeTableModel employeeTableModel) {
        ;
    }


}
