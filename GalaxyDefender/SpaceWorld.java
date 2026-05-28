import greenfoot.*;

//Clase principal del mundo en el que se jugará
//Se está definiendo el espacio donde aparecen los diferentes objetos y el jugador
public class SpaceWorld extends World
{
    private int contadorEnemigos = 0;
    
    //Aquí se indican el tamaño y aparición del jugador
    public SpaceWorld()
    {    
        //Se crea el mundo con las dimensiones definidas
        super(800, 600, 1);

        //Se agrega el jugador en la posición indicada
        addObject(new Player(), 400, 500);
    }
    
    public void act()
    {
        generarEnemigos();
    }
    
    public void generarEnemigos()
    {
        contadorEnemigos++;

        // Genera un enemigo cada cierto tiempo
        if(contadorEnemigos >= 100)
        {
            int x = Greenfoot.getRandomNumber(getWidth());

            addObject(new Enemigo(), x, 50);

            contadorEnemigos = 0;
        }
    }
    
    // Método para sumar puntos
    public void sumarPuntos(int puntos)
    {
        System.out.println("+" + puntos + " puntos");
    }

    // Método para perder vida
    public void perderVida()
    {
        System.out.println("Jugador golpeado");
    }
}