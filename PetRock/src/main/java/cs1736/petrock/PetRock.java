package cs1736.petrock;
public class PetRock {

    //Variables 
    String name = "";
    String[] mood = {"Happy", "Bored", "Tired", "Sad"};
    int hunger ; // High hunger = bad
    int boredom; // High boredom = bad
    int energy; // Low energy = bad
    
    // Constant values for maximum and minimum values
    public static final int MAX_HUNGER=10;
    public static final int MAX_BOREDOM=10;
    public static final int MAX_ENERGY=10;
    public static final int MIN_HUNGER=10;
    public static final int MIN_BOREDOM=10;
    public static final int MIN_ENERGY=10;
    
    //Methods 
    public void FeedRock()
    {
        System.out.println("Feed rock");
    }
    
    public void PlayWithRock()
    {
         System.out.println("Play with rock");
    }
    
    public void PolishRock()
    {
         System.out.println("polish rock");
         
    }
    
    public void UpdateMood()
    {
         System.out.println("update mood");
    }
}
