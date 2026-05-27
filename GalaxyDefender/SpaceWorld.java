import greenfoot.*;

public class SpaceWorld extends World
{
    public SpaceWorld()
    {    
        super(800, 600, 1);

        addObject(new Player(), 400, 500);
    }
}