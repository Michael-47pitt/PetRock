package cs1736.petrock;

public class PetRockManager {

    //Variables 
    boolean canFeedRock = true;
    boolean canPlayRock = true;
    boolean actionTaken = true;
    int polishRockCounter = 0;

    //Methods
    public void FeedRock(PetRock p) {
        if (canFeedRock == true) {
            int petRockHunger = p.getHunger();
            int petRockEnergy = p.getEnergy();
            p.setHunger(petRockHunger--);
            p.setEnergy(petRockEnergy--);
            System.out.println("Rock Fed");
        } 
        else {
            System.out.println("Cannot Feed Rock This Turn");
        }
        updateCanFeedRock();
    }

    public void PlayWithRock(PetRock p) {
        if (canPlayRock == true) {
            int petRockEnergy = p.getEnergy();
            int petRockBoredom = p.getBoredom();
            int newEnergy = petRockEnergy - 2;
            int newBoredom = petRockBoredom - 3;
            p.setEnergy(newEnergy);
            p.setBoredom(newBoredom);
            System.out.println("Play with rock");
        }
        else {
            System.out.println("Cannot Play Rock This Turn");
        }
        updateCanPlayRock();
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
        updateActionTaken();
    }

    public void updateCanFeedRock() {
        if (canFeedRock == true) {
            canFeedRock = false;
        } 
        else {
            canFeedRock = true;
        }
    }

    public void updateCanPlayRock() {
        if (canPlayRock == true) {
            canPlayRock = false;
        } 
        else {
            canFeedRock = true;
        }
    }

    public void updateActionTaken() {
        if (actionTaken == true){
            actionTaken = false;
        }
        else {
            actionTaken = true;
        }
    }

    public void updateTimeSimulation(PetRock p) {
        int hunger = p.getHunger();
        int boredom= p.getBoredom();
        int energy = p.getEnergy();
        hunger = hunger++;
        boredom = boredom++;
        if (actionTaken == false){
            energy = energy++;
        }
        p.setHunger(hunger);
        p.setBoredom(boredom);
        p.setEnergy(energy);
    }
    

    public void moodCalculation(PetRock p){
        int hunger = p.getHunger();
        int boredom = p.getBoredom();
        int energy = p.getEnergy();
        
        if (energy <= 2){
            p.setMood("Tired");
        }
        else if (hunger > 7 || boredom > 7 || energy <= 3){
            p.setMood("Sad");
        }
        else if ( (hunger >= 4 && hunger <= 7) || (boredom >= 4 && boredom <= 7) && energy > 3){
            p.setMood("Bored");
        }
    }
    public void RandomEvent(PetRock p){
	int eventOccurs = (int)(Math.random() * 100);
	if(eventOccurs < 25){
		
            int eventSelector = (int)(Math.random() * 100);
            if(eventSelector < 25){
                    System.out.println("Your rock fell down a mountain. Energy decreased.");
                    int newEnergy = p.getEnergy() - 1;
                    p.setEnergy(newEnergy);
            }
            else if(eventSelector < 50){
                    System.out.println("Your rock got scared by a sudden noise. Boredom increased.");
                    int newBoredom = p.getBoredom() + 1;
                    p.setBoredom(newBoredom);
            }
            else if(eventSelector < 75){
                    System.out.println("Your rock found a honey baked ham! Hunger decreased.");
                    int newHunger = p.getHunger() - 1;
                    p.setHunger(newHunger);
            }
            else if(eventSelector < 100){
                    System.out.println("Your rock found a good movie to watch. Boredom decreased.");
                    int newBoredom = p.getBoredom() - 1;
                    p.setBoredom(newBoredom);
            }
	}
    }
}
