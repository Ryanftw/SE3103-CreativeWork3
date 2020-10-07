package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Square extends Shapes {

    private float side; 
    
    public Square(float x, float y, Color color, float side) {
        super(x, y, color); 
        this.side = side; 
    }

    public float getSide() {
        return side;
    }

    public void setSide(float side) {
        this.side = side;
    }

    @Override
    public float getArea() {
        return side*side; 
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(super.getColor());
        g2.drawRect((int)super.getX(), (int)super.getY(), (int)side, (int)side);
    }

    @Override
    public String toString() {
        return "[Square: " + super.toString() + " w="+side+", h=" + side +"]";
    }
    
}


