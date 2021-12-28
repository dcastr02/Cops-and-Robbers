/*
//Diego Castro
//010873014
*/
public class GasTank 
{
	private int maxCapacity;
	private double currentLevel;
	
	public GasTank(int maxCapacity)
	{
		if(maxCapacity >= 0)
		{
			this.maxCapacity = maxCapacity;
		}
		else
		{
			maxCapacity = 0;
			this.maxCapacity = maxCapacity;
		}
		
		currentLevel = 0;
	}
	
	public int getCapacity()
	{
		return maxCapacity;
	}
	
	public double getLevel()
	{
		return currentLevel;
	}
	
	public void setLevel(double levelIn)
	{
		if(levelIn < 0)
		{
			currentLevel =  0;
		}
		else if(levelIn > maxCapacity)
		{
			currentLevel = maxCapacity;
		}
		else
		{
			currentLevel = levelIn;
		}
		
	}
}
