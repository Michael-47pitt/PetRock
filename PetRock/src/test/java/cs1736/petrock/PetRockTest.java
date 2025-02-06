package cs1736.petrock;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PetRockTest {

    private PetRock petRock;

    // Initialization
    @BeforeEach
    public void setUp() {
        petRock = PetRock.getPetRock(); 
        petRock.setHunger(5);
        petRock.setEnergy(5);
        petRock.setBoredom(5);
    }
    
    @Test
    public void testFeedRock_SuccessfulFeed() 
    {   
        // Performing feed
        PetRockManager.FeedRock(petRock);

        // Checking expected values
        assertEquals(3, petRock.getHunger(), "Hunger should decrease by 2 after feeding");
        assertEquals(4, petRock.getEnergy(), "Energy should decrease by 1 after feeding");
        assertEquals(6, petRock.getBoredom(), "Boredom should increase by 1 after feeding");
    }
    
    @Test
    public void testPlayWithRock_SuccessfulPlay()
    {   
        // Performing play
        PetRockManager.PlayWithRock(petRock);
        
        // Checking expected values
        assertEquals(6, petRock.getHunger(), "Hunger should increase by 1 after playing");
        assertEquals(3, petRock.getEnergy(), "Energy should decrease by 2 after playing");
        assertEquals(2, petRock.getBoredom(), "Boredom should decrease by 3 after playing");
    }
    
    @Test
    public void testPolishRock_SuccessfulPolish()
    {
        // Performing play
        PetRockManager.PolishRock(petRock);
        
        // Checking expected values
        assertEquals(4, petRock.getHunger(), "Hunger should decrease by 1 after polishing");
        assertEquals(6, petRock.getEnergy(), "Energy should increase by 1 after polishing");
        assertEquals(4, petRock.getBoredom(), "Boredom should decrease by 1 after polishing");   
    }
    
    @Test
    //@Disabled("Not easily testable due to print lines in display method")
    public void testDisplayStatus_SuccessfulDisplay()
    {
        // Setting expected output 
        String expectedOutput=
        "Name: null\n" +
        "Mood: " + petRock.getMood() + "\n" +
        "Hunger: 5\n" +
        "Boredom: 5\n" +
        "Energy: 5\n";
        
        // Capturing output
        ByteArrayOutputStream printOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(printOut));
        
        // Performing Display
        PetRockManager.DisplayStatus(petRock);
        
        // Restoring systemout to System out instead of print out
        System.setOut(System.out);
        
        // Checking expected values
        assertEquals(expectedOutput,printOut.toString()); // Problem here, the expected and actual seem to be equivalent but JUnit doesn't see it that way?
    }
}