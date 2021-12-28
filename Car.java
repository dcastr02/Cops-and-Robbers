import java.awt.Graphics;

/*
//Diego Castro
//010873014
*/
public class Car extends Sprite
{
	private String carDescription;
	private GasTank gasTank;
	private Engine engine;
	
	public Car(String carDescription, int maxFuelCapacity, Engine engine, String jpgName)
	{
		super(jpgName);
		
		if(carDescription.length() == 0)
		{
			carDescription = "Generic car";
		}
		if(engine == null)
		{
			engine = new Engine("", 0, 0);
		}
		
		this.carDescription = carDescription;
		this.engine = engine;
		gasTank = new GasTank(maxFuelCapacity);
	}
	
	public void updateImage(Graphics g) 
	{
		super.updateImage(g);
	}
	public String getDescription()
	{	
		String strDouble = String.format("%.2f", getFuelLevel());
		
		return carDescription + " (engine: " + engine.getDescription() + "), fuel: " + strDouble + "/" + gasTank.getCapacity() + ", location: (" + super.getX() + "," + super.getY() + ")"; 
	}

	public double getFuelLevel()
	{
		return gasTank.getLevel();
	}
	
	public int getMPG()
	{
		return engine.getMpg();
	}
	
	public void fillUp()
	{
		gasTank.setLevel(gasTank.getCapacity());
	}
	
	public int getMaxSpeed()
	{
		return engine.getMaxSpeed();
	}
	
	public double drive(int distance, double xRatio, double yRatio)
	{
		int distanceX = 0;
		int distanceY = 0;
		double ratioDistance = Math.sqrt((Math.pow(xRatio, 2) + Math.pow(yRatio, 2)));
		int possibleMilesDriven = (int)getMPG() * (int)getFuelLevel();
		
		if(possibleMilesDriven >= distance)
		{
			distanceX = (int) ((distance / ratioDistance) * xRatio);
			distanceY = (int) ((distance / ratioDistance) * yRatio);
			super.setX(super.getX() + distanceX); 
			super.setY(super.getY() + distanceY);
			Double doubleMilesDriven = Double.valueOf(distance);
			gasTank.setLevel(getFuelLevel() - (Double.valueOf(distance) / getMPG())); 
			return doubleMilesDriven;
		}
		else
		{	double outOfGas = getMPG() * getFuelLevel();
			//System.out.println("Ran out of gas after driving " + outOfGas + " miles");
			distanceX = (int) ((outOfGas / ratioDistance) * xRatio);
			distanceY = (int) ((outOfGas / ratioDistance) * yRatio);
			super.setX(super.getX() + distanceX); 
			super.setY(super.getY() + distanceY);
			gasTank.setLevel(getFuelLevel() - (Double.valueOf(distance) / getMPG())); 
			return Double.valueOf((int)outOfGas);
		}
		
	}
	

}
