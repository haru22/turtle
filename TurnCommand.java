package turtle;

import mvc.Command;
import mvc.Model;

public class TurnCommand extends Command {
    public TurnCommand(Model model) { super(model); }
    public void execute() {
        Turtle turtle = (Turtle) model;
        turtle.turn();
    }
}
