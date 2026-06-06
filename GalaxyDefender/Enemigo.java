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
    protected int velocidad = 2;
    protected int vida = 1;
    protected int frecuenciaDisparo = 80;

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
        GreenfootImage img = getImage();

        if(getY() + img.getHeight()/2 >= getWorld().getHeight())
        {
            ((SpaceWorld)getWorld()).perderVida();
            getWorld().removeObject(this);
        }
    }

    public void disparar()
    {
        contadorDisparo++;

        // Dispara cada cierto tiempo
        if(contadorDisparo >= frecuenciaDisparo)
        {
            DisparoEnemigo disparo = new DisparoEnemigo();

            getWorld().addObject(disparo, getX(), getY() + 20);

            contadorDisparo = 0;
        }
    }
    
    public void recibirDanio()
    {
        vida--;
    
        if(vida <= 0)
        {
            ((SpaceWorld)getWorld()).sumarPuntos(10);
            getWorld().removeObject(this);
        }
    }
}
