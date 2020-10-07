package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Font;
import model.Shapes;
import javax.swing.Timer;

public class ShrinkingGameCanvas extends JPanel {
    
    private Timer timer; 
    private ShrinkingShapes panel; 
    private Graphics2D g2;
    private ArrayList<Shapes> shapes = new ArrayList<>();

    public ShrinkingGameCanvas(ShrinkingShapes panel) {
        this.panel = panel;
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.black);
        timer = new Timer(5, panel.getListener());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g2 = (Graphics2D) g; 
        
        if(panel.getState() == ShrinkingShapes.GameState.READY) {
            g2.setColor(Color.red); 
            g2.setFont(new Font("Arial", Font.BOLD, 36));
            g2.drawString("Select New Game to start", 35, 250);
        } else {
            if(panel.getState() == ShrinkingShapes.GameState.GAMEOVER) {
                g2.setColor(Color.red); 
                g2.setFont(new Font("Arial", Font.BOLD, 36));
                g2.drawString("GAME OVER", 150, 350);
            }
            for(var s : shapes) {
                s.render(g2);
            }


        }
    }
    
    public ArrayList<Shapes> getShapes() {
        return shapes;
    }

    public Timer getTimer() {
        return timer;
    }


}
