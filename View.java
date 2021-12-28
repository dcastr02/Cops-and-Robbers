import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
//Diego Castro
//010873014
*/

public class View extends JFrame implements ActionListener {

    private class MyPanel extends JPanel {
        Controller controller;

        MyPanel(Controller c) {
            controller = c;
            addMouseListener(c);
        }

        public void paintComponent(Graphics g) {
            controller.update(g);
            revalidate();
        }
    }


    public View(Controller c) throws Exception
    {
        setTitle("Cops and Robbers");
        setSize(1000, 700);
        getContentPane().add(new MyPanel(c));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(c);
        setVisible(true);
       
    }

    public void actionPerformed(ActionEvent evt) {
        repaint();
    }
}
