package ie.tudublin;

import processing.core.PApplet;

public class UI extends PApplet
{
    Button b;
    MovingCircle mc;
    SpaceShip ship;
    Radar radar;
    Background bg;
    Circle cir;

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
        //mc = new MovingCircle(this, width / 2, height / 2, 50);
        //ship = new SpaceShip(30, 100, 600, this);
        radar = new Radar(this, 0.4f, 1200, 600, 100 );//UI ui, float frequency, float x, float y, float radius
        bg = new Background(100, 100 , 30,this);
        // cir = new Circle(this, width/3, height/3, 75, 75, 0, PI); //
        //cir = new Circle(this, width/3, height/3, 200, 200);
    }

    public void draw()
    {
        
        background(0);
        b.render();
        b.mousePressed();
       // mc.update();
       // mc.render();
       // ship.render();
        bg.map();
        bg.render();
        radar.render();
        radar.update();
        
        //cir.render();
        

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }
}

