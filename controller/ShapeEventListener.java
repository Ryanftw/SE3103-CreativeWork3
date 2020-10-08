package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import model.*;
import java.util.ArrayList;

import view.ShrinkingShapes;

public class ShapeEventListener implements ActionListener, MouseListener {

    
    private ShrinkingShapes panel;
    private Random rand; 
    private Shapes shape; 
    private int clicks = 0;
    private int missedClicks = 0; 
    private int speed; 
    private int difficulty = 1; 
    private int pts = 0; 

    public ShapeEventListener(ShrinkingShapes panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var s = e.getSource();
        if(s == panel.getnewGameButton()) {
            clicks = 0; missedClicks = 0; pts = 0; difficulty = 1; speed = 250;
            panel.setPoints(Integer.toString(pts)); 
            panel.setMissed(Integer.toString(missedClicks)); 
            panel.getCanvas().getShapes().clear();
            panel.setState(ShrinkingShapes.GameState.PLAYING);
            rand = new Random();
            switch(rand.nextInt(2)) {
                case 0 : 
                panel.getCanvas().getShapes().add(new Circle(rand.nextInt((565-15) +1) + 70, rand.nextInt((565-15) +1) + 70, Color.red, rand.nextInt((175-50) +1)/difficulty + 50));
                break;
                case 1 : 
                panel.getCanvas().getShapes().add(new Square(rand.nextInt((565-15) +1) + 70, rand.nextInt((565-15) +1) + 70, Color.red, rand.nextInt((175-50) +1)/difficulty + 50));
                break;
            }
            panel.getCanvas().startGameTimer();
            panel.getCanvas().getTimer().setDelay(speed);
        } else if(s == panel.getExitButton()) {
            panel.getWindow().dispose();
        } else if(s == panel.getCanvas().getTimer()) {
            shape = panel.getCanvas().getShapes().get(0);
            panel.getCanvas().getShapes().clear();
            if (shape.getZ() == 0) {
                panel.getCanvas().stopGameTimer();
                panel.getCanvas().setEnabled(false);
                panel.setState(ShrinkingShapes.GameState.GAMEOVER);
            }else {
                if(shape instanceof Circle) {
                    for(int i = panel.getCanvas().getComponentCount(); i < difficulty; i++)
                    panel.getCanvas().getShapes().add(new Circle(shape.getX()+1, shape.getY()+1, Color.red, shape.getZ()-1));
                } else if(shape instanceof Square) {
                    for(int i = panel.getCanvas().getComponentCount(); i < difficulty; i++)
                    panel.getCanvas().getShapes().add(new Square(shape.getX()+0.5f, shape.getY()+0.5f, Color.red, shape.getZ()-1));
                }
            panel.getCanvas().repaint();    
            }
        }
    }

    public void setShapes() {
        shape = panel.getCanvas().getShapes().get(0);
        panel.getCanvas().getShapes().clear();
        panel.getCanvas().stopGameTimer();
        panel.getCanvas().removeAll();
        for(int i = panel.getCanvas().getComponentCount(); i < difficulty; i++) {
            switch(rand.nextInt(2)) {
                case 0 : 
                    panel.getCanvas().getShapes().add(new Circle(rand.nextInt((565-15) +1) + 70, rand.nextInt((565-15) +1) + 70, Color.red, rand.nextInt((175-50) +1)/difficulty + 50));
                    break;
                case 1 : 
                    panel.getCanvas().getShapes().add(new Square(rand.nextInt((565-15) +1) + 70, rand.nextInt((565-15) +1) + 70, Color.red, rand.nextInt((175-50) +1)/difficulty + 50));
                    break;
                // case 3 : 
                //     Triangle triangle = new Triangle(rand.nextInt(500), rand.nextInt(500), Color.red);
                //     for(int i = 0; i < 3; i++) 
                //     triangle.setPos(i, rand.nextInt(250), rand.nextInt(250));
                //     panel.getCanvas().getShapes().add(triangle);//(rand.nextInt(500), rand.nextInt(500), Color.red, rand.nextInt(250)));
                //     break;
            }
        }
        pts++;
        if(pts%10 == 0) difficulty++;
        speed /= 2;
        panel.setPoints(Integer.toString(pts));
        panel.getCanvas().getTimer().setDelay(speed);
        panel.getCanvas().repaint();
        panel.getCanvas().restartTimer();
    }
       

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(panel.getState() == ShrinkingShapes.GameState.GAMEOVER) {
            return;
        }
        if(shape instanceof Circle) {
            if(e.getX() >= shape.getX() && e.getX() <=(shape.getX() + shape.getZ()*2) && e.getY() >= shape.getY() && e.getY() <= (shape.getY() + shape.getZ()*2)) {
                setShapes();
            }else {
                missedClicks++; 
                panel.setMissed(Integer.toString(missedClicks)); 
            }
        } else if(shape instanceof Square) {
            if(e.getX() >= shape.getX() && e.getX() <=(shape.getX() + shape.getZ()) && e.getY() >= shape.getY() && e.getY() <= (shape.getY() + shape.getZ())) {
                setShapes();
            } else {
                missedClicks++;
                panel.setMissed(Integer.toString(missedClicks)); 
            }
        } 
        if (missedClicks >= 3) {
            panel.getCanvas().stopGameTimer();
            panel.setState(ShrinkingShapes.GameState.GAMEOVER);
            panel.getCanvas().setEnabled(false);
            panel.getCanvas().repaint();
        }
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
