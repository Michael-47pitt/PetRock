package cs1736.petrock;
import java.util.Scanner;

/**
 *
 * @author Michael Paonessa
 */
public class PetRockDriver 
{
    public static void main(String[] args) 
    {
        int userInput;
        Scanner scanner = new Scanner (System.in);
        PetRock playerRock = PetRock.getPetRock();
        if (playerRock.getName() == null)
        {
            System.out.print("Enter a name for your rock: ");
            String rockName = scanner.nextLine();
            playerRock.setName(rockName);
        }
        System.out.println("This is a test for CI/CD...............");
        System.out.println("1. Feed rock");
        System.out.println("2. Play with rock");
        System.out.println("3. Polish rock");
        System.out.println("4. Check status");
        System.out.println("5. Quit");
        System.out.println("-------------------------------------");
        
        
        do
        {
            System.out.print("Enter your number choice: ");
            userInput=scanner.nextInt();
            
            switch(userInput)
            {
                case 1: PetRockManager.FeedRock(playerRock);
                        break;
                case 2: PetRockManager.PlayWithRock(playerRock);
                        break;
                case 3: PetRockManager.PolishRock(playerRock);
                        break;
                case 4: PetRockManager.DisplayStatus(playerRock);
                        break;
                case 5: break;
                default: System.out.println("ERROR: Invalid input");
            }
            
            if (userInput != 5)
            {
                PetRockManager.updateTimeSimulation(playerRock);
                PetRockManager.moodCalculation(playerRock);
            }
            
            playerRock.save();
            System.out.println();
        } while(userInput!=5);
    }
}