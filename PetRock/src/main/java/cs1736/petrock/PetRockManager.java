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
        hunger--;
        boredom--;
        energy++;
        polishRockCounter++;
        System.out.println("polish rock");
    }

    public void UpdateMood(PetRock p) {
        System.out.println("Name: " + this.name);
        System.out.println("Mood: " + this.mood);
        System.out.println("Hunger: " + this.hunger);
        System.out.println("Boredom: " + this.boredom);
        System.out.println("Energy: " + this.energy);
    }
}
