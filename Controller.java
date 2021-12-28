import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.SwingUtilities;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/*
//Diego Castro
//010873014
*/

class Controller implements MouseListener, KeyListener
{
    Model model;
    View view;
    
    public void keyTyped(KeyEvent e)
    {
    	if(e.getKeyChar() == 'h')
    	{
    		System.out.println("Hello World");
    	}
    	if(e.getKeyChar() == 'n')
    	{
    		System.out.println("Robbers Ecaped|Captured: " + RobberCar.numEsc + "|" + RobberCar.numCap);
    	}
    	if(e.getKeyChar() == 'r')
    	{
    		Model.initialize();
    		view.repaint();
    	}
    	
    }
    public void keyPressed(KeyEvent e)
    {
    	if(e.getKeyChar() == 's')
    	{
    		Thread t = new Thread(new SpriteMover(model, view));
    		t.start();	
    	}
    	
    }
    
    public void keyReleased(KeyEvent e)
    {
    	
    }

    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
        //new Timer(50, view).start();
    }

    public void update(Graphics g) {
        model.update(g);
    }

    public void mousePressed(MouseEvent e)
    {
    	view.repaint();
		if (SwingUtilities.isLeftMouseButton(e))
		{
			// Gets here is left mouse button was clicked
			int x = e.getX();
			int y = e.getY();
			model.newSprite(x, y);
		} 
		
		else if (SwingUtilities.isRightMouseButton(e))
		{
			model.updateScene(view.getWidth(), view.getHeight());
		}
    }
    
    

    public void mouseReleased(MouseEvent e)
    {    
    	
    }
    public void mouseEntered(MouseEvent e)
    {    
    	
    }
    public void mouseExited(MouseEvent e)
    {    
    	
    }
    public void mouseClicked(MouseEvent e)
    {    
    	
    }

    public static void main(String[] args) throws Exception 
    {
        //  Use the following line to determine which directory your program
        //  is being executed from, since that is where the image files will
        //  need to be.
        //System.out.println("cwd=" + System.getProperty("user.dir"));
        new Controller();
    }
}
