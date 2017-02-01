package model;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by ferenc on 2017. 02. 01..
 */
public class EmployeeTableModel implements TableModel {
    private ArrayList<Employee> data=null;
    private ArrayList<JButton> buttons=new ArrayList<JButton>();

    public EmployeeTableModel(ArrayList<Employee> data, ActionListener al) {
        this.data = data;
        // TODO Jbutton arraylistet hozzaasni+actionlistener

        for(int i = 0; i < this.data.size(); i++) {
            JButton button = new JButton("..");
            button.setActionCommand(String.valueOf(i));
            final EmployeeTableModel t = this;
            final int ii = i;
            button.addActionListener(al);
            buttons.add(button);
        }
    }

    public Employee getRow(int rowIndex) {
        return data.get(rowIndex);
    }

    private String[] columnNames={
            "Department Name", "Employee name", "Salary", "Update salary"
    };

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // TODO: vissza kell adni az oszlopoknak megfelelo classt
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return data.get(rowIndex).getDepartmentName();
            case 1:
                return data.get(rowIndex).getName();
            case 2:
                return data.get(rowIndex).getSalary();
            case 3:
                return buttons.get(rowIndex);
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (columnIndex != 2)
            return;
        if (aValue instanceof Integer)
            data.get(rowIndex).setSalary((Integer) aValue);
    }
    @Override
    public void addTableModelListener(TableModelListener l) {
        ;
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        ;
    }
}
