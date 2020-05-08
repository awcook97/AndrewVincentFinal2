import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Actor
{
    private int speed;
    private int timeCounter = 0;
    private boolean clicked = false;
    GreenfootImage explode = new GreenfootImage("explosion.png");
    GreenfootSound explodeSound = new GreenfootSound("explode.wav");
    public Bomb() {
        speed = Greenfoot.getRandomNumber(3) + 1;
    }
    
    public void act() {
        if (!clicked) {
            setLocation(getX(), getY()+speed);
            turn(1);
        }
        if (getY() >= 599) 
        {
            MyWorld myworld = (MyWorld)getWorld();
            myworld.removeObject(this);
        }
        if (Greenfoot.mouseClicked(this)) {
            setImage(explode);
            clicked = true;
            MyWorld myworld = (MyWorld)getWorld();
            myworld.addLuckPoints(-30);
            if (!explodeSound.isPlaying()) {
                explodeSound.play();
            }
        }
        if (clicked) {
            if (timeCounter < 10) {
                timeCounter++;
                explode.scale(explode.getWidth() + 15, explode.getHeight() + 15);
            } else {
                MyWorld myworld = (MyWorld)getWorld();
                if (explodeSound.isPlaying()) {
                    explodeSound.stop();
                }
                myworld.removeObject(this);
            }
        }
    }    
}
