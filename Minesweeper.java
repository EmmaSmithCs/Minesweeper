import javax.swing.*;
import java.awt.*;

public class Minesweeper {

    private static TitleScreen titleScreen;
    private static JFrame frame;

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
        frame.add(new OptionsMenu(this));
        frame.revalidate();
        frame.repaint();
    }
}
