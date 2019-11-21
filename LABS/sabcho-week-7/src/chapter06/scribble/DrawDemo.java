import java.awt.Color;
import java.util.Random;

public class DrawDemo
{
    private Canvas myCanvas;
    private Random random;

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public DrawDemo()
    {
        myCanvas = new Canvas("Drawing Demo", 1000, 500);
        random = new Random();
    }

    /**
     * Draw a square on the screen.
     */
    public void drawSquare()
    {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.BLUE);

        square(pen);
    }
    
    //Answer to 5.57
    public void drawTriangle()
    {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.GREEN);

        for (int i=0; i<3; i++)
        {
            pen.move(100);
            // 360/3=120
            pen.turn(120);
        }
    }
    
    //Answer to 5.58
    public void drawPentagon()
    {
        Pen pen = new Pen(220, 60, myCanvas);
        pen.setColor(Color.BLACK);

        for (int i=0; i<5; i++)
        {
            pen.move(100);
            pen.turn(360/5);
        }
        
    }
    
    //Answer to 5.59
    public void drawPolygon(int n)
    {
        Pen pen = new Pen(220, 60, myCanvas);
        pen.setColor(Color.PINK);

        for (int i=0; i<n; i++)
        {
            pen.move(60);
            pen.turn(360/n);
        }
        
    }
    
    //Answer to 5.60
    public void spiral()
    {
        Pen pen = new Pen(220, 60, myCanvas);
        pen.setColor(Color.BLACK);

        for (int i=0; i<100; i++)
        {
            pen.move(i);
            pen.turn(90);
        }
    }

    /**
     * Draw a wheel made of many squares.
     */
    public void drawWheel()
    {
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.RED);

        for (int i=0; i<36; i++) {
            square(pen);
            pen.turn(10);
        }
    }

    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square(Pen pen)
    {
        for (int i=0; i<4; i++) {
            pen.move(100);
            pen.turn(90);
        }
    }

    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble()
    {
        Pen pen = new Pen(250, 200, myCanvas);

        for (int i=0; i<10; i++) {
            // pick a random color
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            pen.setColor(new Color(red, green, blue));
            
            pen.randomSquiggle();
        }
    }
    
    /**
     * Clear the screen.
     */
    public void clear()
    {
        myCanvas.erase();
    }
}
