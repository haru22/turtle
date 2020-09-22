package turtle;

import mvc.AppFactory;
import mvc.Command;
import mvc.Model;

public class TurtleFactory implements AppFactory {
    @Override
    public Model makeModel() {
        return new Turtle();
    }

    @Override
    public String[] getEditCommands() {
        return new String[0];
    }

    @Override
    public Command makeEditCommand(Model model, String type) {
        if (type == "Clear")
            return new ClearCommand(model);
        else if (type =="Color")
            return new ColorCommand(model);
        else if (type == "Move")
            return new MoveCommand(model);
        else if(type =="Pen")
            return new PenCommand(model);
        else if (type == "Turn")
            return new TurnCommand(model);
        else return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String[] getHelp() {
        return new String[0];
    }

    @Override
    public String about() {
        return null;
    }
}
