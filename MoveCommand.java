package turtle;

import mvc.Command;
import mvc.Model;

public class MoveCommand extends Command {
    public MoveCommand(Model model) { super(model); }
    public void execute() {
        Turtle turtle = (Turtle) model;
        turtle.move();
    }
}
