import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemigoRapido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemigoRapido extends Enemigo
{
    /**
     * Act - do whatever the EnemigoRapido wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int velocidad;
    private int frecuenciaDisparo;
    
    public EnemigoRapido()
    {
        velocidad = 5;
        vida = 1;
        frecuenciaDisparo = 65;
    }
}
