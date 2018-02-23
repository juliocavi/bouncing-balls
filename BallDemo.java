import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private ArrayList<BouncingBall> ballsList;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int balls)
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        ballsList = new ArrayList<>(balls);
        Random random = new Random();

        // crate and show the balls
        for(int i=0; i<balls; i++){
            int radio = 10 + random.nextInt(20);
            int color1 = random.nextInt(256);
            int color2 = random.nextInt(256);
            int color3 = random.nextInt(256);
            Color color = new Color(color1, color2, color3);
            BouncingBall ball = new BouncingBall(50+(25*i), 50, radio, color, ground, myCanvas);
            ball.draw();
            ballsList.add(ball);
        }

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int i=0; i<balls; i++){
                ballsList.get(i).move();
                // stop once ball has travelled a certain distance on x axis
                if(ballsList.get(i).getXPosition() >= 550){
                    finished = true;
                }
            }
        }
    }
}
