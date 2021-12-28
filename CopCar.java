import java.awt.Graphics;
import java.util.Random;

/*
//Diego Castro
//010873014
*/

public class CopCar extends Car
{
	private static int xRatio;
	private static int yRatio;

	private int signX = 1;
	private int signY = 1;

	public CopCar()
	{
		super("", 5000, new Engine("",  30, 100), "cop-car.jpg");
		super.fillUp();
		Random ran = new Random();
		xRatio = ran.nextInt(11) - 5;
		yRatio = ran.nextInt(11) - 5;
	
		
	}

	public void updateState(int width, int height)
	{
		
	
		
		//bounce right
		if(super.getX() >= width)
		{
			signX *= -1;
		}
		
		//bounce left
		else if(super.getX() <= 0)
		{
			signX *= -1;
		}
		
		//bounce bottom
		if(super.getY() >= height)
		{
			signY *= -1;
		}
		
		//bounce top
		else if(super.getY() <= 0)
		{
			signY *= -1;
		}
	
		super.drive(2, xRatio * signX, yRatio * signY);
		
	}
	
	public void updateImage(Graphics g)
	{
		super.updateImage(g);
	}
}
