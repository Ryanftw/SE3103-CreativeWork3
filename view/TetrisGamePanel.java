package view;

import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.ShapeEventListener;

public class TetrisGamePanel {

    JButton randomShapeButton;
    JButton exitButton; 
    private JFrame window; 
    private TetrisGameCanvas canvas; 

    public TetrisGamePanel(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container cp = window.getContentPane();
        JPanel southPanel = new JPanel();
        cp.add(BorderLayout.SOUTH, southPanel); 

        randomShapeButton = new JButton("Random Shapes"); 
        exitButton = new JButton("Exit"); 
        southPanel.add(randomShapeButton);
        southPanel.add(exitButton); 
        
        canvas = new TetrisGameCanvas(this); 
        cp.add(BorderLayout.CENTER, canvas); 

        ShapeEventListener listener = new ShapeEventListener(this);
        randomShapeButton.addActionListener(listener);
        exitButton.addActionListener(listener);
    }

    public JButton getRandomShapeButton() {
        return randomShapeButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
    
    public TetrisGameCanvas getCanvas() {
        return canvas;
    }

    public JFrame getWindow() {
        return window;
    }
    
}
