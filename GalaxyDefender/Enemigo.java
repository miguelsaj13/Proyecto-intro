import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemigo extends Actor
{
    /**
     * Act - do whatever the Enemigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int velocidad = 2;

    // Contador para controlar disparos
    private int contadorDisparo = 0;

    public void act()
    {
        mover();
        disparar();
    }

    public void mover()
    {
        setLocation(getX(), getY() + velocidad);
        if(getY() > getWorld().getHeight())
        {
            getWorld().removeObject(this);
        }
    }

    public void disparar()
    {
        contadorDisparo++;

        // Dispara cada cierto tiempo
        if(contadorDisparo >= 80)
        {
            DisparoEnemigo disparo = new DisparoEnemigo();

            getWorld().addObject(disparo, getX(), getY() + 20);

            contadorDisparo = 0;
        }
    }
}
