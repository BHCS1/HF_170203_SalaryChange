package model;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class DataSheet extends JDialog implements ActionListener {

  private Employee employee;
  
  public DataSheet(Frame owner, Employee employee) {
    super(owner, employee.getName(), true);
    this.employee = employee;
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setSize(400, 400);
    
    // TODO
    
    add(new JLabel("" + employee.getSalary()));
    JButton bt = new JButton("Save");
    add(bt, BorderLayout.PAGE_END);
    bt.addActionListener(this);
    setLocationRelativeTo(owner);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    
    // TODO
    
    employee.setSalary((int) (employee.getSalary() * 1.05));
    dispose();
  }
  
  
  
}
