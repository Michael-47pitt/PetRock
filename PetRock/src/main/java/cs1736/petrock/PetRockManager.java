package cs1736.petrock;

public class PetRockManager {

    //Variables 
    boolean canFeedRock = true;
    boolean canPlayRock = true;
    int polishRockCounter = 0;

    //Methods
    public void FeedRock(PetRock p) {
        if (canFeedRock == true) {
            int petRockHunger = p.getHunger();
            int petRockEnergy = p.getEnergy();
            p.setHunger(petRockHunger--);
            p.setEnergy(petRockEnergy--);
            System.out.println("Rock Fed");
            canFeedRock = false;
        }
        else {
            System.out.println("Cannot Feed Rock This Turn");
        }
    }

    public void PlayWithRock(PetRock p) {
        int petRockEnergy = p.getEnergy();
        int petRockBoredom = p.getBoredom();
        int newEnergy = petRockEnergy - 2;
        int newBoredom = petRockBoredom - 3;
        p.setEnergy(newEnergy);
        p.setBoredom(newBoredom);
        System.out.println("Play with rock");
    }

    public void PolishRock(PetRock p) {
        int petRockHunger = p.getHunger();
        int petRockBoredom = p.getBoredom();
        int petRockEnergy = p.getEnergy();
        int newHunger = petRockHunger - 1;
        int newBoredom = petRockBoredom - 1;
        int newEnergy = petRockEnergy + 1;
        p.setHunger(newHunger);
        p.setBoredom(newBoredom);
        p.setEnergy(newEnergy);
        
        polishRockCounter++;
        System.out.println("polish rock");
    }

    public void UpdateMood(PetRock p) {
        System.out.println("Name: " + p.getName());
        System.out.println("Mood: " + p.getMood());
        System.out.println("Hunger: " + p.getHunger());
        System.out.println("Boredom: " + p.getBoredom());
        System.out.println("Energy: " + p.getEnergy());
    }
}
