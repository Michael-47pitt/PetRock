/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs1736.petrock;

/**
 *
 * @author nbeck
 */
public class PetRockManager {
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
