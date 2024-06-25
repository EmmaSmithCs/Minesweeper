import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;

public class GameGUI extends JPanel {
    private Minesweeper gameInstance;
    private static JButton[][] buttons;

    public GameGUI(Minesweeper gameInstance, int rows, int columns, int mines, boolean firstClick) {
        this.gameInstance = gameInstance;
        setLayout(new FlowLayout()); // Set FlowLayout

        // Create a panel to contain the game
        JPanel gamePanel = new JPanel();
        gamePanel.setOpaque(false);
        gamePanel.setLayout(new GridLayout(rows, columns));

        buttons = new JButton[rows][columns];

        

        if (firstClick) {
            int id = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    JButton button = new JButton();
                    if (gameInstance.getDifficulty().equals("Easy")) {
                        button.setPreferredSize(new Dimension(100, 100));
                        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
                        button.setFont(new Font("Arial", Font.BOLD, 48));
                    }
                    else if (gameInstance.getDifficulty().equals("Medium")) {
                        button.setPreferredSize(new Dimension(58, 58));
                        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                    }
                    else if (gameInstance.getDifficulty().equals("Hard")) {
                        button.setPreferredSize(new Dimension(40, 40));
                        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
                    }
                    button.setBackground(new Color(255, 145, 178));
                    button.addActionListener(new ButtonClickListener(id));
                    buttons[i][j] = button;
                    gamePanel.add(button);
                    id++;
                }
            }
        }
        else {

        }

        // Add the game panel to the panel
        add(gamePanel);


    }

    private class ButtonClickListener implements ActionListener {
        private int id;

        public ButtonClickListener(int id) {
            this.id = id;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            gameInstance.buttonClick(id);
            int value = gameInstance.getGrid()[id / gameInstance.getColumns()][id % gameInstance.getColumns()];
            if (value == -1) {
                clickedButton.setText("X");
                clickedButton.setForeground(Color.RED);
            }
            else if (value == 0) {
                clickedButton.setBackground(new Color(255, 217, 232));
            }
            else {
                clickedButton.setText(String.valueOf(value));
                clickedButton.setBackground(new Color(255, 217, 232));
            }
            clickedButton.setBackground(new Color(255, 217, 232));
            
        }
    }
}
