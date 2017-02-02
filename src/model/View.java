package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableCellRenderer;

public class View extends JFrame implements ActionListener {

  private JTable tEmployees = new JTable();
  private JScrollPane spTable = new JScrollPane(tEmployees);
  private JLabel lMessage = new JLabel(" ", SwingConstants.RIGHT);
  Timer timerMessage = new Timer(3000, this);
  DefaultTableCellRenderer buttonAndCenterRenderer = new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
      if (column == 3) {
        return (TableButton) value;
      }
      return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }

  };

  public View() {
    super("Data of the employees");
    setSize(800, 600);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    lMessage.setFont(new Font("Ariel", Font.BOLD, 16));
    lMessage.setForeground(Color.GREEN);
    lMessage.setHorizontalTextPosition(SwingConstants.RIGHT);
    add(lMessage, BorderLayout.PAGE_START);
    add(spTable);
    buttonAndCenterRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
    tEmployees.addMouseListener(new JTableButtonMouseListener(tEmployees));
    setResizable(false);
    setLocationRelativeTo(this);
  }

  public void showDialog(Employee employee, int index) {
    int actualSalary = employee.getSalary();
    DataSheet ds = new DataSheet(this, employee);
    ds.setVisible(true);
    if (actualSalary != employee.getSalary()) {
      tEmployees.setValueAt(employee.getSalary(), index, 2);
      tEmployees.setRowSelectionInterval(index, index);
      tEmployees.setColumnSelectionInterval(2, 2);
      lMessage.setText("Salary updated successfully!");
      timerMessage.start();
    }
  }

  public void setEmployees(EmployeeTableModel employeeTableModel) {
    tEmployees.setModel(employeeTableModel);
    for (int i = 0; i < tEmployees.getColumnCount(); i++) {
      tEmployees.getColumnModel().getColumn(i).setCellRenderer(buttonAndCenterRenderer);
    }
    tEmployees.getColumnModel().getColumn(3).setPreferredWidth(10);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    lMessage.setText(" ");
    timerMessage.stop();
  }

  private static class JTableButtonMouseListener extends MouseAdapter {

    private final JTable table;

    public JTableButtonMouseListener(JTable table) {
      this.table = table;
    }

    public void mouseClicked(MouseEvent e) {
      int column = table.getColumnModel().getColumnIndexAtX(e.getX()); // get the coloum of the button
      int row = e.getY() / table.getRowHeight(); //get the row of the button

      /*Checking the row or column is valid or not*/
      if (row < table.getRowCount() && row >= 0 && column == 3) {
        Object value = table.getValueAt(row, column);
        if (value instanceof TableButton) {
          /*perform a click event*/
          ((TableButton) value).doClick();
        }
      }
    }
  }

}
