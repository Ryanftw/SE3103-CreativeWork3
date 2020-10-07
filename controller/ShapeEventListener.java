package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import model.*;

import view.ShrinkingShapes;

public class ShapeEventListener implements ActionListener, MouseListener {

    private ShrinkingShapes panel;
    private Random rand; 

    public ShapeEventListener(ShrinkingShapes panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var s = e.getSource();
        if(s == panel.getnewGameButton()){
            //start game
            panel.setState(ShrinkingShapes.GameState.PLAYING);
            rand = new Random();
            switch(rand.nextInt(6)) {
                case 0 : 
                    panel.getCanvas().getShapes().add(new Circle(rand.nextInt(500), rand.nextInt(500), Color.red, rand.nextInt(250)));
                    break;
                case 1 : 
                    panel.getCanvas().getShapes().add(new Rectangle(rand.nextInt(500), rand.nextInt(500), Color.red, rand.nextInt(250), rand.nextInt(250)));
                    break;
                case 2 : 
                    panel.getCanvas().getShapes().add(new Square(rand.nextInt(500), rand.nextInt(500), Color.red, rand.nextInt(250)));
                    break;
                case 3 : 
                    panel.getCanvas().getShapes().add(new Triangle(rand.nextInt(500), rand.nextInt(500), Color.red, rand.nextInt(250)));
                    break;
            } 
            panel.getCanvas().repaint();
            panel.getCanvas().getTimer().start();
        } else if(s == panel.getExitButton()) {
            //close game
        } else if(s == panel.getCanvas().getTimer()) {
            //continue game
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //Check if clicked inside or outside the shape

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
