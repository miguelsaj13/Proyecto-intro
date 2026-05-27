import greenfoot.*;

//Clase principal del mundo en el que se jugará
//Se está definiendo el espacio donde aparecen los diferentes objetos y el jugador
public class SpaceWorld extends World
{
    //Aquí se indican el tamaño y aparición del jugador
    public SpaceWorld()
    {    
        //Se crea el mundo con las dimensiones definidas
        super(800, 600, 1);

        //Se agrega el jugador en la posición indicada
        addObject(new Player(), 400, 500);
    }
}