import greenfoot.*;

public class Disparo extends Actor {
    
    private int velocidad = 10;
    
    @Override
    public void act() {
        mover();
        verificarColisiones();
        verificarBorde();
    }
    
    private void mover() {
        setLocation(getX(), getY() - velocidad);
    }
    
    private void verificarColisiones() {
        // Detecta si el disparo tocó un enemigo
        Actor enemigo = getOneIntersectingObject(Enemigo.class);
        if (enemigo != null) {
            // Notifica al mundo para sumar puntos
            ((GalaxyWorld) getWorld()).sumarPuntos(10);
            getWorld().removeObject(enemigo);
            getWorld().removeObject(this);
        }
    }
    
    private void verificarBorde() {
        // Elimina el disparo si sale de la pantalla
        if (getY() < 0) {
            getWorld().removeObject(this);
        }
    }
}
