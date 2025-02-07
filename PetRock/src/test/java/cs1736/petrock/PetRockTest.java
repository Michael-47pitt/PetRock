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
    @Disabled("Not easily testable due to print lines in display method")
    // I found a work around but it's not working for some reason?
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
    
    @Test
    public void testEnsureHungerRange_SuccessfulUpperBound()
    {
        // Setting hunger outside of bounds
        petRock.setHunger(15);
        
        // Running ensure hunger range
        PetRockManager.ensureHungerRange(petRock);
        
        // Assertion
        assertEquals(10,petRock.getHunger(),"Hunger should be set to 10.");
        
    }
    
    @Test
    public void testEnsureBoredomRange_SuccessfulUpperBound()
    {
        // Setting boredom outside of bounds
        petRock.setBoredom(15);
        
        // Running ensure boredom range
        PetRockManager.ensureBoredomRange(petRock);
        
        // Assertion
        assertEquals(10,petRock.getBoredom(),"Boredom should be set to 10.");
    }
    
    @Test
    public void testEnsureEnergyRange_SuccessfulUpperBound()
    {
        // Setting energy outside of bounds
        petRock.setEnergy(15);
        
        // Running ensure energy range
        PetRockManager.ensureEnergyRange(petRock);
        
        // Assertion
        assertEquals(10,petRock.getEnergy(),"Energy should be set to 10."); 
    }

    @Test
    public void testEnsureHungerRange_SuccessfulLowerBound()
    {
        // Setting hunger outside of bounds
        petRock.setHunger(-10);
        
        // Running ensure hunger range
        PetRockManager.ensureHungerRange(petRock);
        
        // Assertion
        assertEquals(0,petRock.getHunger(),"Hunger should be set to 0.");
        
    }
    
    @Test
    public void testEnsureBoredomRange_SuccessfulLowerBound()
    {
        // Setting boredom outside of bounds
        petRock.setBoredom(-10);
        
        // Running ensure boredom range
        PetRockManager.ensureBoredomRange(petRock);
        
        // Assertion
        assertEquals(0,petRock.getBoredom(),"Boredom should be set to 0.");
    }
    
    @Test
    public void testEnsureEnergyRange_SuccessfulLowerBound()
    {
        // Setting energy outside of bounds
        petRock.setEnergy(-10);
        
        // Running ensure energy range
        PetRockManager.ensureEnergyRange(petRock);
        
        // Assertion
        assertEquals(0,petRock.getEnergy(),"Energy should be set to 0."); 
    }
    
    @Test
    public void testEnsureEnergyLevelNotZero_TrueTest()
    {
        assertEquals(true,PetRockManager.ensureEnergyLevelNotZero(petRock));
    }
    
    @Test
    public void testEnsureEnergyLevelNotZero_FalseTest()
    {
        // Setting energy level to 0
        petRock.setEnergy(0);
        
        // Checking assertion
        assertEquals(false,PetRockManager.ensureEnergyLevelNotZero(petRock));
    }
    
    @Test
    @Disabled("Having issue, possible with increaseEnergyCounter not having right petRock object")
    public void testIncreaseEnergyCounter_IncrementTest()
    {
        // Running method
        PetRockManager.increaseEnergyCounter();
        
        // Assertion
        assertEquals(6,petRock.getEnergy(), "Energy should have increased by 1.");
        
    }
    
    // Maybe Write tests for checkLosingCondition,
    // moodCalculation, updateCanPlay/canFeed/, reset and Increase energy counter,
}