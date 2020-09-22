package turtle;

import mvc.View;

import java.awt.*;

public class TurtleView extends View {
    public static Integer RECTANGLE_X = 10;
    public static Integer RECTANGLE_Y = 10;


    public TurtleView(Turtle turtle) {
        super(turtle);
    }

    public void paintComponent(Graphics gc) {
        Turtle turtle = (Turtle)model;
        Graphics2D g2d = (Graphics2D)gc;

        Color oldColor = gc.getColor();

        // draw path
        g2d.setStroke(new BasicStroke(2));
        g2d.drawRect(RECTANGLE_X,RECTANGLE_Y,turtle.WORLD_SIZE,turtle.WORLD_SIZE);

        gc.setColor(turtle.getColor());
        gc.fillOval(turtle.getX(), turtle.getY(), turtle.TURTLE_SIZE, turtle.TURTLE_SIZE);

        for (int i =0; i < turtle.getPath().size(); i++) {
            Point p1 = turtle.getPath().get(i);
            Point p2 = turtle.getPath().get(i+1);
            g2d.setColor(p1.color);
            g2d.drawLine(p1.x+Turtle.LINE_ADJUSTMENT,p1.y+Turtle.LINE_ADJUSTMENT,p2.x+Turtle.LINE_ADJUSTMENT,p2.y+Turtle.LINE_ADJUSTMENT);
            i++;
        }
        gc.setColor(oldColor);
    }
}
