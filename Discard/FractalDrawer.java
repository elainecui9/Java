// Written by Elaine Cui, cui00122 and Adam Liu, liu02390
import java.awt.*;
import java.util.Scanner;
public class FractalDrawer {
    private double totalArea;
    //initiate the variable for the total area of the fractal
    public FractalDrawer() {
        totalArea = 0;
        //constructor to set the totalArea to 0
    }

    public double drawFractal(String type) {
        Canvas canvas = new Canvas();
        //creates a new Canvas object
        Scanner myScanner = new Scanner(System.in);
        //creates a new scanner
        if (type.equals("Triangle")){
            System.out.println("Please enter your triangle's width: ");
            Double tempWidth = myScanner.nextDouble();
            System.out.println("Please enter your triangle's height: ");
            Double tempHeight = myScanner.nextDouble();
            System.out.println("How many levels would you like: ");
            int tempLevel = myScanner.nextInt();
            drawTriangleFractal(tempWidth,tempHeight, 400,400, Color.RED, canvas, tempLevel);
            //if user enters "Triangle," prompt the user to enter the triangle's width, height, and how many levels they would like
            //draw the triangle fractal with dimensions according to user input
        }
        if (type.equals("Circle")){
            System.out.println("Please enter your circle's radius: ");
            Double tempRadius = myScanner.nextDouble();
            System.out.println("How many levels would you like: ");
            int tempLevel = myScanner.nextInt();
            drawCircleFractal(tempRadius, 400, 400, Color.RED, canvas, tempLevel);
            //if user enters "Circle," prompt the user to enter the circle's radius and how many levels they would like
        }
        if (type.equals("Rectangle")){
            System.out.println("Please enter your rectangle's width: ");
            Double tempWidth = myScanner.nextDouble();
            System.out.println("Please enter your rectangle's height: ");
            Double tempHeight = myScanner.nextDouble();
            System.out.println("How many levels would you like: ");
            int tempLevel = myScanner.nextInt();
            drawRectangleFractal(tempWidth,tempHeight, 400,400, Color.RED, canvas, tempLevel);
            //if user enters "Rectangle," prompt the user to enter the rectangle's width, height, and how many levels they would like
        }
        return totalArea;
        //return the value of the fractal's area that is being drawn
    }
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
        Triangle myTriangle = new Triangle (x,y, width, height);
        //creates a new triangle object at point (x, y) with width and height
        totalArea = totalArea + myTriangle.calculateArea();
        //increment the total area of the fractal by the total area of the new triangles drawn
        myTriangle.setColor(c);
        can.drawShape(myTriangle);
        Color currentColor = Color.BLACK;
        //sets currentColor to black in order to initialize the variable
        for (int colorChanger = 0; colorChanger < level; colorChanger++){
            if (colorChanger % 5 == 0){
                currentColor = Color.CYAN;
            }
            if (colorChanger % 5 == 1){
                currentColor = Color.BLUE;
            }
            if (colorChanger % 5 == 2){
                currentColor = Color.MAGENTA;
            }
            if (colorChanger % 5 == 3){
                currentColor = Color.YELLOW;
            }
            if (colorChanger % 5 == 4) {
                currentColor = Color.GREEN;
            }
        //cycles through the color of the shape being drawn depending on what level the shape is being drawn on
        }
        if (level == 1){
            can.drawShape(myTriangle);
        //draw a single triangle at level 1
        } else {
            drawTriangleFractal(width/2 , height/2, myTriangle.getXPos() - width/2, myTriangle.getYPos(), currentColor, can, level-1);
            drawTriangleFractal(width/2 , height/2, myTriangle.getXPos() + width, myTriangle.getYPos(), currentColor, can, level-1);
            drawTriangleFractal(width/2 , height/2, myTriangle.getXPos() + width/4, myTriangle.getYPos() - height, currentColor, can, level-1);
        //decrease the dimensions of the triangle, change the x and y position of each triangle, and change the color of the triangle for each level using recursion
        //draws a fractal pattern so that the next triangles aligns with the corners of the previous triangle
        }
    }
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level){
        Circle myCircle = new Circle(x, y, radius);
        //creates a new circle object at point (x, y) with a radius determined by user input
        myCircle.setColor(c);
        totalArea = totalArea + myCircle.calculateArea();
        //increment the total area of the fractal by the total area of every new circles drawn
        can.drawShape(myCircle);
        Color currentColor = Color.BLACK;
        for (int colorChanger = 0; colorChanger < level; colorChanger++){
            if (colorChanger % 5 == 0){
                currentColor = Color.CYAN;
            }
            if (colorChanger % 5 == 1){
                currentColor = Color.BLUE;
            }
            if (colorChanger % 5 == 2){
                currentColor = Color.MAGENTA;
            }
            if (colorChanger % 5 == 3){
                currentColor = Color.YELLOW;
            }
            if (colorChanger % 5 == 4) {
                currentColor = Color.GREEN;
            }
        }
        //cycles through the colors so that circles of the same level have the same color
        if (level == 1){
            can.drawShape(myCircle);
        //draw a single circle at level 1, base case
        } else {
            drawCircleFractal(radius/2 , myCircle.getXPos() - radius * 1.5, myCircle.getYPos(), currentColor, can, level-1);
            drawCircleFractal(radius/2 , myCircle.getXPos(), myCircle.getYPos() + radius * 1.5, currentColor, can, level-1);
            drawCircleFractal(radius/2 , myCircle.getXPos() + radius * 1.5, myCircle.getYPos(), currentColor, can, level-1);
            drawCircleFractal(radius/2, myCircle.getXPos(), myCircle.getYPos() - radius * 1.5, currentColor, can,level-1);
        }
        //recusion to call the method again in order to draw the circles with half the radius
        //this creates the fractal pattern with the new colors
    }
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
        Rectangle myRectangle = new Rectangle (x, y, width, height);
        //creates a new circle object at point (x, y) with a width and height determined by user input
        totalArea = totalArea + myRectangle.calculateArea();
        //adding together the area of the rectangle and the previous rectangles that were calculated through the set height and width
        myRectangle.setColor(c);
        can.drawShape(myRectangle);
        //method called from Canvas in order to draw the current Rectangle
        Color currentColor = Color.BLACK;
        for (int colorChanger = 0; colorChanger < level; colorChanger++){
            if (colorChanger % 5 == 0){
                currentColor = Color.CYAN;
            }
            if (colorChanger % 5 == 1){
                currentColor = Color.BLUE;
            }
            if (colorChanger % 5 == 2){
                currentColor = Color.MAGENTA;
            }
            if (colorChanger % 5 == 3){
                currentColor = Color.YELLOW;
            }
            if (colorChanger % 5 == 4) {
                currentColor = Color.GREEN;
            }
        }
        //cycles through the colors so that circles of the same level have the same color
        if (level == 1){
            can.drawShape(myRectangle);
            //base case for the recursion, so the single rectangle will just be drawn at level 1
        } else {
            drawRectangleFractal(width/2 , height/2, myRectangle.getXPos() - width * 0.25, myRectangle.getYPos() - height * 0.25, currentColor, can, level-1);
            drawRectangleFractal(width/2 , height/2, myRectangle.getXPos() - width * 0.25, myRectangle.getYPos() + height * 0.75, currentColor, can, level-1);
            drawRectangleFractal(width/2 , height/2, myRectangle.getXPos() + width * 0.75, myRectangle.getYPos() + height * 0.75, currentColor, can, level-1);
            drawRectangleFractal(width/2 , height/2, myRectangle.getXPos() + width * 0.75, myRectangle.getYPos() - height * 0.25, currentColor, can, level-1);
        }
        //calling of own method while halving the width and height of the rectangle in order to the fractal pattern while updating the color, position  , and level;
    }
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please choose your fractal shape: Triangle, Circle, or Rectangle");
        String tempShape = myScanner.nextLine();
        //input to ask what shape the user wants to make as the fractal pattern
        FractalDrawer myDrawer = new FractalDrawer();
        //initialize an object for FractalDrawer to send in the shape
        Double area = myDrawer.drawFractal(tempShape);
        //receive the total area of the fractal pattern and print
        System.out.println("The total area of your fractal is: " + area);
    }
}
