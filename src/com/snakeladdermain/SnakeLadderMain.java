package com.snakeladdermain;

import static java.lang.System.exit;
import java.util.Random;
import java.util.Scanner;

class SnakeLadderPlay
{
    Scanner scanInput = new Scanner(System.in);
    int player = 0;
    int player2 = 0;
    final int WINPOINT = 10;
    int count = 0;
    int count2 = 0;
    
    public int snakeOrLadder()
    {
        int tmaxDiceValue = 5;
        int tminDiceValue = 1;
        
        Random trandomValue = new Random();
        int value = trandomValue.nextInt((tmaxDiceValue - tminDiceValue) + 1) + tminDiceValue;
        
        return value;
    }
    
    public int calculatePlayerValue(int playerr, int diceValuee)
    {
        
        //player = player + diceValue;
        int tempRandomValue = snakeOrLadder();
        
        if(tempRandomValue == 5)
        {
            System.out.println("- - swallowed by snake - -");
            playerr = playerr - diceValuee;
            if(playerr < 0)
            {
                playerr = 0;
                System.out.println("Player restart from zero");
                return playerr;
            }
        }
        else
        {
            System.out.println("- - climb up the ladder - -");
            playerr = playerr + diceValuee;
        }
        
        if(playerr > WINPOINT)
        {
            playerr = playerr - diceValuee;
            return playerr;
        }
        
        return playerr;
    }
    
    
    public int rollDice()
    {
        int maxDiceValue = 6;
        int minDiceValue = 1;
        
        Random randomValue = new Random();
        int diceValue = randomValue.nextInt((maxDiceValue - minDiceValue) + 1) + minDiceValue;
        System.out.println("DICE VALUE : "+diceValue);
        
        return diceValue;
    }
    
    public boolean isWin(int player)
    {
        return WINPOINT == player;
    }
    
    public void startToPlay()
    {
        int storeDiceValue = rollDice();
        
        System.out.println("Press r to roll Dice");
        String rollResult = scanInput.next();
        while("r".equals(rollResult))
        {
            System.out.println("1.firstplayer 2.secondpalyer");
            int currentPlayer = scanInput.nextInt();  
        
            if(currentPlayer == 1)
            {
                count++;
                player = calculatePlayerValue(player,storeDiceValue);
                System.out.println("player : "+player);
                if(isWin(player))
                {
                    System.out.println("The number of dice thrown to win game is : "+count);
                    System.out.println("player1 wins the game");
                    return;
                }
            }
            else if(currentPlayer == 2)
            {
                count2++;
                player2 = calculatePlayerValue(player2,storeDiceValue);
                System.out.println("player2 : "+player2);
                if(isWin(player2))
                {
                    System.out.println("The number of dice thrown to win game is : "+count2);
                    System.out.println("player2 wins the game");
                    return;
                }
            }
        break;
        }
    }
    
    void stay()
    {
        System.out.println("palyer : "+player);
        System.out.println("player2: "+player2);
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
            System.out.println("1.ROLL 2.STAY 3.GETDICEVALUE 4.EXIT");
            int opt = scannerInput.nextInt();
            switch(opt)
            {
                case 1: playObject.startToPlay();
                break;
                
                case 2: playObject.stay();
                break;
                
                case 3: playObject.rollDice();
                break;
                
                case 4: exit(0);
                break;
                
                default: System.out.println("Invalid Option");
                break;
            }
        }
    }
}
