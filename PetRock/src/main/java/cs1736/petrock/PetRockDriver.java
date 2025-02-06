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
            String rockName = input.nextLine();
            playerRock.setName(rockName);
        }
        
        do
        {
            System.out.println("1. Feed rock");
            System.out.println("2. Play with rock");
            System.out.println("3. Polish rock");
            System.out.println("4. Check status");
            System.out.println("5. Quit");
            
            System.out.print("Enter your number choice: ");
            userInput=scanner.nextInt();
            
            switch(userInput) {
                case 1:     PetRock.FeedRock(playerRock);
                            break;
                case 2:     PetRock.PlayWithRock(playerRock);
                            break;
                case 3:     PetRock.PolishRock(playerRock);
                            break;
                case 4:     PetRock.UpdateMood(playerRock);
                            break;
                case 5:     break;
                default:    System.out.println("ERROR: Invalid input");
            }
        }while(userInput!=5);
        
        scanner.close();
    }   
}
