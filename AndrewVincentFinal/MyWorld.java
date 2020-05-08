import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int luckPoints;
    private int time;
    GreenfootSound backgroundMusic = new GreenfootSound("backgroundMusic.wav");
    //GreenfootSound 
    public MyWorld() {    
        super(800, 600, 1);
        luckPoints = 0;
        time = 1000;
        showLuckPoints();
        showTime();
    }
    
    public void act () {
        if (Greenfoot.getRandomNumber(100) < 2) {
            addObject(new Clover(), Greenfoot.getRandomNumber(800), 0);
        }
        if (Greenfoot.getRandomNumber(100) < 1) {
            addObject(new Bomb(), Greenfoot.getRandomNumber(800), 0);
        }
        if (Greenfoot.getRandomNumber(1000000) < 1) {
            addObject(new SuperClover(), Greenfoot.getRandomNumber(800), 0);
        }
        if (!backgroundMusic.isPlaying()) {
            backgroundMusic.playLoop();
            backgroundMusic.setVolume(25);
        }
        countTime();
    }
    
    public void addLuckPoints(int points) {
        luckPoints += points;
        showLuckPoints();
        if (luckPoints < 0) {
            showEndMessage();
            Greenfoot.stop();
        }
        if (luckPoints >= 1000000) {
            showEndMessage();
            Greenfoot.stop();
        }
    }
    
    public void showLuckPoints() {
        showText("Luck Points: " + luckPoints, 90, 25);
    }
    
    public void countTime() {
        time--;
        showTime();
        if (time == 0) {
            showEndMessage();
            Greenfoot.stop();
        }
    }
    
    public void showTime() {
        showText("Time: " + time, 735, 25);
    }
    
    public void showEndMessage() {
        if (luckPoints >= 1000000) {
            showText("You are the luckiest person alive!", 400, 300);
            showText(luckPoints + " Luck points", 400, 330);
        } else if (luckPoints >= 100) {
            showText("You win! You are now very lucky.", 400, 300);
            showText(luckPoints + " Luck points", 400, 330);
        } else if (luckPoints < 0) {
            showText("Game Over.", 400, 300);
        } else {
            showText("Time is up, you gathered:", 400, 300);
            showText(luckPoints + " Luck points", 400, 330);
        }
        backgroundMusic.stop();
    }
}