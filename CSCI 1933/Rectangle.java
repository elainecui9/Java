// Written by Elaine Cui, cui00122 and Adam Liu, liu02390
import java.awt.*;
public class Rectangle {
    private double xposBottomLeft;
    private double yposBottomLeft;
    private double recWidth;
    private double recHeight;
    private Color recColor;

    public Rectangle(double xPos, double yPos, double width, double height) {
        xposBottomLeft = xPos;
        yposBottomLeft = yPos;
        recWidth = width;
        recHeight = height;
        //initialize variables within class with entered parameters
    }
    public double calculatePerimeter() {
        return 2.0 * recWidth + 2.0 * recHeight;
        //calculate the perimeter of the rectangle using the entered height and width
    }
    public double calculateArea() {
        return recWidth * recHeight;
        //calculate the area of the rectangle by multiplying the entered height and width
    }
    public void setColor(Color color) {
        recColor = color;
        //reccolor is set to the color that is entered through the parameter in order to determine the color of the rectangle being drawn
    }
    public void setPos(double xPos, double yPos) {
        xposBottomLeft = xPos;
        yposBottomLeft = yPos;
        //setter to assign value of the x and y position of the bottom left corner of the rectangle
    }
    public void setHeight(double height) {
        recHeight = height;
        //setter for the height of the rectangle based on what the user enters
    }
    public void setWidth(double width) {
        recWidth = width;
        //setter for the width of the rectangle base with the value the user enters
    }
    public Color getColor() {
        return recColor;
        //getter to send the color of the rectangle back to FractalDrawer
    }
    public double getXPos() {
        return xposBottomLeft;
        //getter to send the x coordinate of the bottom left corner back to FractalDrawer
    }
    public double getYPos() {
        return yposBottomLeft;
        //getter to send the y coordinate of the bottom left corner back to FractalDrawer
    }
    public double getHeight() {
        return recHeight;
        //getter to send the height of the rectangle back to FractalDrawer
    }
    public double getWidth() {
        return recWidth;
        //getter to send the width of the rectangle's base back to FractalDrawer
    }
}

