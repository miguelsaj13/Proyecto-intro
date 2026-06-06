import greenfoot.*;

public class Disparo extends Actor {
    
    //Velocidad con la que el disparo se mueve
    private int velocidad = 10;
    
    public Disparo(){
        GreenfootImage img = new GreenfootImage(5, 20);
        Greenfoot.playSound("Disparo.wav");
        img.setColor(Color.CYAN);
    
        img.fill();
    
        setImage(img);
    }
    
    @Override
    public void act() {
        //Función que mueve los disparos
        mover();
        //Función que verifica si el disparo conecto con el enemigo
        if (getWorld() == null) return;
        
        if(verificarColisiones())
        {
            return;
        }
        //Verifica si el disparo chocó contra el borde del mundo
        if (getWorld() == null) return;
        
        verificarBorde();
    }
    
    //Indicaciones para la función del movimiento
    private void mover() {
        //Mantiene la misma posición en X y disminuye Y para poder subir
        setLocation(getX(), getY() - velocidad);
    }
    
    //Indicaciones para la colisión de los disparos
    private boolean verificarColisiones() {
        // Detecta si el disparo tocó un enemigo
        Actor enemigo = getOneIntersectingObject(Enemigo.class);
        if (enemigo != null) {
            ((SpaceWorld) getWorld()).sumarPuntos(10);
            getWorld().removeObject(enemigo);
            getWorld().removeObject(this);
            
            //Reproducción del audio de colisión
            Greenfoot.playSound("Explosion.wav");
            return true;
        }
        return false;
    }
    
    //Indicaciones para los disparos que van hacia el borde del mundo
    private void verificarBorde() {
        // Elimina el disparo si sale de la pantalla
        World mundo = getWorld();

        if (mundo == null) {
            return;
        }

        if (getY() <= 0) {
            mundo.removeObject(this);
        }
        
    }
}
