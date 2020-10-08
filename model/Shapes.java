package model;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Shapes {
    
    private float x; 
    private float y; 
    private Color color; 

    public Shapes(float x, float y, Color color) {
        this.x = x;
        this.y = y; 
        this.color = color; 
    }

    public float getX() {
        return x; 
    }

    public float getY() {
        return y; 
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Color getColor() {
        return color; 
    }

    @Override
    public String toString() {
        return "[Shape: (" + x + ", " + y + ", area = " + getArea() + ")]";
    }
    

    public abstract float getZ();
    public abstract float setZ(float z);
    public abstract float getArea();
    public abstract void render(Graphics2D g2); 

}
