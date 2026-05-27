import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public void act()
    {
        movePlayer();
    }

    public void movePlayer()
    {
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            move(-4);
        }

        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            move(4);
        }

        if(getX() < 50)
        {
            setLocation(50, getY());
        }

        if(getX() > getWorld().getWidth() - 50)
        {
            setLocation(getWorld().getWidth() - 50, getY());
        }
    }
}

