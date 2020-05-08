import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class SuperClover
 * Clicking on this will immediately win the game
 * and give you 1,000,000 points
 * @Andrew Cook & Vincent Nguyen (your name) 
 * @1.0.0 (a version number or a date)
 */
public class SuperClover extends Actor
{
    private int speed;
    private int timeCounter = 0;
    private boolean clicked = false;
    GreenfootImage shine = new GreenfootImage("shine.png");
    public SuperClover() {
        speed = Greenfoot.getRandomNumber(2) + 1;
    }
    
    public void act() {
        fall();
        checkClicked();
    }
    public void fall() {
        if (!clicked) {
            setLocation(getX(), getY()+speed);
            turn(1);
        }
        if (getY() >= 599) 
        {
            MyWorld myworld = (MyWorld)getWorld();
            myworld.removeObject(this);
            
        }
    }
    public void checkClicked() {
        if (Greenfoot.mouseClicked(this)) {
            setImage(shine);
            clicked = true;
            MyWorld myworld = (MyWorld)getWorld();
            myworld.addLuckPoints(1000000);
        }
        if (clicked) {
            if (timeCounter < 10) {
                timeCounter++;
                shine.scale(shine.getWidth()+50, shine.getHeight()+5);
            } else {
                MyWorld myworld = (MyWorld)getWorld();
                myworld.removeObject(this);
            }
        }
    }
}
