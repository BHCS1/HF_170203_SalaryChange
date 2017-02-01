package model;

import javax.swing.*;

/**
 * Created by ferenc on 2017. 02. 01..
 */
public class TableButton extends JButton {
    private int index;

    public TableButton(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
