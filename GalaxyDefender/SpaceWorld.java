import greenfoot.*;

//Clase principal del mundo en el que se jugará
//Se está definiendo el espacio donde aparecen los diferentes objetos y el jugador
public class SpaceWorld extends World
{
    private int contadorEnemigos = 0;
    private int score = 0;
    private int nivel = 1;
    private int tiempoSpawn = 100;
    private int vidas = 3;
    private boolean bossAparecio = false;
    
    //Aquí se indican el tamaño y aparición del jugador
    public SpaceWorld()
    {    
        //Se crea el mundo con las dimensiones definidas
        super(800, 600, 1);

        //Se agrega el jugador en la posición indicada
        addObject(new Player(), 400, 500);
        showText("Puntos: 0", 80, 20);
        showText("Nivel: 1", 400, 20);
        showText("Vidas: 3", 700, 20);
    }
    
    public void act()
    {
        generarEnemigos();
        
        if(score >= 500 && !bossAparecio)
        {
            addObject(new BossEnemy(), 400, 100);
    
            bossAparecio = true;
        }
    }
    
    public void generarEnemigos()
    {
        contadorEnemigos++;

        // Genera un enemigo cada cierto tiempo
        if(contadorEnemigos >= tiempoSpawn)
        {
            int x = Greenfoot.getRandomNumber(getWidth());
    
            if(nivel == 1)
            {
                addObject(new Enemigo(), x, 50);
            }
            else if(nivel == 2)
            {
                int tipo = Greenfoot.getRandomNumber(10);
    
                if(tipo < 7)
                {
                    addObject(new Enemigo(), x, 50);
                }
                else
                {
                    addObject(new EnemigoRapido(), x, 50);
                }
            }
            else if(nivel == 3)
            {
                int tipo = Greenfoot.getRandomNumber(10);
    
                if(tipo < 5)
                {
                    addObject(new Enemigo(), x, 50);
                }
                else if(tipo < 8)
                {
                    addObject(new EnemigoRapido(), x, 50);
                }
                else
                {
                    addObject(new EnemigoTanque(), x, 50);
                }
            }

        contadorEnemigos = 0;
    }
    }
    
    private void actualizarNivel()
    {
        if(score >= 200)
        {
            nivel = 3;
            tiempoSpawn = 50;
        }
        else if(score >= 100)
        {
            nivel = 2;
            tiempoSpawn = 75;
        }
        else
        {
            nivel = 1;
            tiempoSpawn = 100;
        }
    }
    
    // Método para sumar puntos
    public void sumarPuntos(int puntos)
    {
        score += puntos;
        actualizarNivel();
        showText("Puntos: " + score, 80, 20);
        showText("Nivel: " + nivel, 400, 20);
    }

    // Método para perder vida
    public void perderVida()
    {
        vidas--;
        showText("Vidas: " + vidas, 700, 20);
        if(vidas <= 0)
        {
            gameOver();
        }
    }
    private void gameOver()
    {
        showText("GAME OVER", 400, 300);
        showText("Puntaje Final: " + score, 400, 320);
        Greenfoot.stop();
    }
    
    public int getScore()
    {
        return score;
    }
}