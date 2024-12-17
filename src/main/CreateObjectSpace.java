package main;

import java.awt.Container;
import javax.swing.JComponent;

public class CreateObjectSpace {

    
    final private double finalWidth;
    final private double finalHeight;
    final private double startingPositionX;
    final private double startingPositionY;
    final private int containerWidth;
    final private int containerHeight;

    public CreateObjectSpace(Container con, double widthFactor,double heightFactor, double startingPositionXFactor, double startingPositionYFactor) {

        containerWidth = con.getWidth();
        containerHeight = con.getHeight();

        this.finalWidth = containerWidth * widthFactor;
        this.finalHeight = containerHeight * heightFactor;
        this.startingPositionX = containerWidth * startingPositionXFactor;
        this.startingPositionY = containerHeight * startingPositionYFactor;




    }

    // Set bounds on a JComponent
    public void applyBounds(JComponent component) {
        component.setBounds(
            (int) Math.round(this.startingPositionX),
            (int) Math.round(this.startingPositionY),
            (int) Math.round(this.finalWidth),
            (int) Math.round(this.finalHeight)
            
            
            
            
        );
    }

    // Getters for individual dimensions and positions (if needed elsewhere)
    public double getFinalWidth() {
        return finalWidth;
    }

    public double getFinalHeight() {
        return finalHeight;
    }

    public double getStartingPositionX() {
        return startingPositionX;
    }

    public double getStartingPositionY() {
        return startingPositionY;
    }



   
    
}
