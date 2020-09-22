package turtle;

import mvc.Model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



public class Turtle extends Model {
    public static Integer WORLD_SIZE = 250; // height & width of the world (& view)
    public static Integer TURTLE_SIZE = 7;  // diameter of a turtle
    public static Integer CRUMB_SIZE = 5;   // diameter of a point drawn by the turtle
    public static Integer LINE_ADJUSTMENT = 4;

    public static Integer x, y; //location
    public Heading heading; //N,E,S,w
    public ArrayList<Point> path; // list of points visited when the pen was down
    public Color color;    // the color to make visited points
    public boolean penDown; // true if pen is down, else false


    public Turtle() {
        x = y = WORLD_SIZE / 2;
        path = new ArrayList<>();
        penDown = false;
        color = Color.WHITE;
        color = Color.WHITE;
        heading = Heading.EAST;

    }

    public Color getColor() {
        return color;
    }

    public void clear() {
        path.clear();
        x = y = WORLD_SIZE / 2; // back to center
        this.changed();
    }
    public void pen(){
        if (penDown) {
            this.color = Color.WHITE;
            penDown = false;
        }
        else {
            this.color = Color.BLACK;
            penDown = true;
        }
        this.changed();
    }

    public void turn(){
        String heading = JOptionPane.showInputDialog("enter heading");
        heading = heading.toUpperCase();
        try {
            switch (heading) {
                case "EAST":
                    this.heading = Heading.EAST;
                    break;
                case "WEST":
                    this.heading = Heading.WEST;
                    break;
                case "SOUTH":
                    this.heading = Heading.SOUTH;
                    break;
                case "NORTH":
                    this.heading = Heading.NORTH;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Invalid direction",JOptionPane.ERROR_MESSAGE);
        }
        this.changed();
    }

    public void move(){
        try {
            String numOfSteps = JOptionPane.showInputDialog("How far?");
            Integer steps = Integer.parseInt(numOfSteps);

            if (penDown) {
                Point point = new Point(x,y,color);
                path.add(point);
            }
                if (this.heading == Heading.EAST) {
                    x = x + steps;
                } else if (this.heading == Heading.WEST) {
                    x = x - steps;
                } else if (this.heading == Heading.SOUTH) {
                    y = y + steps;
                }else if (this.heading == Heading.NORTH) {
                    y = y - steps;
                }
                OutOfBound();
                if (penDown) {
                    Point point = new Point(x,y,color);
                    path.add(point);
                }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Invalid move",JOptionPane.ERROR_MESSAGE);
        }


        this.changed();


    }
    public void color(Turtle turtle){
        Color newColor = JColorChooser.showDialog(null, "Choose a color", turtle.getColor());
        this.color = newColor;
        this.changed();

    }
    public Integer getX() {return x;}
    public Integer getY() {
        return y;
    }
    public ArrayList<Point> getPath() {
        return this.path;
    }


    public void OutOfBound(){


        if (x > this.WORLD_SIZE + TurtleView.RECTANGLE_X-LINE_ADJUSTMENT){
            if (penDown){
                this.path.add(new Point(TurtleView.RECTANGLE_X+WORLD_SIZE-LINE_ADJUSTMENT,y,color));
                this.path.add(new Point(TurtleView.RECTANGLE_X-LINE_ADJUSTMENT,y,color));
            }
            x = x-WORLD_SIZE;
        }
        else if (x < TurtleView.RECTANGLE_X-LINE_ADJUSTMENT){
            if (penDown){
                this.path.add(new Point(TurtleView.RECTANGLE_X-LINE_ADJUSTMENT,y,color));
                this.path.add(new Point(WORLD_SIZE+TurtleView.RECTANGLE_X-LINE_ADJUSTMENT,y,color));
            }

            x = x+WORLD_SIZE;
        }
        else if (y > this.WORLD_SIZE + TurtleView.RECTANGLE_Y-LINE_ADJUSTMENT){
            if (penDown){
                this.path.add(new Point(x,TurtleView.RECTANGLE_Y+WORLD_SIZE-LINE_ADJUSTMENT,color));
                this.path.add(new Point(x,TurtleView.RECTANGLE_Y-LINE_ADJUSTMENT,color));
            }
            y = y-WORLD_SIZE;
        }
        else if (y < TurtleView.RECTANGLE_Y-LINE_ADJUSTMENT){
            if (penDown){
                this.path.add(new Point(x,TurtleView.RECTANGLE_Y-LINE_ADJUSTMENT,color));
                this.path.add(new Point(x,TurtleView.RECTANGLE_Y+WORLD_SIZE-LINE_ADJUSTMENT,color));
            }
            y = y+WORLD_SIZE;
        }

    }
}