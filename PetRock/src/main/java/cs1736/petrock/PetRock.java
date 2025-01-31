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
    public static final int MIN_HUNGER=0;
    public static final int MIN_BOREDOM=0;
    public static final int MIN_ENERGY=0;
    
    //Methods 
    public void FeedRock()
    {
        hunger=hunger-2;
        boredom++;
        
        if(boredom<MIN_BOREDOM)
        {
            boredom=0;
        }
        if(boredom>MAX_BOREDOM)
        {
            boredom=10;
        }
        if(hunger<MIN_HUNGER)
        {
            hunger=0;
        }
        if(hunger>MAX_HUNGER)
        {
            hunger=10;
        }      
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
