import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Class with Methods
 */
public class Methods {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    Player player = new Player("Robin", 'X');
    CPU cpu = new CPU("Billy",'O');
    Player playerTwo = new Player("Simon",'O');

    /**
     * Method to start the game vs the CPU
     */
    public void gameStart(){
        char[][] gameBoard = {{'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_',},
                {' ', '-', ' ', '|', ' ', '-', ' ', '|', ' ', '-',},
                {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_',},
                {' ', '-', ' ', '|', ' ', '-', ' ', '|', ' ', '-', ' ',},
                {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_',},
                {' ', '-', ' ', '|', ' ', '-', ' ', '|', ' ', '-', ' ',}};
        printBoard(gameBoard);

        boolean gameActive = true;
        while (gameActive) {
            // Player turn starts here
        try {
            System.out.println(player.getName() + "'s turn: (1-9)");
            int pos = scanner.nextInt();

            while (!checkValid(pos, gameBoard)) {
                System.out.println("Not a valid move..");
                pos = scanner.nextInt();
            }

            placement(pos, player, gameBoard);
            if (checkWinner(gameBoard, player.getMarker())) {
                System.out.println(player.getName() + " Has won!");
                player.setWinCount(player.getWinCount() + 1);
                cpu.setLoseCount(cpu.getLoseCount() + 1);
                gameActive = false;
                printStats();
                break;
            }
            else if (isBoardFull(gameBoard)) {
                System.out.println("It's a tie!");
                gameActive = false;
                printStats();
                break;
            }

            System.out.println(cpu.getName() + "'s turn!");
            int enemyPos = random.nextInt(1, 10);

            while (!checkValid(enemyPos, gameBoard)) {
                System.out.println("Not a valid move...");
                enemyPos = random.nextInt(1, 10);
            }

            placement(enemyPos, cpu, gameBoard);

            if (checkWinner(gameBoard, cpu.getMarker())) {
                System.out.println(cpu.getName() + " Has won!");
                cpu.setWinCount(cpu.getWinCount() + 1);
                player.setLoseCount(player.getLoseCount() + 1);
                gameActive = false;
                printStats();
                break;
            }
            else if (isBoardFull(gameBoard)) {
                System.out.println("It's a tie!");
                gameActive = false;
                printStats();
                break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Error");
            scanner.nextLine();
            }
        }
    }
    /**
     * Method to print out the board.
     * @param gameBoard is the GameBoard.
     */
    public void printBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    /**
     * Method to place a piece on the GameBoard
     * @param pos is the value of position
     * @param player is the player
     * @param gameBoard is the GameBoard
     */
    public void placement (int pos,Player player,char[][] gameBoard){
        switch (pos){
            case 1:
                gameBoard[1][1] = player.getMarker();
                printBoard(gameBoard);
                break;

            case 2:
                gameBoard[1][5] = player.getMarker();
                System.out.println();
                printBoard(gameBoard);
                break;
            case 3:
                gameBoard[1][9] = player.getMarker();
                System.out.println();
                printBoard(gameBoard);
                break;
            case 4:
                gameBoard[3][1] = player.getMarker();
                System.out.println();
                printBoard(gameBoard);
                break;
            case 5:
                gameBoard[3][5] = player.getMarker();
                System.out.println();
                printBoard(gameBoard);
                break;
            case 6:
                gameBoard[3][9] = player.getMarker();
                System.out.println();
                printBoard(gameBoard);
                break;
            case 7:
                gameBoard[5][1] = player.getMarker();
                System.out.println();
                printBoard(gameBoard);
                break;
            case 8:
                gameBoard[5][5] = player.getMarker();
                System.out.println();
                printBoard(gameBoard);
                break;
            case 9:
                gameBoard[5][9] = player.getMarker();
                System.out.println();
                printBoard(gameBoard);
                break;
        }
    }

    /**
     * Method to check if a move is doable/Valid
     * @param pos is the position
     * @param gameBoard is the GameBoard
     * @return True if it is Valid
     */
    public boolean checkValid(int pos, char[][] gameBoard){
        switch (pos){
            case 1: return gameBoard[1][1] == '-';
            case 2: return gameBoard[1][5] == '-';
            case 3: return gameBoard[1][9] == '-';
            case 4: return gameBoard[3][1] == '-';
            case 5: return gameBoard[3][5] == '-';
            case 6: return gameBoard[3][9] == '-';
            case 7: return gameBoard[5][1] == '-';
            case 8: return gameBoard[5][5] == '-';
            case 9: return gameBoard[5][9] == '-';
        }
        return false;
    }

    /**
     * Method to check if a person has won, Checking all positions
     * for a marker.
     * @param gameBoard Is the GameBoard
     * @param marker is the Players or Cpus Marker
     * @return TRUE if a player/cpu has won
     */
    public boolean checkWinner(char[][] gameBoard, char marker){
        return  (gameBoard[1][1] == marker && gameBoard[1][5] == marker && gameBoard[1][9] == marker) ||
                (gameBoard[3][1] == marker && gameBoard[3][5] == marker && gameBoard[3][9] == marker) ||
                (gameBoard[5][1] == marker && gameBoard[5][5] == marker && gameBoard[5][9] == marker) ||
                (gameBoard[1][1] == marker && gameBoard[3][1] == marker && gameBoard[5][1] == marker) ||
                (gameBoard[1][5] == marker && gameBoard[3][5] == marker && gameBoard[5][5] == marker) ||
                (gameBoard[1][9] == marker && gameBoard[3][9] == marker && gameBoard[5][9] == marker) ||
                (gameBoard[1][1] == marker && gameBoard[3][5] == marker && gameBoard[5][9] == marker) ||
                (gameBoard[1][9] == marker && gameBoard[3][5] == marker && gameBoard[5][1] == marker);

    }

    /**
     * Method to check if the board is occupied by markers
     * if a '_' is present, the board is not full.
     * @param gameBoard is the GameBoard
     * @return True if the board is full
     */
    public boolean isBoardFull(char[][] gameBoard){
        for (char[] row : gameBoard){
            for (char c : row){
                if (c == '-'){
                    return false;
                }
            }

        }
        return true;
    }

    /**
     * Method to print out the stats
     */

    public void printStats(){
        System.out.println(player.getName() + "'s Stats");
        System.out.println("Wins: " + player.getWinCount());
        System.out.println("Losses: " + player.loseCount);
        System.out.println();
        System.out.println(cpu.getName() + "'s Stats");
        System.out.println("Wins: " + cpu.getWinCount());
        System.out.println("Losses: " + cpu.getLoseCount());
    }

    /**
     * Method to print out a board with numbers on to understand how to play.
     */
    public void exampleBoard() {
        char[][] exampleBoard = {{'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {' ', '1', ' ', '|', ' ', '2', ' ', '|', ' ', '3',},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {' ', '4', ' ', '|', ' ', '5', ' ', '|', ' ', '6', ' ',},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-', '-', '-',},
                {' ', '7', ' ', '|', ' ', '8', ' ', '|', ' ', '9', ' ',}};

        for (char[] row : exampleBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println("The game is played on a grid that's 3 squares by 3 squares");
        System.out.println("You are 'X', The computer is 'O' You take turns putting your marks");
        System.out.println("The first player to get 3 of their marks in a row wins!");
    }

    /**
     * Method to start the two player mode
     */
    public void tpGameStart(){
        char[][] gameBoard = {{'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_',},
                {' ', '-', ' ', '|', ' ', '-', ' ', '|', ' ', '-',},
                {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_',},
                {' ', '-', ' ', '|', ' ', '-', ' ', '|', ' ', '-', ' ',},
                {'_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_',},
                {' ', '-', ' ', '|', ' ', '-', ' ', '|', ' ', '-', ' ',}};
        printBoard(gameBoard);
        boolean gameActive = true;
        while (gameActive) {
            // Player turn starts here
            try {
                System.out.println(player.getName() + "'s turn (1-9)");
                int pos = scanner.nextInt();

                while (!checkValid(pos, gameBoard)) {
                    System.out.println("Not a valid move..");
                    pos = scanner.nextInt();
                }

                placement(pos, player, gameBoard);



                if (checkWinner(gameBoard, player.getMarker())) {
                    System.out.println(player.getName() + " Has won!");
                    player.setWinCount(player.getWinCount() + 1);
                    playerTwo.setLoseCount(playerTwo.getLoseCount() + 1);
                    gameActive = false;
                    tpPrintStats();
                    break;
                }

                if (isBoardFull(gameBoard)) {
                    System.out.println("It's a tie!");
                    gameActive = false;
                    tpPrintStats();
                    break;
                }

                } catch (InputMismatchException e) {
                    System.out.println("Error");
                    scanner.nextLine();
                    continue;
            }

            boolean validMove = false;
            while (!validMove){
           try{
            System.out.println(playerTwo.getName() + "'s turn (1-9)");
            int enemyPos = scanner.nextInt();


            while (!checkValid(enemyPos, gameBoard)) {
                System.out.println("Not a valid move...");
                enemyPos = scanner.nextInt();
            }

            placement(enemyPos, cpu, gameBoard);
            validMove = true;

            if (checkWinner(gameBoard, playerTwo.getMarker())) {
                System.out.println(playerTwo.getName() + " Has won!");
                playerTwo.setWinCount(playerTwo.getWinCount() + 1);
                player.setLoseCount(player.getLoseCount() + 1);
                gameActive = false;
                tpPrintStats();
                break;
            }

               if (isBoardFull(gameBoard)) {
                   System.out.println("It's a tie!");
                   gameActive = false;
                   tpPrintStats();
                   break;
               }

                } catch (InputMismatchException e){
               System.out.println("Invalid input");
               scanner.nextLine();
                }
            }
        }
    }

    /**
     * Identical method to PrintStats but used for TwoPlayerMode
     */
    public void tpPrintStats(){
        System.out.println(player.getName() + "'s Stats");
        System.out.println("Wins: " + player.getWinCount());
        System.out.println("Losses: " + player.loseCount);
        System.out.println();
        System.out.println(playerTwo.getName() + "'s Stats");
        System.out.println("Wins: " + playerTwo.getWinCount());
        System.out.println("Losses: " + playerTwo.getLoseCount());
    }
}
