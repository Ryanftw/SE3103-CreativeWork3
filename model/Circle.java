package model;

import java.awt.Graphics2D;
import java.awt.Color;

public class Circle extends Shapes {

    private float Z; 

    public Circle(float x, float y, Color color, float Z) {
        super(x, y, color); 
        this.Z = Z; 
    }

    public float getZ() {
        return Z;
    }

    @Override
    public float setZ(float Z) {
        return this.Z;
    }

    @Override
    public float getArea() {
        return (float) (Z * Z * Math.PI); 
    }

    @Override
    public void render(Graphics2D g2) {
        g2.setColor(super.getColor());
        g2.drawOval((int)super.getX(), (int)super.getY(), (int)(Z*2), (int)(Z*2));

    }

    @Override
    public String toString() {
        return "[Circle:" + super.toString() + " r="+Z+"]";
    }

    
    
}
