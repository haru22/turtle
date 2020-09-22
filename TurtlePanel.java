package turtle;

import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.util.HashSet;
import java.util.Set;

public class TurtlePanel extends AppPanel{

    protected Set<View> views;
    private JButton turnButton, moveButton, clearButton, penButton, colorButton;


    public TurtlePanel(AppFactory factory) {
        super(factory);
        initPanel();
    }


    protected JMenuBar createMenuBar() {
        JMenuBar result = new JMenuBar();
        // add file, edit, and help menus
        JMenu fileMenu =
                Utilities.makeMenu("File", new String[] {"New",  "Save", "SaveAs", "Open", "Quit"}, this);
        result.add(fileMenu);

        JMenu editMenu =
                Utilities.makeMenu("Edit", factory.getEditCommands(), this);
        result.add(editMenu);

        JMenu helpMenu =
                Utilities.makeMenu("Help", new String[] {"About", "Help"}, this);
        result.add(helpMenu);

        return result;
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Object source = ae.getSource();
            if (source == turnButton) {
                Command cmmd = new TurnCommand(model);
                CommandProcessor.execute(cmmd);
            } else if (source == moveButton ) {
                Command cmmd = new MoveCommand(model);
                CommandProcessor.execute(cmmd);
            } else if (source == clearButton){
                Command cmmd = new ClearCommand(model);
                CommandProcessor.execute(cmmd);
            } else if (source == penButton) {
                Command cmmd = new PenCommand(model);
                CommandProcessor.execute(cmmd);
            } else if (source == colorButton){
                Command cmmd = new ColorCommand(model);
                CommandProcessor.execute(cmmd);
            } else {
                super.actionPerformed(ae);
            }

        }catch (NumberFormatException e) {
            Utilities.error("Error");
        }
    }

    public void initPanel() {
        Turtle turtle = (Turtle)model;
        TurtleView view = new TurtleView((Turtle)model);
        this.setLayout(new GridLayout(1,2));
        turnButton = new JButton("Turn");
        moveButton = new JButton("Move");
        clearButton = new JButton("Clear");
        penButton = new JButton("Pen");
        colorButton = new JButton("Color");

        // listen to button
        turnButton.setActionCommand("Turn");
        turnButton.addActionListener(this);
        moveButton.setActionCommand("Move");
        moveButton.addActionListener(this);
        clearButton.setActionCommand("Clear");
        clearButton.addActionListener(this);
        penButton.setActionCommand("Pen");
        penButton.addActionListener(this);
        colorButton.setActionCommand("color");
        colorButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        buttonPanel.add(turnButton);
        buttonPanel.add(moveButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(penButton);
        buttonPanel.add(colorButton);
        this.add(buttonPanel, "North");

        this.add(view, "South");
    }

    public static void main(String[] args) {
        AppPanel panel = new TurtlePanel(new TurtleFactory());
        panel.display();
    }



}
