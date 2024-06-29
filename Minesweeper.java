import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.io.File;
import java.util.Queue;


public class Minesweeper {

    private static TitleScreen titleScreen;
    private static OptionsMenu optionsMenu;
    private static HelpMenu helpMenu;
    private static GameGUI gameGUI;
    private static GameEnd gameEnd;
    private static JFrame frame;
    
    // Game Details
    private static int rows;
    private static int columns;
    private static int mines;
    private static String difficulty;
    private static int[][] grid;
    private static boolean firstClick = true;
    private static int flagCount;
    private static int clickedButtonsCount = 0;
    private static double time = 0;
    private static Timer timer;
    private static int[][] clickedButtons;



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

    public void backButton() {
        frame.remove(gameGUI);
        titleScreen = new TitleScreen(this);
        frame.add(optionsMenu);
        frame.revalidate();
        frame.repaint();
        firstClick = true;
        clickedButtonsCount = 0;
    }

    public void gameEndGoTo(String result) {
        frame.remove(gameGUI);
        gameEnd = new GameEnd(this, result);
        frame.add(gameEnd);
        frame.revalidate();
        frame.repaint();
        firstClick = true;
        clickedButtonsCount = 0;
    }

    public void playAgain() {
        time = 0;
        flagCount = 0;
        frame.remove(gameEnd);
        gameGUI = new GameGUI(this, rows, columns, mines, true);
        frame.add(gameGUI);
        frame.revalidate();
        frame.repaint();
    }

    public void changeDifficulty() {
        frame.remove(gameEnd);
        optionsMenu = new OptionsMenu(this);
        frame.add(optionsMenu);
        frame.revalidate();
        frame.repaint();
    }

    public void returnToMainMenu() {
        frame.remove(gameEnd);
        titleScreen = new TitleScreen(this);
        frame.add(titleScreen);
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

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public void setFlagCount(int flagCount) {
        this.flagCount = flagCount;
    }

    public void setClickedButtonsCount(int clickedButtonsCount) {
        this.clickedButtonsCount = clickedButtonsCount;
    }

    public void setTime(double time) {
        this.time = time;
    }

    

    // Getters

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getMines() {
        return mines;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int[][] getGrid() {
        return grid;
    }

    public int getFlagCount() {
        return flagCount;
    }

    public int getClickedButtonsCount() {
        return clickedButtonsCount;
    }

    public double getTime() {
        return time;
    }


    public void startGame() {
        time = 0;
        frame.remove(optionsMenu);
        gameGUI = new GameGUI(this, rows, columns, mines, true);
        frame.add(gameGUI);
        frame.revalidate();
        frame.repaint();
    }

    public void buttonClick(int originButton) {
        if (firstClick) {
            int[] locations = new int[mines];
            Random random = new Random();
            for (int i = 0; i < mines; i++) {
                boolean mineSet = false;
                while (!mineSet) {
                    int location = random.nextInt(rows * columns);
                    System.out.println("Random num: " + location);
                    boolean alreadyExists = false;
                    for (int j = 0; j < i; j++) {
                        if (locations[j] == location) {
                            alreadyExists = true;
                            System.out.println("Already exists or is orgin button");
                            break;
                        }
                    }
                    if (location != originButton && !alreadyExists) {
                        locations[i] = location;
                        mineSet = true;
                    }
                    
                }
                
            }

            // Print locations
            for (int i = 0; i < locations.length; i++) {
                System.out.print(locations[i] + " ");
                
            }

            // Create grid
            grid = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    // Get current ID
                    int id = i * columns + j;

                    // Check if current ID is a mine (in locations array)
                    boolean alreadyExists = false;
                    for (int k = 0; k < mines; k++) {
                        if (locations[k] == id) {
                            alreadyExists = true;
                            System.out.println("Mine at: " + id);   
                            break;
                        }
                    }

                    if (alreadyExists) {
                        grid[i][j] = -1;
                    }
                    else {
                        // Check surrounding cells
                        int count = 0;
                        int temp = 0;
                        
                        // Check top left
                        temp = id - columns - 1;
                        if (temp >= 0 && temp < rows * columns && temp % columns != columns - 1) {
                            for (int k = 0; k < mines; k++) {
                                if (locations[k] == temp) {
                                    count++;
                                }
                            }
                        }

                        // Check top
                        temp = id - columns;
                        if (temp >= 0 && temp < rows * columns) {
                            for (int k = 0; k < mines; k++) {
                                if (locations[k] == temp) {
                                    count++;
                                }
                            }
                        }

                        // Check top right
                        temp = id - columns + 1;
                        if (temp >= 0 && temp < rows * columns && temp % columns != 0) {
                            for (int k = 0; k < mines; k++) {
                                if (locations[k] == temp) {
                                    count++;
                                }
                            }
                        }

                        // Check left
                        temp = id - 1;
                        if (temp >= 0 && temp < rows * columns && temp % columns != columns - 1) {
                            for (int k = 0; k < mines; k++) {
                                if (locations[k] == temp) {
                                    count++;
                                }
                            }
                        }

                        // Check right
                        temp = id + 1;
                        if (temp >= 0 && temp < rows * columns && temp % columns != 0) {
                            for (int k = 0; k < mines; k++) {
                                if (locations[k] == temp) {
                                    count++;
                                }
                            }
                        }

                        // Check bottom left
                        temp = id + columns - 1;
                        if (temp >= 0 && temp < rows * columns && temp % columns != columns - 1) {
                            for (int k = 0; k < mines; k++) {
                                if (locations[k] == temp) {
                                    count++;
                                }
                            }
                        }

                        // Check bottom
                        temp = id + columns;
                        if (temp >= 0 && temp < rows * columns) {
                            for (int k = 0; k < mines; k++) {
                                if (locations[k] == temp) {
                                    count++;
                                }
                            }
                        }

                        // Check bottom right
                        temp = id + columns + 1;
                        if (temp >= 0 && temp < rows * columns && temp % columns != 0) {
                            for (int k = 0; k < mines; k++) {
                                if (locations[k] == temp) {
                                    count++;
                                }
                            }
                        }

                        

                        

                    
                        

                        grid[i][j] = count;

                    
                    }
                }
            }

            //Print grid in square format
            for (int k = 0; k < rows; k++) {
                for (int l = 0; l < columns; l++) {
                    System.out.print(grid[k][l] + " ");
                }
                System.out.println();            }

            firstClick = false;
            
            // Start timer
            

            startTimer();

        }
        

    }

    

    private void startTimer() {
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time+=0.1;
            }
        });
        timer.start();
    }

    public void stopTimer() {
        if (timer != null) {
            timer.stop();
            time = round2DP(time);
        }
    }
    
    public double round2DP(double num) {
        System.out.println("Rounded: " + Math.round(num * 100.0) / 100.0 + " Is the rounded time");
        return Math.round(num * 100.0) / 100.0;
    }

    public void playSound(String soundFile) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFile).getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
