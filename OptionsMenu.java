import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;

public class OptionsMenu extends JPanel{
    private Minesweeper gameInstance;

    public OptionsMenu(Minesweeper gameInstance) {
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

        // Create a panel to hold the buttons
        JPanel optionsButtonPanel = new JPanel();
        optionsButtonPanel.setOpaque(false);
        optionsButtonPanel.setLayout(new GridLayout(4, 1));

        // Add an empty border to create space between the button and the bottom of the page
        optionsButtonPanel.setBorder(new EmptyBorder(20, 0, 100, 0));

        // Add a button for easy
        JButton easyButton = new JButton("Easy");
        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ADD CODE HERE TO PLAY THE GAME
            }
        });
        easyButton.setPreferredSize(new Dimension(300, 150));
        easyButton.setFont(new Font("Arial", Font.BOLD, 48));
        easyButton.setForeground(Color.WHITE);
        easyButton.setBackground(new Color(255, 145, 178));
        easyButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6));
        optionsButtonPanel.add(easyButton);

        // Add a button for medium
        JButton mediumButton = new JButton("Medium");
        mediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ADD CODE HERE TO PLAY THE GAME
            }
        });
        mediumButton.setPreferredSize(new Dimension(300, 150));
        mediumButton.setFont(new Font("Arial", Font.BOLD, 48));
        mediumButton.setForeground(Color.WHITE);
        mediumButton.setBackground(new Color(255, 145, 178));
        mediumButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6));
        optionsButtonPanel.add(mediumButton);

        // Add a button for hard
        JButton hardButton = new JButton("Hard");
        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ADD CODE HERE TO PLAY THE GAME
            }
        });
        hardButton.setPreferredSize(new Dimension(300, 150));
        hardButton.setFont(new Font("Arial", Font.BOLD, 48));
        hardButton.setForeground(Color.WHITE);
        hardButton.setBackground(new Color(255, 145, 178));
        hardButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6));
        optionsButtonPanel.add(hardButton);

        // Add a button for help
        JButton helpButton = new JButton("Help");
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //ADD CODE HERE FOR HELP
            }
        });
        helpButton.setPreferredSize(new Dimension(300, 150));
        helpButton.setFont(new Font("Arial", Font.BOLD, 48));
        helpButton.setForeground(Color.WHITE);
        helpButton.setBackground(new Color(255, 145, 178));
        helpButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6));
        optionsButtonPanel.add(helpButton);

        // Add the button panel to the panel at the bottom
        add(optionsButtonPanel);










        

    }
}
