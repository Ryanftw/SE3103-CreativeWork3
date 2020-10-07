package view;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.ShapeEventListener;

public class ShrinkingShapes {

    public enum GameState {
		READY, PLAYING, GAMEOVER
	}

    private GameState state = GameState.READY;
    private JButton newGameButton;
    private JButton exitButton; 
    private JFrame window; 
    private ShrinkingGameCanvas canvas; 
    ShapeEventListener listener;

    public ShrinkingShapes(JFrame window) {
        this.window = window;
    }

    //DRAW OVAL
    //DRAW POLYGON

    public void init() {
        Container cp = window.getContentPane();
        JPanel southPanel = new JPanel();
        cp.add(BorderLayout.SOUTH, southPanel); 

        JPanel buttonPanel1 = new JPanel(); 
        newGameButton = new JButton("New Game"); 
        exitButton = new JButton("Exit"); 
        buttonPanel1.add(newGameButton);
        buttonPanel1.add(exitButton); 
        southPanel.add(buttonPanel1);
        
        canvas = new ShrinkingGameCanvas(this); 
        cp.add(BorderLayout.CENTER, canvas); 
        
        listener = new ShapeEventListener(this);
        newGameButton.addActionListener(listener);
        exitButton.addActionListener(listener);
        canvas.addMouseListener(listener);
        
    }

    public JButton getnewGameButton() {
        return newGameButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }
    
    public ShrinkingGameCanvas getCanvas() {
        return canvas;
    }

    public JFrame getWindow() {
        return window;
    }
    
    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public ShapeEventListener getListener(){ 
        return listener;
    }
}
