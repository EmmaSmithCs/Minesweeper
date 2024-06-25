import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;

public class GameGUI extends JPanel {
    private Minesweeper gameInstance;
    private JButton[][] buttons;
    private JLabel flagTally;


    public GameGUI(Minesweeper gameInstance, int rows, int columns, int mines, boolean firstClick) {
        this.gameInstance = gameInstance;
        setLayout(new FlowLayout()); // Set FlowLayout

        // Create a panel to contain the game
        JPanel gamePanel = new JPanel();
        gamePanel.setOpaque(false);
        gamePanel.setLayout(new GridLayout(rows, columns));

        buttons = new JButton[rows][columns];

        int id = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                JButton button = new JButton();
                if (gameInstance.getDifficulty().equals("Easy")) {
                    button.setPreferredSize(new Dimension(100, 100));
                    button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
                    button.setFont(new Font("Arial", Font.BOLD, 48));
                } else if (gameInstance.getDifficulty().equals("Medium")) {
                    button.setPreferredSize(new Dimension(58, 58));
                    button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                    button.setFont(new Font("Arial", Font.BOLD, 24));
                } else if (gameInstance.getDifficulty().equals("Hard")) {
                    button.setPreferredSize(new Dimension(40, 40));
                    button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
                    button.setFont(new Font("Arial", Font.BOLD, 16));
                }
                button.setBackground(new Color(255, 145, 178));
                button.addMouseListener(new MouseClickListener(id));
                buttons[i][j] = button;
                gamePanel.add(button);
                id++;
            }
        }

        // Add the game panel to the panel
        add(gamePanel);

        // Add a panel for the side info
        JPanel sidePanel = new JPanel();
        sidePanel.setOpaque(false);
        sidePanel.setLayout(new GridLayout(2, 1));

        // Add flag tally
        flagTally = new JLabel("Flags: " + gameInstance.getFlagCount() + "/" + mines);
        flagTally.setFont(new Font("Arial", Font.BOLD, 48));
        flagTally.setForeground(new Color(255, 145, 178));
        flagTally.setBackground(new Color(255, 145, 178));
        flagTally.setBorder(new EmptyBorder(0, 0, 0, 0));
        sidePanel.add(flagTally);

        // Add back button
        JButton backButton = new JButton("Back");
        
        backButton.addActionListener(e -> {
            gameInstance.backButton();
            gameInstance.setFlagCount(0);
            gameInstance.setClickedButtonsCount(0);
            gameInstance.stopTimer();
        });
        backButton.setPreferredSize(new Dimension(300, 150));
        backButton.setFont(new Font("Arial", Font.BOLD, 48));
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(new Color(255, 145, 178));
        backButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 6));
        sidePanel.add(backButton);

        // Add the side panel to the panel
        add(sidePanel);
    }

    private class MouseClickListener extends MouseAdapter {
        private final int id;

        public MouseClickListener(int id) {
            this.id = id;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            JButton clickedButton = (JButton) e.getSource();
            if (SwingUtilities.isRightMouseButton(e)) {
                handleRightClick(clickedButton);
            } else if (SwingUtilities.isLeftMouseButton(e)) {
                handleLeftClick(clickedButton);
            }
        }

        private void handleRightClick(JButton clickedButton) {
            System.out.println("Right Clicked Button ID: " + id);
            if (clickedButton.getText().equals("F")) {
                clickedButton.setText("");
                clickedButton.setForeground(Color.BLACK);

                int tempFlags = gameInstance.getFlagCount();
                gameInstance.setFlagCount(tempFlags - 1);
            } else if (clickedButton.getBackground().equals(new Color(255, 217, 232))) {
                if (clickedButton.getText().equals("")) {
                    clickedButton.setBackground(new Color(255, 145, 178));
                } else {
                    return;
                }
                clickedButton.setText("");
            } else {
                clickedButton.setText("F");
                clickedButton.setForeground(Color.BLUE);

                int tempFlags = gameInstance.getFlagCount();
                gameInstance.setFlagCount(tempFlags + 1);
            }
            updateFlagTally();
        }

        private void handleLeftClick(JButton clickedButton) {
            System.out.println("Left Clicked Button ID: " + id);
            gameInstance.buttonClick(id);
            int value = gameInstance.getGrid()[id / gameInstance.getColumns()][id % gameInstance.getColumns()];
            if (clickedButton.getText().equals("F")) {
                return;
            }
            if (value == -1) {
                gameInstance.stopTimer();
                clickedButton.setText("X");
                clickedButton.setForeground(Color.RED);
                clickedButton.setEnabled(false);
                gameInstance.gameEndGoTo("Lose");
                
            } else if (value == 0 && clickedButton.getText().equals("")) {
                clickedButton.setBackground(new Color(255, 217, 232));
                clickedButton.setText(" ");
                clickedButton.setEnabled(false);
                gameInstance.setClickedButtonsCount(gameInstance.getClickedButtonsCount() + 1);
                checkWin();
            } else {
                if (clickedButton.getText().equals("")) {
                    clickedButton.setText(String.valueOf(value));
                clickedButton.setBackground(new Color(255, 217, 232));
                clickedButton.setForeground(new Color(255, 145, 178));
                clickedButton.setEnabled(false);
                gameInstance.setClickedButtonsCount(gameInstance.getClickedButtonsCount() + 1);
                checkWin();
                }
            }
        }

        private void updateFlagTally() {
            flagTally.setText("Flags: " + gameInstance.getFlagCount() + "/" + gameInstance.getMines());
        }

        private void checkWin() {
            System.out.println("Clicked Buttons Count: " + gameInstance.getClickedButtonsCount());
            if (gameInstance.getClickedButtonsCount() == gameInstance.getRows() * gameInstance.getColumns() - gameInstance.getMines()) {
                gameInstance.stopTimer();
                gameInstance.gameEndGoTo("Win");
                gameInstance.setClickedButtonsCount(0);
                gameInstance.setFlagCount(0);
                
            }
            
        }
    }
}