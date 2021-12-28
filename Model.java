import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
/*
//Diego Castro
//010873014
*/

class Model
{
    private CopCar cop;
    private RobberCar robber;
    private static Bank bank;
    public static ArrayList<Sprite> spritesList = new ArrayList<Sprite>();
    private boolean flag =  true;
    Model() throws IOException 
    {
    	//cars = new Car("", 0, new Engine("", 0, 0), "red-car.jpg");
    	//cop = new CopCar();
    	bank = new Bank();
		//sprite = new Sprite("smiley.jpg");
		spritesList.add(bank);
    }
    
    public void newSprite(int x, int y)
    {
    	synchronized(spritesList)
    	{
    	if(flag)
    	{
    		robber = new RobberCar();
        	robber.setX(300);
        	robber.setY(300);
        	spritesList.add(robber);
        	flag = false;
    	}
    	else
    	{
    		cop = new CopCar();
        	cop.setX(x);
        	cop.setY(y);
        	spritesList.add(cop);
        	flag = true;
    	}
    	}	
    }

    public void update(Graphics g) 
    {
    	synchronized(spritesList)
    	{
    		for(int x = 0; x < spritesList.size(); x++)
        	{
        		spritesList.get(x).updateImage(g);
        	}
    	}
    	
		
    }
    public static void initialize()
    {
    	spritesList.clear();
    	bank = new Bank();
		spritesList.add(bank);
		RobberCar.numCap = 0;
		RobberCar.numEsc = 0;
    }
    
    public void updateScene(int width, int height)
    {
    	synchronized(spritesList)
    	{
    		for(int x = 1; x < spritesList.size(); x++)
    		{
        		spritesList.get(x).updateState(width, height);
        		if(spritesList.get(x) instanceof CopCar)
        		{
        			for(int y = 1; y < spritesList.size(); y++)
        			{
        				if(spritesList.get(x).overlaps(spritesList.get(y)) && (spritesList.get(y) instanceof RobberCar))
        				{
        					//System.out.println("Gotcha!");
        					((RobberCar) spritesList.get(y)).captured();
        				}
        			}
        		}
    		}
    		
        	Iterator <Sprite> iter = spritesList.iterator();
        	Sprite s;
        	
        	while(iter.hasNext())
        	{
        		s = iter.next();
        		if(s instanceof RobberCar && ((RobberCar) s).hasEscaped())
        		{
        			iter.remove();
        			System.out.println("I'm free!");
        		}
        	}
    	}
    }
}
