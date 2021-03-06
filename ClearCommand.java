package turtle;

import mvc.Command;
import mvc.Model;

public class ClearCommand extends Command {
    public ClearCommand(Model model) { super(model); }
    public void execute() {
        Turtle turtle = (Turtle) model;
        turtle.clear();
    }
}
