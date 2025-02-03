package cs1736.petrock;
import com.google.gson.Gson;

public class PetRock {

    //Variables 
    String name = "";
    String[] mood = {"Happy", "Bored", "Tired", "Sad"};
    int hunger;
    int boredom;
    int energy;
    int polishRockCounter = 0;
    private static PetRock PetRockInstance = null;

    //Constructor 
    private PetRock(String n) {
        name = n;
        hunger = 5;
        boredom = 5;
        energy = 5;
    }
    
    public static PetRock getPetRock(String n) {
        if (PetRockInstance == null)
            PetRockInstance = new PetRock(n);
        return PetRockInstance;
    }
    
    //Methods 
}
