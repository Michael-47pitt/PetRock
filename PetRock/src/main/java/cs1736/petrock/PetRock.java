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
    public void FeedRock() {
        boredom++;
        hunger--;
        energy--;
        System.out.println("Feed rock");
    }

    public void PlayWithRock() {
        energy = energy - 2;
        boredom = boredom - 3;
        System.out.println("Play with rock");
    }

    public void PolishRock() {
        hunger--;
        boredom--;
        energy++;
        polishRockCounter++;
        System.out.println("polish rock");
    }

    public void UpdateMood() {
        System.out.println("Name: " + this.name);
        System.out.println("Mood: " + this.mood);
        System.out.println("Hunger: " + this.hunger);
        System.out.println("Boredom: " + this.boredom);
        System.out.println("Energy: " + this.energy);
    }
}
