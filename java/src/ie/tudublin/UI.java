package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class UI extends PApplet
{
    ArrayList <Button> button = new ArrayList<Button>();
    ArrayList <Planets> planets = new ArrayList<Planets>();
    ArrayList <Circle> cir = new ArrayList<>();

    //Button button;
    MovingCircle mc;
    SpaceShip ship;
    Radar radar;
    Background bg;
    //Circle cir;
    //Planets plan;
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
        //loading 
        button.add(new Button(this, width/2, height/2, 500, 500));//UI ui, float x, float y, float width, float height, String text
        button.add(new Button(this,width/2, height/2, 120, 120));
        button.add(new Button(this,width/2, height/2, 400, 400));
        button.add(new Button(this,width/2, height/2, 330, 330));

        
        planets.add(new Planets(30, 100, 500, 75, this));
        planets.add(new Planets(30, 190, 500, 75, this));
        planets.add(new Planets(30, 280, 500, 75, this));
        planets.add(new Planets(30, 370, 500, 75, this));
        planets.add(new Planets(30, 460, 500, 75, this));
        //box inside
        planets.add(new Planets(384, 105, 142, 66, this));
        planets.add(new Planets(384, 195, 142, 66, this));
        planets.add(new Planets(384, 285, 142, 66, this));
        planets.add(new Planets(384, 375, 142, 66, this));
        planets.add(new Planets(384, 465, 142, 66, this));
        //mc = new MovingCircle(this, width / 2, height / 2, 50);
        //ship = new SpaceShip(30, 100, 600, this);
        radar = new Radar(this, 0.4f, 1200, 600, 100 );//UI ui, float frequency, float x, float y, float radius
        bg = new Background(100, 100 , 30,this);
        cir.add(new Circle(101, 46, 100, 75, this)); //
        cir.add(new Circle(190, 46, 75, 75, this));
        cir.add(new Circle(270, 46, 75, 75, this));
        
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
        if (start == 0){
            for(int b = 0; b < button.size(); b++)
                {
                    button.get(b).render();
                    //button.mousePressed();
                    
            }
            for(int p = 0; p < planets.size(); p++){
                planets.get(p).render();
                
            }
                for(int c = 0; c < cir.size(); c++){
                    cir.get(c).render();
                }
                   
        }
          
        // }else if (start == 1){
        //     // for(int p = 0; p < planets.size(); p++)
        //     // {
        //     // planets.get(p).render();
        //     // cir.get(p).render();
        //     // }
            
         
       
        //button.mousePressed();
        
       // mc.update();
        //mc.render();
       // ship.render();
         
          radar.render();
          radar.update();
        
        
        

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }
}

