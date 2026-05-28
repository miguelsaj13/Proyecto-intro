import greenfoot.*;

public class DisparoEnemigo extends Actor {
    
    //Indica la velocidad del disparo del enemigo
    private int velocidad = 5;
    
    public DisparoEnemigo(){
        GreenfootImage img = new GreenfootImage(5, 20);
    
        img.setColor(new Color(255,0,0));
    
        img.fill();
    
        setImage(img);
    }
    
    @Override
    public void act() {
        
        //Función que mueve el disparo hacia abajo
        mover();
        //Verifica si el disparo salió y toca el borde
        verificarBorde();
        verificarColision();
    }

    //Indicacaciones para el movimiento de los disparos
    private void mover() {
        //Mantiene la posición en X y aumenta Y para que el disparo baje
        setLocation(getX(), getY() + velocidad);
        //Reproducción del audio de disparo
        Greenfoot.playSound("Disparo.wav");
    }
    
    //Indicaciones de colisión con jugador
    
    private void verificarColision() {
        // Detecta si el disparo enemigo tocó al jugador
        Actor jugador = getOneIntersectingObject(Player.class);
        if (jugador != null) {
            ((SpaceWorld) getWorld()).perderVida();
            getWorld().removeObject(this);
        }
    }
    
    //Indicaciones para cuando el disparo toque el borde de la pantalla
    private void verificarBorde() {
        //Si el disparo toca el borde inferior elimina el disparo
        if (getY() > getWorld().getHeight()) {
            getWorld().removeObject(this);
        }
    }
}
