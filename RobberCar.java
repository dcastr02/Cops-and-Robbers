import java.awt.Graphics;
import java.util.Random;

/*
//Diego Castro
//010873014
*/

public class RobberCar extends Car
{
	private int xRatio;
	private int yRatio;
	private boolean captured = false;
	private boolean escaped = false;
	public static int numEsc = 0;
	public static int numCap = 0;
	public RobberCar()
	{	
		super("", 5000, new Engine("",  20, 200), "red-car.jpg");
		super.fillUp();
		Random ran = new Random();
		xRatio = (ran.nextInt(11) - 5);
		yRatio = (ran.nextInt(11) - 5);
	}

	public void captured()
	{
		if(!isCaptured())
		{
			super.setImage("jail.jpg");
			captured = true;
			numCap++;
		}
		
		
		//System.out.println(numCap);
	}
	public boolean hasEscaped()
	{
		return escaped;
	}
	public void updateState(int width, int height)
	{
		if(!isCaptured())
		{
			super.drive(4, xRatio, yRatio);
			
			if(((getX() + 60 <= 0) && !escaped )|| ((getX() >= width) && !escaped) || ((getY() + 60 >= height) && !escaped) || ((getY() + 60 <= 0) && !escaped))
			{
				escaped = true;
				numEsc++;
			}
			
			//System.out.println("escaped? Y:N " + escaped);
			//System.out.println(numEsc);
		}
		
		
	}
	
	public boolean isCaptured()
	{
		return captured;
	}
	public void updateImage(Graphics g)
	{
		super.updateImage(g);
	}
}
