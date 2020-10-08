package model;

import java.awt.Color;
import java.awt.Graphics2D;

public class Square extends Shapes {

    private float Z; 
    
    public Square(float x, float y, Color color, float Z) {
        super(x, y, color); 
        this.Z = Z; 
    }

    public float getZ() {
        return Z;
    }

    @Override
    public float getArea() {
        return Z*Z; 
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(super.getColor());
        g2.drawRect((int)super.getX(), (int)super.getY(), (int)Z, (int)Z);
    }

    @Override
    public String toString() {
        return "[Square: " + super.toString() + " w="+Z+", h=" + Z +"]";
    }

    @Override
    public float setZ(float Z) {
        return this.Z; 
    }
    
}


