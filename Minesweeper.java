import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class Minesweeper {

    private static TitleScreen titleScreen;
    private static OptionsMenu optionsMenu;
    private static HelpMenu helpMenu;
    private static JFrame frame;
    
    // Game Details
    private static int rows;
    private static int columns;
    private static int mines;
    private static String difficulty;
    private static int[][] grid;
    private static boolean firstClick = true;

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

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
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



    public void startGame() {
        frame.remove(optionsMenu);
        GameGUI gameGUI = new GameGUI(this, rows, columns, mines, true);
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
                System.out.println();
            }

            firstClick = false;

        }
        

    }
    
}
