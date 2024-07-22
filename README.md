# Minesweeper

Welcome to the Minesweeper Game README! This document provides an overview of the Minesweeper game implementation developed by me, Emma Smith. Whether you're a player, developer, or enthusiast, this README will guide you through the game's features, installation instructions, gameplay mechanics, and more.

### Table Of Contents

* Overview
* Features
* Getting Started
* Installation
* Gameplay
* Controls
* Customization
* Contributing
* Troubleshooting
* License

Feel free to explore each section to learn about different aspects of the Minesweeper game and how to interact with it.

## Overview

Minesweeper is a classic puzzle game where players uncover tiles on a grid, aiming to avoid hidden mines. Each click reveals a number indicating nearby mines or uncovers a mine, ending the game if triggered. The goal is to clear the board without detonating any mines, using numbered clues strategically. Players mark potential mines with flags to prevent accidental clicks, navigating through levels of increasing difficulty. Its appeal lies in its blend of logic, deduction, and chance, offering a challenging yet accessible experience that has captivated players for decades.

### Author Info

Hello, I'm Emma, the sole programmer and author of this project. Currently a computer science student at QMUL, I am exploring various areas of computer science to specialize in, with a particular passion for AI, cybersecurity, and game development—diverse fields, I know! I am proficient in several languages, including Java, Python, HTML & CSS, Javascript, and PHP.

Beyond coding, my interests include video games, which initially sparked my interest in programming, and maintaining physical and mental health. For inquiries, feel free to contact me at smithemma.cs@gmail.com. I am dedicated to crafting efficient and user-friendly experiences and eagerly anticipate sharing my projects with the community.

## Features

This current version of minesweeper includes the following features:

* The game displayed on a clear grid layout which is easy to navigate with a responsive design.
* Three different dificulty levels (Easy, Medium & Hard) which each changes the size of the grid and amount of bombs.
* A flagging system to mark the locations of suspected mines with a counter to track how many flags have been placed.
* Interactive gameplay with adjacent empty cells being revealed after left clicking.
* Clear visual feedback of different colour cells to marks those clicked and those not.
* Sound effects for clicking cells, winning and losing.
* The time to complete each game is shown afterwards.
* Smooth navivgation going back and forwards through menus.

## Getting Started

This section provides instructions on how to set up and run the Minesweeper game on your local machine.

### Prerequisites
Before you begin, ensure you have the following installed:

Java Development Kit (JDK): You need JDK 8 or higher. You can download it from Oracle's official website.
Installation
Follow these steps to set up the Minesweeper game:

### Installation

Clone the Repository:

Open your terminal or command prompt.
Navigate to the directory where you want to clone the repository.
Run the following command:

git clone https://github.com/EmmaSmithCs/minesweeper-game.git

 Navigate to the Project Directory:

cd minesweeper-game

 Compile the Java Files:

Make sure all your Java files are in the same directory.

 Compile the Java files using the javac command:

javac *.java

Create a JAR File:

Create a manifest file (MANIFEST.MF) with the following content:

Manifest-Version: 1.0
Main-Class: Minesweeper

Package the compiled .class files and the manifest into a JAR file:

jar cfm Minesweeper.jar MANIFEST.MF *.class

### Running the Game

To run the Minesweeper game, execute the JAR file using the java -jar command:

java -jar Minesweeper.jar

### Playing the Game

Once the game starts, you can use the mouse to interact with the game board:

* Left-Click: Reveal a cell.
* Right-Click: Flag or unflag a cell suspected to contain a mine.
* The goal is to reveal all cells without mines and flag all cells containing mines. Good luck and have fun!

## Gameplay

This section provides an overview of how to play the Minesweeper game, detailing the game's objective, controls, and tips for success.

### Objective

The main objective of Minesweeper is to clear a rectangular board containing hidden "mines" without detonating any of them. You must strategically uncover cells on the board while avoiding mines and using clues from revealed cells to deduce the locations of the hidden mines.

### Game Controls

Left-Click: Uncover a cell.

* If the cell contains a mine, the game is over.
* If the cell does not contain a mine, it will reveal a number indicating how many adjacent cells contain mines, or it will reveal an empty space and automatically uncover adjacent cells with no mines.

Right-Click: Flag or unflag a cell as suspected to contain a mine.

* This helps keep track of potential mine locations without accidentally uncovering them.
* Right-click again to remove the flag if you change your mind.

### How to Play

Starting the Game:

When the game begins, the board is covered with hidden cells. The first cell you click is always safe and will never contain a mine.
Revealing Cells:

Use left-click to reveal cells. If a cell with a mine is revealed, the game is over.
If the cell reveals a number, it indicates how many mines are in the surrounding eight cells.
If the cell is empty, it means there are no mines in the adjacent cells, and those cells are automatically revealed.

Using Flags:

Use right-click to place a flag on cells where you suspect a mine is hidden. This prevents you from accidentally clicking on these cells.
You can remove the flag by right-clicking the flagged cell again.

Winning the Game:

The game is won when all non-mine cells are revealed, and all mines are correctly flagged.
The game ends in a loss if a mine is revealed by a left-click.

### Tips and Strategies

Start with the Corners: Begin uncovering cells from the corners or edges, as they often provide better starting points with fewer adjacent mines.
Use the Numbers: Use the numbers revealed to determine where mines are likely located. For example, if a cell with a "1" is adjacent to an already flagged cell, you know there are no other mines around that cell.

Flag Carefully: Only flag cells when you are certain they contain mines. Incorrectly flagged cells can mislead you and result in mistakes.
Look for Patterns: Familiarize yourself with common patterns that indicate safe cells or mine locations, such as "1-2-1" patterns along edges.

Enjoy your game of Minesweeper! Test your logic and strategy skills while having fun uncovering the board without triggering any mines.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE.txt) file for details.

## Acknowledgments

This project doesn't really have any acknowledgments but thank you to my friends who didn't tell me to stop playing minesweeper in my lectures, leading yo me becoming addicted to this games and in turn creating my own version. Thanks :/

## Contact Information

For any inquiries, feedback, or collaboration opportunities, feel free to contact me at:

- Email: [smithemma.cs@gmail.com](mailto:smithemma.cs@gmail.com)
- LinkedIn: [Your LinkedIn Profile](https://www.linkedin.com/in/emma-smith-6473292a3/)
- GitHub: [Your GitHub Profile](https://github.com/EmmaSmithCs)

## Final Note

Thank you for checking out my Minesweeper game! I hope you enjoy playing it as much as I enjoyed developing it. If you encounter any bugs, have suggestions for improvements, or want to contribute, please feel free to open an issue or submit a pull request on GitHub.

Happy mining!