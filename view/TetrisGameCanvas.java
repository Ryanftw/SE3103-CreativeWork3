package view;

import javax.swing.JPanel;

public class TetrisGameCanvas extends JPanel {
    
    private TetrisGamePanel panel; 

    public TetrisGameCanvas(TetrisGamePanel panel) {
        this.panel = panel;
    }
}
