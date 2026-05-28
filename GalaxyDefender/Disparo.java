import greenfoot.*;

public class Disparo extends Actor {
    
    //Velocidad con la que el disparo se mueve
    private int velocidad = 10;
    
    @Override
    public void act() {
        //Función que mueve los disparos
        mover();
        //Función que verifica si el disparo conecto con el enemigo
        verificarColisiones();
        //Verifica si el disparo chocó contra el borde del mundo
        verificarBorde();
    }
    
    //Indicaciones para la función del movimiento
    private void mover() {
        //Mantiene la misma posición en X y disminuye Y para poder subir
        setLocation(getX(), getY() - velocidad);
        //Reproducción del audio de disparo
        Greenfoot.playSound("Disparo.wav");
    }
    
    //Indicaciones para la colisión de los disparos
    private void verificarColisiones() {
        // Detecta si el disparo tocó un enemigo
        Actor enemigo = getOneIntersectingObject(Enemigo.class);
        if (enemigo != null) {
            // Notifica al mundo para sumar puntos
            ((GalaxyWorld) getWorld()).sumarPuntos(10);
            getWorld().removeObject(enemigo);
            getWorld().removeObject(this);
            
            //Reproducción del audio de colisión
            Greenfoot.playSound("Explosion.wav");
        }
    }
    
    //Indicaciones para los disparos que van hacia el borde del mundo
    private void verificarBorde() {
        // Elimina el disparo si sale de la pantalla
        if (getY() < 0) {
            getWorld().removeObject(this);
        }
    }
}
