package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TetrisGamePanel;

public class ShapeEventListener implements ActionListener {

    private TetrisGamePanel panel; 

    public ShapeEventListener(TetrisGamePanel panel) {
        this.panel = panel; 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }
    
}
