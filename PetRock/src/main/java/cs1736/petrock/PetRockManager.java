package cs1736.petrock;

public class PetRockManager {

    //Variables 
    static boolean canFeedRock = true;
    static boolean canPlayRock = true;
    static boolean canPolishRock = true;
    static boolean actionTaken = true;
    static int polishRockCounter = 0;
    static int energyAtZeroCounter = 0;

    //Methods
    public static void FeedRock(PetRock p) {
        boolean energyLevel = ensureEnergyLevelNotZero(p);
        if (energyLevel == true) {
            resetEnergyCounter();
            if (canFeedRock == true) {
                int petRockHunger = p.getHunger();
                int petRockEnergy = p.getEnergy();
                int petRockBoredom = p.getBoredom();
                petRockHunger = petRockHunger - 2;
                petRockEnergy--;
                petRockBoredom++;
                p.setHunger(petRockHunger);
                p.setEnergy(petRockEnergy);
                p.setBoredom(petRockBoredom);
                System.out.println("Rock Fed");
            } 
            else {
                System.out.println("Cannot Feed Rock This Turn Due To Feeding It Last Turn");
            }
        } 
        else {
            System.out.println("Cannot Feed Rock This Turn Due To Low Energy");
            increaseEnergyCounter();
        }
        updateCanFeedRock();
        actionTaken = true;
        ensureHungerRange(p);
        ensureBoredomRange(p);
        ensureEnergyRange(p);
        checkLosingConditions(p);
        resetPolishCounter();
    }

    public static void PlayWithRock(PetRock p) {
        boolean energyLevel = ensureEnergyLevelNotZero(p);
        if (energyLevel == true) {
            resetEnergyCounter();
            if (canPlayRock == true) {
                int petRockEnergy = p.getEnergy();
                int petRockBoredom = p.getBoredom();
                int petRockHunger = p.getHunger();
                int newEnergy = petRockEnergy - 2;
                int newBoredom = petRockBoredom - 3;
                petRockHunger++;
                p.setEnergy(newEnergy);
                p.setBoredom(newBoredom);
                p.setHunger(petRockHunger);
                System.out.println("Played with rock");
            }
            else {
                System.out.println("Cannot Play Rock This Turn Due To Playing Last Turn");
            }
        }
        else {
            System.out.println("Cannot Play Rock This Turn Due To Low Energy");
            increaseEnergyCounter();
        }
        updateCanPlayRock();
        actionTaken = true;
        ensureHungerRange(p);
        ensureBoredomRange(p);
        ensureEnergyRange(p);
        checkLosingConditions(p);
        resetPolishCounter();
    }

    public static void PolishRock(PetRock p) {
        boolean energyLevel = ensureEnergyLevelNotZero(p);
        int petRockHunger = p.getHunger();
        int petRockBoredom = p.getBoredom();
        int petRockEnergy = p.getEnergy();
        
        if (energyLevel == true) {
            if(polishRockCounter <= 3){
                resetEnergyCounter();
                p.setHunger(petRockHunger - 1);
                p.setBoredom(petRockBoredom - 1);
                p.setEnergy(petRockEnergy + 1);
            }
            else if(polishRockCounter <= 5){
                resetEnergyCounter();
                p.setHunger(petRockHunger - 1);
                p.setBoredom(petRockBoredom - 1);
                System.out.println("Your rock is tired of being polished. Energy was not restored.");
            }
            else{
                resetEnergyCounter();
                p.setHunger(petRockHunger - 1);
                System.out.println("Your rock is getting bored!");
            }

            polishRockCounter++;
            System.out.println("polish rock");
        }
        actionTaken = true;
        ensureHungerRange(p);
        ensureBoredomRange(p);
        ensureEnergyRange(p);
        checkLosingConditions(p);
    }

    public static void DisplayStatus(PetRock p) {
        System.out.println("Name: " + p.getName());
        System.out.println("Mood: " + p.getMood());
        System.out.println("Hunger: " + p.getHunger());
        System.out.println("Boredom: " + p.getBoredom());
        System.out.println("Energy: " + p.getEnergy());
        actionTaken = false;
        resetPolishCounter();
    }

    public static void updateCanFeedRock() {
        if (canFeedRock == true) {
            canFeedRock = false;
        } 
        else {
            canFeedRock = true;
        }
    }

    public static void updateCanPlayRock() {
        if (canPlayRock == true) {
            canPlayRock = false;
        } 
        else {
            canFeedRock = true;
        }
    }
    
    public static void increaseEnergyCounter(){
        energyAtZeroCounter++;
    }
    
    public static void resetEnergyCounter(){
        energyAtZeroCounter = 0;
    }
    
    public static void resetPolishCounter(){
        polishRockCounter = 0;
    }

    public static void updateTimeSimulation(PetRock p) {
        int hunger = p.getHunger();
        int boredom = p.getBoredom();
        int energy = p.getEnergy();
        hunger++;
        boredom++;
        if (actionTaken == false) {
            energy = energy++;
            resetEnergyCounter();
        }
        p.setHunger(hunger);
        p.setBoredom(boredom);
        p.setEnergy(energy);
        ensureEnergyRange(p);
        ensureHungerRange(p);
        ensureBoredomRange(p);
        checkLosingConditions(p);
    }

    public static void moodCalculation(PetRock p) {
        int hunger = p.getHunger();
        int boredom = p.getBoredom();
        int energy = p.getEnergy();

        if (energy <= 2) {
            p.setMood("Tired");
        } 
        else if (hunger > 7 || boredom > 7 || energy <= 3) {
            p.setMood("Sad");
        } 
        else if ((hunger >= 4 && hunger <= 7) || (boredom >= 4 && boredom <= 7) && energy > 3) {
            p.setMood("Bored");
        } 
        else if (hunger < 4 && boredom < 4 && energy > 3) {
            p.setMood("Happy");
        }
    }

    public static void RandomEvent(PetRock p) {
        int eventOccurs = (int) (Math.random() * 100);
        if (eventOccurs < 25) {

            int eventSelector = (int) (Math.random() * 100);
            if (eventSelector < 25) {
                System.out.println("Your rock found a shiny pebble! It's happier now!");
                if(p.getHunger() > 4){
                    p.setHunger(3);
                }
                else{
                    p.setHunger(p.getHunger() - 1);
                }
                if(p.getBoredom() > 4){
                    p.setBoredom(3);
                }
                else{
                    p.setBoredom(p.getBoredom() - 1);
                }
                if(p.getEnergy() < 4){
                    p.setEnergy(4);
                }
                else{
                    p.setEnergy(p.getEnergy() + 2);
                }
            }
            else if (eventSelector < 50) {
                System.out.println("Your rock got some extra sleep! Energy restored!");
                p.setEnergy(p.getEnergy() + 2);
            } 
            else if (eventSelector < 75) {
                System.out.println("Your rock is scared by a sudden noise! Boredom increased!");
                p.setBoredom(p.getBoredom() + 2);
            } 
            else if (eventSelector < 100) {
                System.out.println("Your rock is grumpy today. Hunger increased!");
                p.setHunger(p.getHunger() + 2);
            }
        }
    }

    public static boolean ensureEnergyLevelNotZero(PetRock p) {
        int rockEnergyLevel = p.getEnergy();
        if (rockEnergyLevel == 0) {
            return false;
        } 
        else {
            return true;
        }
    }
    
    
    public static void ensureHungerRange(PetRock p){
        int hunger = p.getHunger();
        if (hunger < 0){
            p.setHunger(0);
        }
        if (hunger > 10){
            p.setHunger(10);
        }
    }
    
    public static void ensureBoredomRange(PetRock p){
        int boredom = p.getBoredom();
        if (boredom < 0){
            p.setBoredom(0);
        }
        if (boredom > 10) {
            p.setBoredom(10);
        }
    }
    
    public static void ensureEnergyRange(PetRock p){
        int energy = p.getEnergy();
        if (energy < 0){
            p.setEnergy(0);
        }
        if (energy > 10){
            p.setEnergy(10);
        }
    }
    
    public static void checkLosingConditions(PetRock p){
        int hunger = p.getHunger();
        int boredom = p.getBoredom();
        
        if (energyAtZeroCounter == 3 || hunger == 10 || boredom == 10){
            System.out.println("Your rock has rolled away in protest! Game Over");
            PetRock.endGame();
        }
    }
}
