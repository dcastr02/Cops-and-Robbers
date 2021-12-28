/*
//Diego Castro
//010873014
*/
public class Engine 
{
	private String engineType;
	private int mpg;
	private int maxSpeed;
	
	//Engine constructor
	public Engine(String engineType, int mpg, int maxSpeed)
	{
		//if empty string is passed set to default
		//check and correct values of ints passed
		if(engineType.length() == 0)
		{
			engineType = "Generic engine";
		}
	
		if(mpg < 0)
		{
			mpg = 0;
		}
	
		if(maxSpeed < 0)
		{
			maxSpeed = 0;
		}
		//set the instance variables
		this.engineType = engineType;
		this.mpg = mpg;
		this.maxSpeed = maxSpeed;
	}
	
	
	public int getMpg()
	{
		return mpg;
	}
	
	public int getMaxSpeed()
	{
		return maxSpeed;
	}
	
	public String getDescription()
	{
		return engineType + " (MPG: " + getMpg()  + ", " + "Max speed: " + getMaxSpeed() + ")";
	}
	
	
}
