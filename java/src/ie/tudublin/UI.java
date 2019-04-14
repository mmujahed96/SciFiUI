package ie.tudublin;

import processing.core.PApplet;

public class UI extends PApplet
{
    Button b;
    MovingCircle mc;
    SpaceShip ship;
    Radar radar;
    Background bg;

    boolean[] keys = new boolean[1024];

    public void keyPressed()
    {
        keys[keyCode] = true;
    }
    
    public void keyReleased()
    {
        keys[keyCode] = true;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }
    

    public void settings()
    {
        //size(800, 800);
        // Use fullscreen instead of size to make your interface fullscreen
        fullScreen(); 
    }

    public void setup()
    {
        b = new Button(this, width/2, height/2, 500, 500, "I am a button");//UI ui, float x, float y, float width, float height, String text
       // b = new Button(this, width/2, height/2, 300, 300, "");
        //mc = new MovingCircle(this, width / 2, height / 2, 50);
        //ship = new SpaceShip(30, 100, 600, this);
        //radar = new Radar(100, 100, 200, this);
        //bg = new Background(height, width , 30,this);
    }

    public void draw()
    {
        background(0);
        b.render();
        b.update();

       // mc.update();
       // mc.render();
       // ship.render();
        //radar.render();
        //bg.render();
        

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }
}

