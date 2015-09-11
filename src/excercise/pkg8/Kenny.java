/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package excercise.pkg8;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author muirw5809
 */

// make sure you rename this class if you are doing a copy/paste
public class Kenny extends JComponent{

    // Height and Width of our game
    static final int WIDTH = 1200;
    static final int HEIGHT = 850;
    
    // sets the framerate and delay for our game
    // you just need to select an approproate framerate
    long desiredFPS = 60;
    long desiredTime = (1000)/desiredFPS;
    
    int timer = 0;
    int bullet = 52;
    
    //make an array for the amount of rain that will fall
    int[] rainX = new int[550];
    int[] rainY = new int[550];

    
    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g)
    {
        // always clear the screen first!
        
        // GAME DRAWING GOES HERE
        
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        //custom colours
        Color background = new Color (173, 254, 255);
        Color Skin = new Color (255, 216, 181);
        Color BRown = new Color (163, 82, 28);
        Color ORange = new Color (255, 128, 43);
        
        
       
        

        //make a background
        g.setColor(background);
        g.fillRect(0, 0, 5000, 5000);
        //make a road
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 650, 5000, 5000);
        
        g.setColor(Color.yellow);
        g.fillRect(10, 740, 30, 10);
        g.fillRect(90, 740, 30, 10);
        g.fillRect(170, 740, 30, 10);
        g.fillRect(250, 740, 30, 10);
        g.fillRect(330, 740, 30, 10);
        g.fillRect(410, 740, 30, 10);
        g.fillRect(490, 740, 30, 10);
        g.fillRect(570, 740, 30, 10);
        g.fillRect(650, 740, 30, 10);
        g.fillRect(730, 740, 30, 10);
        g.fillRect(810, 740, 30, 10);
        g.fillRect(890, 740, 30, 10);
        g.fillRect(970, 740, 30, 10);
        g.fillRect(1050, 740, 30, 10);
        g.fillRect(1130, 740, 30, 10);
        g.fillRect(1193, 740, 30, 10);
        
        
        //make rain
        g.setColor(Color.blue);
        for(int i = 0; i < rainX.length; i++)
        {
            g.fillRect(rainX[i], rainY[i], 10, 20);
        }
       
       
        //make face
       
        g.setColor(ORange);
        //body
        g.fillRect(475, 540, 250, 170);
        g.fillArc(450, 450, 300, 400, 0, 180);
        //hands
        g.fillOval(439, 630, 50, 50);
        g.fillOval(707, 630, 50, 50);
        g.setColor(Color.red);
        g.drawOval(460, 630, 25, 25);
        g.drawOval(707, 630, 25, 25);
        g.setColor(Color.black);
        //pockets
        //right pocket
        g.drawLine(718, 630, 715, 600);
        g.drawLine(719, 630, 716, 600);
        //left pocket
        g.drawLine(472, 630, 475, 600);
        g.drawLine(473, 630, 476, 600);
        //zipper
        g.drawLine(595, 500, 595, 650);
        g.drawLine(596, 500, 596, 650);
        g.drawLine(597, 500, 597, 650);
        g.drawLine(598, 500, 598, 650);
        
        
        //black outline of head
        g.fillOval(450, 251, 300, 300);
        g.setColor(ORange);
        //black border around face
        g.fillOval(449, 250, 303, 299);
        g.setColor(Color.BLACK);
        g.fillOval(500, 300, 200, 200);
        g.setColor(ORange);
        g.fillOval(504, 303, 193, 193);
        
        //border around face
        g.setColor(BRown);
        g.fillOval(513, 302, 175, 175);
       
        
        //make face
        g.setColor(Skin);
       
        g.fillArc(527, 315, 150, 150, -90, 180);
        g.fillArc(528, 315, 150, 150, 270, -180);
        
        //make eyes
        g.setColor(Color.WHITE);
        g.fillOval(528, 348, 75, 75);
        g.fillOval(600, 350, 75, 75);
        
        g.setColor(Color.BLACK);
        g.fillOval(609, 379, 10, 10);
        g.fillOval(585, 378, 10, 10);
 
        //make Feet
        g.fillArc(464, 700, 140, 30, 0, 180);
        g.fillArc(595, 700, 140, 30, 0, 180);
        
        //make bullet
       g.fillArc(bullet, 350, 40, 40, -90, 180);
       
       //make bullet mover towards kenny
        bullet++;
        
         // when the bullet hits kenny make screen go blank
        if(timer >416 || bullet>426)
        {
            g.setColor(Color.red);
            g.fillRect(0, 0, 1200, 850);
        }
        
        if(timer > 420 || bullet>=435)
        {
            g.setColor(Color.black);
            g.fillRect(0, 0, 1200, 850);   
        }
        
        
        //when screen goes blank reset the scene
      if(timer>425)
      {
          timer = 0;
          bullet = 0;
      }
      
        
        
        
        
         
        
        
        // GAME DRAWING ENDS HERE
    }
    
    
    // The main game loop
    // In here is where all the logic for my game will go
    public void run()
    {
        // Used to keep track of time used to draw and update the game
        // This is used to limit the framerate later on
        long startTime;
        long deltaTime;
        
        
        int y = 10;
        //a loop that makes the rain fall atleast 30 units apart from eachother over the screen
        for(int i = 0; i < rainX.length; i++)
        {
            int x = (int)(Math.random()*5000) + 10;
            rainX[i] = x;
            rainY[i] = y;
            y += 30;
            if(y > 700)
            {
                y = 10;
            }
            
        }
        
        // the main game loop section
        // game will end if you set done = false;
        boolean done = false; 
        while(!done)
        {
            // determines when we started so we can keep a framerate
            startTime = System.currentTimeMillis();
            
            // all your game rules and move is done in here
            // GAME LOGIC STARTS HERE 
            
            //a loop that makes the rain fall over the whole screen
            for(int i = 0; i < rainY.length; i++)
            {
                rainY[i] += 2;
                
                if(rainY[i] > 700)
                {
                    int x = (int)(Math.random()*5000) + 10;
                    rainX[i] = x;
                    rainY[i] = -13;
                   
                }
            }
            
            
            //have a timer count
           timer++;
           
            
            

            // GAME LOGIC ENDS HERE 
            
            // update the drawing (calls paintComponent)
            repaint();
            
            
            
            // SLOWS DOWN THE GAME BASED ON THE FRAMERATE ABOVE
            // USING SOME SIMPLE MATH
            deltaTime = System.currentTimeMillis() - startTime;
            if(deltaTime > desiredTime)
            {
                //took too much time, don't wait
            }else
            {
                try
                {
                    Thread.sleep(desiredTime - deltaTime);
                }catch(Exception e){};
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates a windows to show my game
        JFrame frame = new JFrame("My Game");
       
        // creates an instance of my game
        Kenny game = new Kenny();
        // sets the size of my game
        game.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        // adds the game to the window
        frame.add(game);
         
        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);
        
        // starts my game loop
        game.run();
    }
}