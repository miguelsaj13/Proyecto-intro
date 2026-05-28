import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    //Aquí se encuentra el metodo que se estará ejecutando
    //mientras el juego se haya iniciado
    
    //Para poder reproducir solamente una vez el audio de inicio se crea una variable boolanea
    //esto para que cuando este se haya reproducido una vez acabar la repetición
    private boolean sonidoReproducido = false;
    
    private int tiempoDisparo = 20;
    
    public void act()
    {
        if(!sonidoReproducido)
        {
        sonidoInicio();
        sonidoReproducido = true;
        }
        //Función que activas las funciones de movimiento del jugador
        movePlayer();
        disparar();

        tiempoDisparo++;
    }

    public void sonidoInicio()
    {
        //Reproducción del audio de inicio
        Greenfoot.playSound("Inicio.wav");
    }
    //Contiene las instrucciones de movimiento del jugador
    public void movePlayer()
    {
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            //Cuando el jugador presiona la tecla "a" 
            //el jugador se movera hacia la izquierda
            move(-4);
        }

        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            //Cuando el jugador presiona la tecla "d"
            //el jugador se movera hacia la izquierda
            move(4);
        }

        //Verificación para el jugador, asi no sale por el lado izquierdo de la pantalla
        if(getX() < 50)
        {
            //Limita al jugador en la posición mínima que es X = 50
            setLocation(50, getY());
        }

        //Verificación para el jugador, así este no puede salir por el lado derecho de la pantalla
        if(getX() > getWorld().getWidth() - 50)
        {
            //Limita al jugador dentro del ancho del mundo creado
            setLocation(getWorld().getWidth() - 50, getY());
        }

    }
    
    public void disparar()
    {
        if(Greenfoot.isKeyDown("space") && tiempoDisparo >= 15)
        {
            Disparo disparo = new Disparo();

            getWorld().addObject(disparo, getX(), getY() - 20);

            tiempoDisparo = 0;
        }
    }
}

