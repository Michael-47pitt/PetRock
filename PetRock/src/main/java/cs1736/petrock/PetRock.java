package cs1736.petrock;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.File;

public class PetRock
{

    //Variables 
    String name;
    String mood;
    int hunger;
    int boredom;
    int energy;
    private static PetRock instance = null;

    //Constructor 
    private PetRock()
    {
        hunger = 5;
        boredom = 5;
        energy = 5;
        mood = "Happy";
    }
    
    public static PetRock getPetRock()
    {
        getJsonInstance();
        if (instance == null)
        {
            instance = new PetRock();
        }
        return instance;
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

    public void save()
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        try (FileWriter writer = new FileWriter("rock.json"))
        {
            gson.toJson(this, writer);
        }
        
        catch (IOException e)
        {}
    }
    
    private static void getJsonInstance()
    {
        Gson gson = new Gson();
        
        try (FileReader reader = new FileReader("rock.json"))
        {
            instance = gson.fromJson(reader, PetRock.class);
        }
        
        catch (IOException e)
        {}
    }
    
    public static void endGame()
    {
        System.out.println("Your rock has rolled away in protest! Game over.");
        File file = new File("rock.json");
        file.delete();
        System.exit(0);
    }
}
