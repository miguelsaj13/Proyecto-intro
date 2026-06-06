import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemigoTanque here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemigoTanque extends Enemigo
{
    /**
     * Act - do whatever the EnemigoTanque wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected int vida = 3;
    private int velocidad;
    private int frecuenciaDisparo;

    public EnemigoTanque()
    {
        velocidad = 1;
        vida = 3;
        frecuenciaDisparo = 40;
    }

    public void recibirDanio()
    {
        vida--;

        if(vida <= 0)
        {
            getWorld().removeObject(this);
        }
    }
}
