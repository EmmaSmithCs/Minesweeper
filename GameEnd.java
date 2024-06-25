import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;

public class GameEnd extends JPanel{
    private Minesweeper gameInstance;

    public GameEnd(Minesweeper gameInstance, String result) {
        this.gameInstance = gameInstance;
        setLayout(new BorderLayout());
        
        if (result.equals("Win")) {
            JLabel winMessage = new JLabel("Congratulations! You Win!", JLabel.CENTER);
            winMessage.setFont(new Font("Arial", Font.BOLD, 80));
            winMessage.setForeground(new Color(0, 255, 0));
            winMessage.setBackground(new Color(0, 255, 0));
            winMessage.setBorder(new EmptyBorder(100, 0, 0, 0));
            add(winMessage, BorderLayout.NORTH);
        } else {
            JLabel loseMessage = new JLabel("Game Over! You Lose!", JLabel.CENTER);
            loseMessage.setFont(new Font("Arial", Font.BOLD, 80));
            loseMessage.setForeground(new Color(255, 0, 0));
            loseMessage.setBackground(new Color(255, 0, 0));
            loseMessage.setBorder(new EmptyBorder(100, 0, 0, 0));
            add(loseMessage, BorderLayout.NORTH);
        }
        
        
        JLabel timeLabel = new JLabel("Time: " + gameInstance.getTime() + " seconds", JLabel.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 48));
        add(timeLabel, BorderLayout.CENTER);
        
        

        JPanel buttonPanel = new JPanel();
        JButton playAgainButton = new JButton("Play Again");
        playAgainButton.addActionListener(e -> gameInstance.playAgain());
        playAgainButton.setPreferredSize(new Dimension(300, 150));
        playAgainButton.setFont(new Font("Arial", Font.BOLD, 48));
        playAgainButton.setForeground(Color.WHITE);
        playAgainButton.setBackground(new Color(255, 145, 178));
        playAgainButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6));
        buttonPanel.add(playAgainButton);

        JButton changeDifficultyButton = new JButton("Change Difficulty");
        changeDifficultyButton.addActionListener(e -> gameInstance.changeDifficulty());
        changeDifficultyButton.setPreferredSize(new Dimension(300, 150));
        changeDifficultyButton.setFont(new Font("Arial", Font.BOLD, 32));
        changeDifficultyButton.setForeground(Color.WHITE);
        changeDifficultyButton.setBackground(new Color(255, 145, 178));
        changeDifficultyButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6));
        buttonPanel.add(changeDifficultyButton);

        JButton mainMenuButton = new JButton("Main Menu");
        mainMenuButton.addActionListener(e -> gameInstance.returnToMainMenu());
        mainMenuButton.setPreferredSize(new Dimension(300, 150));
        mainMenuButton.setFont(new Font("Arial", Font.BOLD, 48));
        mainMenuButton.setForeground(Color.WHITE);
        mainMenuButton.setBackground(new Color(255, 145, 178));
        mainMenuButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6));
        buttonPanel.add(mainMenuButton);

        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(new EmptyBorder(20, 0, 100, 0));
        
        add(buttonPanel, BorderLayout.SOUTH);
        


 

    }
}
