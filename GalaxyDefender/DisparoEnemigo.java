import greenfoot.*;

public class DisparoEnemigo extends Actor {
    
    private int velocidad = 5;
    
    @Override
    public void act() {
        mover();
        verificarColision();
        verificarBorde();
    }
    
    private void mover() {
        setLocation(getX(), getY() + velocidad);
    }
    
    private void verificarColision() {
        // Detecta si el disparo enemigo tocó al jugador
        Actor jugador = getOneIntersectingObject(Jugador.class);
        if (jugador != null) {
            ((GalaxyWorld) getWorld()).perderVida();
            getWorld().removeObject(this);
        }
    }
    
    private void verificarBorde() {
        if (getY() > getWorld().getHeight()) {
            getWorld().removeObject(this);
        }
    }
}
