import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;

public class TitleScreen extends JPanel {
    private Minesweeper gameInstance;

    public TitleScreen(Minesweeper gameInstance) {
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

        // Create a panel to contain the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Add an empty border to create space between the button and the bottom of the page
        buttonPanel.setBorder(new EmptyBorder(20, 0, 100, 0));
        
        // Add the play button to the button panel
        JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameInstance.goToOptionsMenu();
            }
        });
        playButton.setPreferredSize(new Dimension(300, 150));
        playButton.setFont(new Font("Arial", Font.BOLD, 48));
        playButton.setForeground(Color.WHITE);
        playButton.setBackground(new Color(255, 145, 178));
        playButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6));
        buttonPanel.add(playButton);

        // Add the button panel to the panel at the bottom
        add(buttonPanel);

    }

}