package model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller implements ActionListener {
    private View view;
    private EmployeeTableModel etm = null;

    public Controller() {
        this.view=new View();
        ArrayList<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Aladár Aladár", 10000, 100, "Valami"));
        list.add(new Employee(2, "Béla Aladár", 12000, 101, "Valami más"));
        etm = new EmployeeTableModel(list, this);
//        try {
//          etm = new EmployeeTableModel(Employee.getAll(), this);
          view.setEmployees(etm);
          view.setVisible(true);
//        } catch (ClassNotFoundException e) {
//          JOptionPane.showMessageDialog(null, "Error! Most probably misssing ojdbc driver!", "Error", JOptionPane.ERROR_MESSAGE);
//          System.exit(0);
//        } catch (SQLException e) {
//          JOptionPane.showMessageDialog(null, "Error! SQL query problem!", "Error", JOptionPane.ERROR_MESSAGE);
//          System.exit(0);
//        }
    }

    public static void main(String[] args) {
        new Controller();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      int index = ((TableButton) e.getSource()).getIndex();
        Employee employee = etm.getRowEmp(index);
        view.showDialog(employee, index);
    }
}
