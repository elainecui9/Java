// Written by Elaine Cui, cui00122 and Adam Liu, liu02390
import java.lang.Math;
import java.awt.*;
public class Triangle {
    private double xposBottomLeft;
    private double yposBottemLeft;
    private double triHeight;
    private double triWidth;
    private Color triColor;

    public Triangle(double xPos, double yPos, double width, double height) {

        xposBottomLeft = xPos;
        yposBottemLeft = yPos;
        triHeight = height;
        triWidth = width;
        //initialize variables within class with entered parameters
    }
    public double calculatePerimeter() {
        return triWidth + Math.sqrt(triWidth * triWidth + 4.0 * triHeight * triHeight);
        //using the Math class to find the perimeter through the entered height and width
    }
    public double calculateArea() {
        return 0.5 * triHeight * triWidth;
        //area of a triangle is calculated and returned as a double
    }
    public void setColor(Color color) {
        triColor = color;
        //tricolor is set to the color that is entered through the parameter in order to determine the color of the triangle being drawn
    }
    public void setPos(double xPosition, double yPosition) {
        xposBottomLeft = xPosition;
        yposBottemLeft = yPosition;
        //setter to assign value of the x and y position of the bottom left corner of the triangle
    }
    public void setHeight(double height) {
        triHeight = height;
        //setter for the height of the triangle based on what the user enters
    }
    public void setWidth(double width) {
        triWidth = width;
        //setter for the width of the triangle's base with the value the user enters
    }
    public Color getColor() {
        return triColor;
        //getter to send the color of the triangle back to FractalDrawer
    }
    public double getXPos() {
        return xposBottomLeft;
        //getter to send the x coordinate of the bottom left corner back to FractalDrawer
    }
    public double getYPos() {
        return yposBottemLeft;
        //getter to send the y coordinate of the bottom left corner back to FractalDrawer
    }
    public double getHeight() {
        return triHeight;
        //getter to send the height of the triangle back to FractalDrawer
    }
    public double getWidth() {
        return triWidth;
        //getter to send the width of the triangle's base back to FractalDrawer
    }
}
