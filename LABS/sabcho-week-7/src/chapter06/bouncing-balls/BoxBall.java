
//whole class is an answer
import java.awt.*;
import java.awt.geom.*;


public class BoxBall
{
    private static final int GRAVITY = 3;  // effect of gravity

    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private final int groundPosition;      // y position of ground
    private final int ceilingPosition;
    private Canvas canvas;
    private int ySpeed; 
    private int xSpeed;
    private int rWall;
    private int lWall;
    

    /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos,int xSpeed, int ySpeed, int ballDiameter, Color ballColor,
                        int groundPos,int ceilingPos, Canvas drawingCanvas, int rightWall, int leftWall)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        diameter = ballDiameter;
        groundPosition = groundPos;
        canvas = drawingCanvas;
        ceilingPosition = ceilingPos;
        rWall = rightWall;
        lWall=leftWall;
        
    }

    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        //compute new speed
        yPosition += ySpeed;
        xPosition += xSpeed;
        
        // check if it has hit the ceiling
        if (yPosition <= (ceilingPosition) ) {
            yPosition = (int)(ceilingPosition);
            ySpeed = -ySpeed; 
        }
        

        // check if it has hit the ground
        else if (yPosition >= (groundPosition - diameter) ) {
            yPosition = (int)(groundPosition - diameter);
            ySpeed = -ySpeed; 
        }
        
        //right wall
        else if(xPosition >= (rWall - diameter) ) {
            xPosition = (int)(rWall - diameter);
            xSpeed = -xSpeed; 
        }
        //left wall
        else if(xPosition <= (lWall)) {
            xPosition = (int)(lWall);
            xSpeed = -xSpeed;

        }

        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
}
