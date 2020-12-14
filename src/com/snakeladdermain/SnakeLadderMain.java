package com.snakeladdermain;

import static java.lang.System.exit;
import java.util.Random;
import java.util.Scanner;

class SnakeLadderPlay
{
    int player = 0;
    
    public int rollDice()
    {
        int maxDiceValue = 6;
        int minDiceValue = 1;
        
        Random randomValue = new Random();
        int diceValue = randomValue.nextInt((maxDiceValue - minDiceValue) + 1) + minDiceValue;
        System.out.println("DICE VALUE : "+diceValue);
        
        return diceValue;
    }
    
    public void startToPlay()
    {
        System.out.println("Initial position of player : "+player);
    }
}

public class SnakeLadderMain 
{
    public static void main(String[] args) 
    {
        System.out.println("* * * WELCOME TO SNAKE AND LADDER GAME * * *");
        
        Scanner scannerInput = new Scanner(System.in);
        SnakeLadderPlay playObject = new SnakeLadderPlay();
        
        int temp = 1;
        while(temp > 0)
        {
            System.out.println("1.ROLL 2.GETDICEVALUE 3.EXIT");
            int opt = scannerInput.nextInt();
            switch(opt)
            {
                case 1: playObject.startToPlay();
                break;
                
                case 2: playObject.rollDice();
                break;
                
                case 3: exit(0);
                break;
                
                default: System.out.println("Invalid Option");
                break;
            }
        }
    }
}
