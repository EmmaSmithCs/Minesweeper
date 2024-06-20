import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;

public class HelpMenu extends JPanel{
    private Minesweeper gameInstance;

    public HelpMenu(Minesweeper gameInstance) {
        this.gameInstance = gameInstance;
        setLayout(new GridLayout(2, 1)); // Set GridLayout

        
        // Create a panel to contain the title
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Add the title to the title panel
        JLabel titleLabel = new JLabel("MineSweeper");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 100));
        titleLabel.setForeground(new Color(255, 145, 178));
        titleLabel.setBackground(new Color(255, 145, 178));
        titleLabel.setBorder(new EmptyBorder(100, 0, 0, 0));
        titlePanel.add(titleLabel);

        // Add the title panel to the panel at the top
        add(titlePanel);

        // Add a panel to contain the how to play
        JPanel howToPlayPanel = new JPanel();
        howToPlayPanel.setOpaque(false);
        howToPlayPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Add the how to play to the how to play panel
        JLabel howToPlayLabel = new JLabel("<html>How to Play<br><br> Minesweeper is a logic-based game where the objective is to clear a grid of hidden<br>" +
                                        "mines without detonating any. Each cell in the grid can either hide a mine or be empty.<br>" +
                                        "Clicking on an empty cell reveals a number indicating how many neighboring cells contain<br>" +
                                        "mines. Use these numbers to deduce the locations of mines and mark them with flags. If<br>" +
                                        "you click on a mine, the game is over. The game is won by uncovering all non-mine cells.<br>" +
                                        "Strategies involve pattern recognition and deduction to avoid mines and safely clear<br>" +
                                        "the grid.</html>");
        howToPlayLabel.setFont(new Font("Arial", Font.BOLD, 25));
        howToPlayLabel.setForeground(new Color(255, 145, 178));
        howToPlayLabel.setBackground(new Color(255, 145, 178));
        howToPlayPanel.add(howToPlayLabel);

        // Add a back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameInstance.helpToOptions();
            }
        });
        backButton.setPreferredSize(new Dimension(300, 150));
        backButton.setFont(new Font("Arial", Font.BOLD, 48));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(255, 145, 178));
        backButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6));
        howToPlayPanel.add(backButton);
        

        // Add the how to play panel to the panel at the top
        add(howToPlayPanel);


 

    }
}
