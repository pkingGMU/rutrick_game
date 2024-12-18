package main;

import java.awt.Container;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class CreateObjectSpace {

    
    private double finalWidth;
    private double finalHeight;
    private double startingPositionX;
    private double startingPositionY;
    private int parentWidth;
    private int parentHeight;

    // Overload for differnt object (container)
    public CreateObjectSpace(Container con, double widthFactor,double heightFactor, double startingPositionXFactor, double startingPositionYFactor) {

        parentWidth = con.getWidth();
        parentHeight = con.getHeight();

        calculateDimensions(widthFactor, heightFactor, startingPositionXFactor, startingPositionYFactor);
    }

    // Overload for differnt object (panel)
    public CreateObjectSpace(JPanel panel, double widthFactor,double heightFactor, double startingPositionXFactor, double startingPositionYFactor) {

        parentWidth = panel.getWidth();
        parentHeight = panel.getHeight();

        calculateDimensions(widthFactor, heightFactor, startingPositionXFactor, startingPositionYFactor);
    }

    private void calculateDimensions(double widthFactor,double heightFactor, double startingPositionXFactor, double startingPositionYFactor) {
        this.finalWidth = parentWidth * widthFactor;
        this.finalHeight = parentHeight * heightFactor;
        this.startingPositionX = parentWidth * startingPositionXFactor;
        this.startingPositionY = parentHeight * startingPositionYFactor;
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
