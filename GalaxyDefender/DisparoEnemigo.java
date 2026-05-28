import greenfoot.*;

public class DisparoEnemigo extends Actor {
    
    //Indica la velocidad del disparo del enemigo
    private int velocidad = 5;
    
    @Override
    public void act() {
        
        //Función que mueve el disparo hacia abajo
        mover();
        //Verifica si el disparo conecta con el jugador
        verificarColision();
        //Verifica si el disparo salió y toca el borde
        verificarBorde();
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
        Actor jugador = getOneIntersectingObject(Jugador.class);
        //Si encuentró al jugador resta una vida y elimina el disparo del enemigo
        if (jugador != null) {
            ((GalaxyWorld) getWorld()).perderVida();
            getWorld().removeObject(this);
            
            //Reproducción del audio de colisión
            Greenfoot.playSound("Explosion.wav");
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
