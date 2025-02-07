package cs1736.petrock;

public class PetRockManager
{

    //Variables 
    static boolean canFeedRock = true;
    static boolean canPlayRock = true;
    static boolean actionTaken = true;
    static int polishRockCounter = 0;
    static int energyAtZeroCounter = 0;

    //Methods
    public static void FeedRock(PetRock p)
    {
        boolean energyLevel = ensureEnergyLevelNotZero(p);
        if (energyLevel)
        {
            resetEnergyCounter();
            if (canFeedRock)
            {
                p.setHunger(p.getHunger() - 2);
                p.setEnergy(p.getEnergy() - 1);
                p.setBoredom(p.getBoredom() + 1);
                RandomEvent(p);
                System.out.println("Rock Fed");
            } 
            else
            {
                System.out.println("Cannot Feed Rock This Turn Due To Feeding It Last Turn");
            }
        } 
        else
        {
            System.out.println("Cannot Feed Rock This Turn Due To Low Energy");
            increaseEnergyCounter();
        }
        updateCanFeedRock();
        actionTaken = true;
        resetPolishCounter();
    }

    public static void PlayWithRock(PetRock p)
    {
        boolean energyLevel = ensureEnergyLevelNotZero(p);
        if (energyLevel)
        {
            resetEnergyCounter();
            if (canPlayRock)
            {
                p.setEnergy(p.getEnergy() - 2);
                p.setBoredom(p.getBoredom() - 3);
                p.setHunger(p.getHunger() + 1);
                RandomEvent(p);
                System.out.println("Played with rock");
            }
            else
            {
                System.out.println("Cannot Play Rock This Turn Due To Playing Last Turn");
            }
        }
        else
        {
            System.out.println("Cannot Play Rock This Turn Due To Low Energy");
            increaseEnergyCounter();
        }
        updateCanPlayRock();
        actionTaken = true;
        resetPolishCounter();
    }

    public static void PolishRock(PetRock p)
    {
        boolean energyLevel = ensureEnergyLevelNotZero(p);
        if (energyLevel == true)
        {
            if (polishRockCounter <= 3)
            {
                resetEnergyCounter();
                p.setHunger(p.getHunger() - 1);
                p.setBoredom(p.getBoredom() - 1);
                p.setEnergy(p.getEnergy() + 1);
            }
            else if (polishRockCounter <= 5)
            {
                p.setHunger(p.getHunger() - 1);
                p.setBoredom(p.getBoredom() - 1);
                System.out.println("Your rock is tired of being polished! Energy was not restored");
            }
            else
            {
                p.setHunger(p.getHunger() - 1);
                System.out.println("Your rock is getting bored! Boredom was not lowered.");
            }

            polishRockCounter++;
            System.out.println("Polish rock");
        }
        actionTaken = true;
        RandomEvent(p);
    }

    public static void DisplayStatus(PetRock p)
    {
        System.out.println("Name: " + p.getName());
        System.out.println("Mood: " + p.getMood());
        System.out.println("Hunger: " + p.getHunger());
        System.out.println("Boredom: " + p.getBoredom());
        System.out.println("Energy: " + p.getEnergy());
        actionTaken = false;
        resetPolishCounter();
    }

    private static void updateCanFeedRock()
    {
        canFeedRock = !canFeedRock;
    }

    private static void updateCanPlayRock()
    {
        canPlayRock = !canPlayRock;
    }
    
    private static void increaseEnergyCounter()
    {
        energyAtZeroCounter++;
    }
    
    private static void resetEnergyCounter()
    {
        energyAtZeroCounter = 0;
    }
    
    private static void resetPolishCounter()
    {
        polishRockCounter = 0;
    }

    public static void updateTimeSimulation(PetRock p)
    {
        if (!actionTaken)
        {
            p.setEnergy(p.getEnergy() + 1);
            resetEnergyCounter();
        }
        p.setHunger(p.getHunger() + 1);
        p.setBoredom(p.getBoredom() + 1);
        ensureEnergyRange(p);
        ensureHungerRange(p);
        ensureBoredomRange(p);
        checkLosingConditions(p);
    }

    public static void moodCalculation(PetRock p)
    {
        int hunger = p.getHunger();
        int boredom = p.getBoredom();
        int energy = p.getEnergy();

        if (energy <= 2)
        {
            p.setMood("Tired");
        } 
        else if (hunger > 7 || boredom > 7 || energy <= 3)
        {
            p.setMood("Sad");
        } 
        else if ((hunger >= 4 && hunger <= 7) || (boredom >= 4 && boredom <= 7) && energy > 3)
        {
            p.setMood("Bored");
        } 
        else if (hunger < 4 && boredom < 4 && energy > 3)
        {
            p.setMood("Happy");
        }
    }

    private static void RandomEvent(PetRock p)
    {
        int eventOccurs = (int) (Math.random() * 100);
        if (eventOccurs < 25)
        {

            int eventSelector = (int) (Math.random() * 100);
            if (eventSelector < 25)
            {
                System.out.println("Your rock found a shiny pebble! It's happier now!");
                if (p.getHunger() > 4)
                {
                    p.setHunger(3);
                }
                else
                {
                    p.setHunger(p.getHunger() - 1);
                }
                if (p.getBoredom() > 4)
                {
                    p.setBoredom(3);
                }
                else
                {
                    p.setBoredom(p.getBoredom() - 1);
                }
                if (p.getEnergy() < 4)
                {
                    p.setEnergy(4);
                }
                else
                {
                    p.setEnergy(p.getEnergy() + 2);
                }
            }
            else if (eventSelector < 50)
            {
                System.out.println("Your rock got some extra sleep! Energy restored!");
                p.setEnergy(p.getEnergy() + 2);
            } 
            else if (eventSelector < 75)
            {
                System.out.println("Your rock was scared by a sudden noise! Boredom increased!");
                p.setBoredom(p.getBoredom() + 2);
            } 
            else
            {
                System.out.println("Your rock is grumpy today. Hunger increased!");
                p.setHunger(p.getHunger() + 2);
            }
        }
    }

    private static boolean ensureEnergyLevelNotZero(PetRock p)
    {
        return p.getEnergy() != 0;
    }
    
    
    private static void ensureHungerRange(PetRock p)
    {
        int hunger = p.getHunger();
        if (hunger < 0)
        {
            p.setHunger(0);
        }
        if (hunger > 10)
        {
            p.setHunger(10);
        }
    }
    
    private static void ensureBoredomRange(PetRock p)
    {
        int boredom = p.getBoredom();
        if (boredom < 0)
        {
            p.setBoredom(0);
        }
        if (boredom > 10)
        {
            p.setBoredom(10);
        }
    }
    
    private static void ensureEnergyRange(PetRock p)
    {
        int energy = p.getEnergy();
        if (energy < 0)
        {
            p.setEnergy(0);
        }
        if (energy > 10)
        {
            p.setEnergy(10);
        }
    }
    
    private static void checkLosingConditions(PetRock p)
    {
        int hunger = p.getHunger();
        int boredom = p.getBoredom();
        
        if (energyAtZeroCounter == 3 || hunger == 10 || boredom == 10)
        {
            PetRock.endGame();
        }
    }
}
