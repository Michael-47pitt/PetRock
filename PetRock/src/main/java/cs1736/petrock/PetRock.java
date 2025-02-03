package cs1736.petrock;
import com.google.gson.Gson;

public class PetRock {

    //Variables 
    String name = "";
    String[] moods = {"Happy", "Bored", "Tired", "Sad"};
    String mood;
    int hunger;
    int boredom;
    int energy;
    private static PetRock PetRockInstance = null;

    //Constructor 
    private PetRock(String n)
    {
        name = n;
        hunger = 5;
        boredom = 5;
        energy = 5;
    }
    
    public static PetRock getPetRock(String n)
    {
        if (PetRockInstance == null)
            PetRockInstance = new PetRock(n);
        return PetRockInstance;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getMood()
    {
        return mood;
    }
    
    public int getHunger()
    {
        return hunger;
    }
    
    public int getBoredom()
    {
        return boredom;
    }
    
    public int getEnergy()
    {
        return energy;
    }
    
    public void setName(String n)
    {
        name = n;
    }
    
    public void setMood(String m)
    {
        mood = m;
    }
    
    public void setHunger(int h)
    {
        hunger = h;
    }
    
    public void setBoredom(int b)
    {
        boredom = b;
    }
    
    public void setEnergy(int e)
    {
        energy = e;
    }
}
