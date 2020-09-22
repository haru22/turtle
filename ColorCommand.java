package turtle;

import mvc.Command;
import mvc.Model;

public class ColorCommand extends Command {
    public ColorCommand(Model model) { super(model); }
    public void execute() {
        Turtle turtle = (Turtle) model;
        turtle.color(turtle);
    }
}
