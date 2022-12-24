// Written by Elaine Cui, cui00122 and Adam Liu, liu02390
import java.awt.*;
public class Circle {
    private double xposCenter;
    private double yposCenter;
    private double circRadius;
    private Color circColor;

    public Circle(double xPos, double yPos, double radius) {
        xposCenter = xPos;
        yposCenter = yPos;
        circRadius = radius;
        //initialize variables within class with entered parameters
    }
    public double calculatePerimeter() {
        return 2 * circRadius * 3.14;
        //using the Math class to find the perimeter through the entered radius
    }
    public double calculateArea() {
        return circRadius * circRadius * 3.14;
        //area of a circle is calculated and returned as a double
    }
    public void setColor(Color color) {
        circColor = color;
        //circColor is set to the color that is entered through the parameter in order to determine the color of the circle being drawn
    }
    public void setPos(double xPosition, double yPosition) {
        xposCenter = xPosition;
        yposCenter = yPosition;
        //setter to assign value of the x and y position of center of the circle
    }
    public void setRadius(double radius) {
        circRadius = radius;
        //setter for the radius of the circle based on what the user enters
    }
    public Color getColor() {
        return circColor;
        //getter to send the color of the circle back to FractalDrawer
    }
    public double getXPos() {
        return xposCenter;
        //getter to send the x coordinate of the center of the circle back to FractalDrawer
    }
    public double getYPos() {
        return yposCenter;
        //getter to send the y coordinate of the center of the circle back to FractalDrawer
    }
    public double getRadius() {
        return circRadius;
        //getter to send the radius of the circle back to FractalDrawer
    }
}

