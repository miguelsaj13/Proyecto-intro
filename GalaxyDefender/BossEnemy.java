import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossEnemy extends Enemigo
{
    /**
     * Act - do whatever the BossEnemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int velocidad;
    private int direccion;
    private int vida;
    private int frecuenciaDisparo;
    private int contadorDisparos;

    public BossEnemy()
    {
        direccion = 3;
        vida = 50;
        frecuenciaDisparo = 20;

    }
    
    @Override

    public void act()
    {
        moverBoss();
        disparar();
    }

    private void moverBoss()
    {
        setLocation(getX() + direccion, getY());

        if(getX() < 100 || getX() > getWorld().getWidth() - 100)
        {
            direccion *= -1;
        }
    }
    
    public void recibirDanio()
    {
        vida--;

        if(vida <= 0)
        {
            ((SpaceWorld)getWorld()).sumarPuntos(200);
            getWorld().removeObject(this);
        }
    }

}
