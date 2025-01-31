package cs1736.petrock;
import java.util.Scanner;

public class PetRockDriver 
{
    public static void main(String[] args) 
    {
        int userInput;
        int turn=0;
        int turnSincePolish=0;
        int turnSinceFeed=0;
        int turnSincePlay;
        int daysEnergyZero; // This stores how many consecutive days the energy has been 0
        
        Scanner scanner = new Scanner (System.in);
        System.out.println("Pet Rock Driver");
        
        do
        {
            System.out.println("1. Feed rock");
            System.out.println("2. Play with rock");
            System.out.println("3. Polish rock");
            System.out.println("4. Check status");
            System.out.println("5. Quit");
            
            System.out.println("Enter your number choice");
            userInput=scanner.nextInt();
            
            if(userInput==1)
            {
                System.out.println("You chose choice 1");
            }
            else if(userInput==2)
            {
                System.out.println("You chose choice 2");
            }
            else if(userInput==3)
            {
                System.out.println("You chose choice 3");
            }
            else if(userInput==4)
            {
                System.out.println("You chose choice 4");
            }
            else if(userInput==5)
            {
                System.out.println("Quitting Program");
                break;
            }
        }while(userInput!=5);
    } 
}
