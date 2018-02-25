/**
 * A class that simulates a dice
 * 
 * @Team MAGA
 * @Author Gajun Young - 16440714
 * @Author Royal Thomas - 16326926
 * @Author Richard  Otroshchenko
 */

import java.util.Random;

public class Dice {
    private Random rand = new Random();
    private int numSides = 6;
    private int roll1, roll2;

    public Dice(){}

    //Method to roll the dice
    public void rollDice() {
        roll1 = rand.nextInt(numSides) + 1;
        roll2 = rand.nextInt(numSides) + 1;
    }

    //Method to display the roll result
    public int getRoll1() {
        return roll1;
    }
    public int getRoll2(){
        return roll2;
    }
}
