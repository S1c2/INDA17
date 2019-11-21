import java.awt.Color;
import java.util.*;

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }
    
        public void bounceOriginal()
    {

        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);

        // create and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while (!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    
    
    }

    // Answer to 5.62
    public void bounce(int nrOfBalls)
    {

        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(50, ground, 550, ground);
        
        //new ArrayList to store the balls
        ArrayList<BouncingBall> ballList = new ArrayList<BouncingBall>();

        for(int i = 1; i<=nrOfBalls;i++)
        {
            //max and min to give a range to our randomGenerator
            //It will decide the x-position, y-position and diameter of each ball
            int max = 80;
            int min = 10;
            Random randomGenerator = new Random();
            //generate a random number between min and max
            int randomInt1 = randomGenerator.nextInt(max + 1 - min) + min;
            int randomInt2 = randomGenerator.nextInt(max + 1 - min) + min;
            int randomInt3 = randomGenerator.nextInt(max + 1 - min) + min;
            //create a new ball object of type BouncingBall and send the 6 parameters as information to the BouncingBall class
            BouncingBall ball = new BouncingBall(randomInt1, randomInt2, randomInt3, Color.BLUE, ground, myCanvas);
            //show the ball
            ball.draw();
            //add the ball to the ArrayList
            ballList.add(ball);
        }
        
        boolean finished = false;
        //while NOT finished
        while(!finished)
            {
                myCanvas.wait(50);
                //for each ball of type BouncingBall in ArrayList called ballList
                for(BouncingBall ball : ballList)
                {
                    //ball will act accordingly to the move() method in the BouncingBall class
                    ball.move();
                    //if the x-position of the ball being tested is more than 550, the while loop stops
                    if(ball.getXPosition() >= 550) 
                    {
                        finished = true;
                    }
                }    
       
            }
    }
    
    // Answer to 5.64
    public void bounce2(int nrOfBalls)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.setForegroundColor(Color.BLACK);
        //drawLine draws a line between the coordinates (50,ground) and (550,ground)
        myCanvas.drawLine(50, ground, 550, ground);
        
        ArrayList<BouncingBall> ballList = new ArrayList<BouncingBall>();

        for(int i = 1; i<=nrOfBalls;i++)
        {
            int max = 50;
            int min = 10;
            Random randomGenerator = new Random();
            //600,250 are the dimensions for the upper half of the screen if the screens dimensions are 600*500
            //xPosition 
            int randomInt1 = randomGenerator.nextInt(600 + 1);
            //yPosition
            int randomInt2 = randomGenerator.nextInt(250 + 1);
            //diameter of ball
            int randomInt3 = randomGenerator.nextInt(max + 1 - min) + min;
            BouncingBall ball = new BouncingBall(randomInt1, randomInt2, randomInt3, Color.BLUE, ground, myCanvas);
            ball.draw();
            ballList.add(ball);
        }
        
        boolean finished = false;
        while(!finished)
            {
                myCanvas.wait(50);
                for(BouncingBall ball : ballList)
                {
                    ball.move();
                    if(ball.getXPosition() >= 550) 
                    {
                        finished = true;
                    }
                }    
       
            }
    }
    
    //Answer to 5.65 and 5.66
    public void boxBounce(int nrOfBalls)
    {
        //measurements for our rectangle
        int groundPos = 400;
        int ceilingPos = 100;
        int rightWall = 400;
        int leftWall = 200;


        myCanvas.setVisible(true);

        // draw the rectangle
        //add or subtract 1 to make sure the walls get less damaged(erased) when the ball "touches" them
        myCanvas.setForegroundColor(Color.BLACK);
        myCanvas.drawLine(rightWall+1, groundPos+1, leftWall-1, groundPos+1);
        myCanvas.drawLine(rightWall+1,ceilingPos-1, leftWall-1, ceilingPos-1);
        myCanvas.drawLine(rightWall+1,groundPos+1,rightWall+1,ceilingPos-1);
        myCanvas.drawLine(leftWall-1,groundPos+1,leftWall-1,ceilingPos-1);
        
        //create ArrayLists to store the balls and the colors which will be decided for the balls
        ArrayList<BoxBall> ballList = new ArrayList<BoxBall>();
        ArrayList<Color> colorList = new ArrayList<Color>();
        
        //add colors to the colorList
        colorList.add(Color.BLUE);
        colorList.add(Color.BLACK);
        colorList.add(Color.CYAN);
        colorList.add(Color.DARK_GRAY);
        colorList.add(Color.GRAY);
        colorList.add(Color.GREEN);
        colorList.add(Color.MAGENTA);
        colorList.add(Color.ORANGE);
        colorList.add(Color.PINK);
        colorList.add(Color.RED);
        colorList.add(Color.YELLOW);
        

        for(int i = 1; i<=nrOfBalls;i++)
        {
            int maxSpeed = 10;
            int minSpeed = 5;
            Random randomGenerator = new Random();
            //xPosition 
            int randomIntX = randomGenerator.nextInt(rightWall + 1-leftWall)+leftWall;
            //yPosition
            int randomIntY = randomGenerator.nextInt(groundPos + 1-ceilingPos)+ceilingPos;
            
            //xspeed
            int randomIntXS = randomGenerator.nextInt(maxSpeed + 1 - minSpeed) + minSpeed;
            //yspeed
            int randomIntYS = randomGenerator.nextInt(maxSpeed + 1 - minSpeed) + minSpeed;
            BoxBall ball = new BoxBall(randomIntX, randomIntY, randomIntXS,randomIntYS, 10, colorList.get(randomGenerator.nextInt(colorList.size())),
            groundPos,ceilingPos, myCanvas,rightWall, leftWall);
            ball.draw();
            ballList.add(ball);
        }

        // make them bounce
        boolean finished =  false;
        while (!finished) 
        {
            myCanvas.wait(50); 
            for(BoxBall ball : ballList)
                {
                    ball.move();
                    if(ball.getXPosition() >= 550) 
                    {
                        finished = true;
                    }
                }   

        }
}
}
