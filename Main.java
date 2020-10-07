import javax.swing.JFrame;

import view.ShrinkingShapes;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(400, 100);
        window.setTitle("Shapes");
        
        var Startscreen = new ShrinkingShapes(window);
        Startscreen.init();
        window.pack();
        window.setVisible(true);
    }
}