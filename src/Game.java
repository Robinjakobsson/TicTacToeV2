import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class to Represent the game
 */
public class Game extends Methods {
Scanner scanner = new Scanner(System.in);
    public void gameRun (){
        boolean isRunning = true;


        while (isRunning){
            System.out.println("1: Play");
            System.out.println("2: Two player");
            System.out.println("3: Instructions");
            System.out.println("4: Exit");
            try {
                int menuInput = scanner.nextInt();

                switch (menuInput) {

                    case 1:
                        gameStart();
                        break;
                    case 2:
                        tpGameStart();
                        break;
                    case 3:
                        exampleBoard();
                        break;
                    case 4:
                        isRunning = false;

                }
            }
            catch (InputMismatchException e){
                System.out.println("Error");
                scanner.nextLine();
            }
        }
    }
}
