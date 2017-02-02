package model;

import javax.swing.JButton;

public class TableButton extends JButton {

  private int buttonIndex;

  public TableButton(int index) {
    super("...");
    this.buttonIndex = index;
  }

  public int getIndex() {
    return buttonIndex;
  }

  public void setIndex(int index) {
    this.buttonIndex = index;
  }
  
}
