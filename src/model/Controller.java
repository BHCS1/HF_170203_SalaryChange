package model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ferenc on 2017. 02. 01..
 */
public class Controller implements ActionListener {
    private View view;
    private EmployeeTableModel etm = null;

    public Controller() {
        this.view=new View();
        //TODO: pédldányosítani az employee tablemodelt,
        // annak megadni az employees.getall visszateresi erteket
        // view setemployes-at meg kell hivni ezzel a tablemodellel

        etm = new EmployeeTableModel(Employee.getAll(), this);
    }

    public static void main(String[] args) {
        new Controller();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Employee employee = etm.getRow(Integer.parseInt(((JButton) e.getSource()).getActionCommand()));
        view.showDialog(employee);
    }
}
