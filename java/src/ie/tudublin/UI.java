package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class UI extends PApplet
{
    ArrayList <Button> button = new ArrayList<Button>();
    //Button button;
    MovingCircle mc;
    SpaceShip ship;
    Radar radar;
    Background bg;
    Circle cir;
    int start = 0;

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
        button.add(new Button(this, width/2, height/2, 500, 500));//UI ui, float x, float y, float width, float height, String text
        button.add(new Button(this,width/2, height/2, 120, 120));
        button.add(new Button(this,width/2, height/2, 400, 400));
        // ui.ellipse(x, y, width/4, height/4);
        // ui.ellipse(x, y, width/5, height/5);
        //mc = new MovingCircle(this, width / 2, height / 2, 50);
        //ship = new SpaceShip(30, 100, 600, this);
        radar = new Radar(this, 0.4f, 1200, 600, 100 );//UI ui, float frequency, float x, float y, float radius
        bg = new Background(100, 100 , 30,this);
        // cir = new Circle(this, width/3, height/3, 75, 75, 0, PI); //
        //cir = new Circle(this, width/3, height/3, 200, 200);
    }
    // public void mousePressed()
    // {
        // if((mouseX > 632 && mouseX < 730) && (mouseY > 332 && mouseY < 432))
        // {

        // }
    // }

    public void draw()
    {
        
        background(0);
        
        line(20,20, mouseX, mouseY);
        println(mouseX, mouseY); // find out xy co-ordinate line of infinate length from one point to x and y of my mouse
       // bg.map();
        bg.render();
        for(int b = 0; b < button.size(); b++)
            {
                button.get(b).render();
            }
       // button.render();
        //button.mousePressed();
        
       // mc.update();
        //mc.render();
       // ship.render();
         
          radar.render();
          radar.update();
        
        //cir.render();
        

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }
}

