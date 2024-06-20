import javax.swing.*;
import java.awt.*;

public class Minesweeper {

    private static TitleScreen titleScreen;
    private static OptionsMenu optionsMenu;
    private static HelpMenu helpMenu;
    private static JFrame frame;
    
    // Game Details
    private int rows;
    private int columns;
    private int mines;

    public Minesweeper() {
        frame = new JFrame("MineSweeper");
        titleScreen = new TitleScreen(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(titleScreen);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Minesweeper();
    }

    public void goToOptionsMenu() {
        frame.remove(titleScreen);
        optionsMenu = new OptionsMenu(this);
        frame.add(optionsMenu);
        frame.revalidate();
        frame.repaint();
    }

    public void goToHelpMenu() {
        frame.remove(optionsMenu);
        helpMenu = new HelpMenu(this);
        frame.add(helpMenu);
        frame.revalidate();
        frame.repaint();
    }

    public void helpToOptions() {
        frame.remove(helpMenu);
        optionsMenu = new OptionsMenu(this);
        frame.add(optionsMenu);
        frame.revalidate();
        frame.repaint();
    }

    // Setters

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setMines(int mines) {
        this.mines = mines;
    }

}
