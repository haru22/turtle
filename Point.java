package turtle;

import java.awt.*;
import java.io.Serializable;

public class Point implements Serializable {
    public Integer x, y;
    public Color color;
    public Point(Integer x, Integer y, Color color) {
        super();
        this.x = x;
        this.y = y;
        this.color = color;
    }
}
