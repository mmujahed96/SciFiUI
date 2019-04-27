package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class UI extends PApplet
{
    ArrayList <UIElement> elements = new ArrayList<UIElement>();
    ArrayList <Button> button = new ArrayList<Button>();
    ArrayList <Planets> planets = new ArrayList<Planets>();
    ArrayList <Circle> circle = new ArrayList<Circle>();
    //ArrayList <Minimap> mini = new ArrayList<Minimap>();
    //ArrayList <Box> box = new ArrayList<Box>();

    
    MovingCircle mc;
    SpaceShip ship;
    Radar radar;
    Background bg;
    //Circle cir;
    //Planets plan;
    int start = 0;
    boolean[] keys = new boolean[1024];
    PImage stary;
    Button but;
    PImage s1,s2,s3,s4,s5;
    
   

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
        stary = loadImage("bg.jpg");
        //loading 
        button.add(new Button(this, width/2, height/2, 500, 500));//UI ui, float x, float y, float width, float height, String text
        button.add(new Button(this,width/2, height/2, 120, 120));
        button.add(new Button(this,width/2, height/2, 400, 400));
        button.add(new Button(this,width/2, height/2, 330, 330));

        //rectangle
        planets.add(new Planets(30, 139, 450, 60, this));
        planets.add(new Planets(30, 201, 450, 60, this));
        planets.add(new Planets(30, 263, 450, 60, this));
        planets.add(new Planets(30, 325, 450, 60, this));
        planets.add(new Planets(30, 387, 450, 60, this));
        //box inside
        planets.add(new Planets(332, 144, 144, 50, this));
        planets.add(new Planets(332, 206, 144, 50, this));
        planets.add(new Planets(332, 268, 144, 50, this));
        planets.add(new Planets(332, 330, 144, 50, this));
        planets.add(new Planets(332, 392, 144, 50, this));
        // mc = new MovingCircle(this, width / 2, height / 2, 50);
        // ship = new SpaceShip(30, 100, 600, this);
        radar = new Radar(this, 0.4f, 1200, 600, 100 );//UI ui, float frequency, float x, float y, float radius
        bg = new Background(100, 100 , 30,this);
        elements.add(new Minimap(1280, 94, 100, 100,this));
        elements.add(new Minimap(1280, 94, 30, 30, this));
        elements.add(new Minimap(1280, 94, 140, 140, this));
        elements.add(new Box(1200, 0, 160, 180,this));
        elements.add(new Box(562, 30, 50, 480,this));
        but = new Button(this, 30, 30, 100,50 );

        for(int i = 0; i < 3; i++)
        {
            int text = (int)random(50,100);
            Circle cir = new Circle(100 +(i*100), 46, 75, 75, text, this);
            circle.add(cir);
            
        }

        s1 = loadImage("exo.jpg");
    }
     PImage image;
    
     public void mousePressed()
     {
        int back = start -1;
         if((mouseX > 632 && mouseX < 730) && (mouseY > 332 && mouseY < 432))//load screen
         {
            start = 1;
            
         }
         else if((mouseX > 332 && mouseX < 475) && (mouseY > 144 && mouseY < 192))//planet 1
         {
             start = 2;
         }else if((mouseX > 332 && mouseX < 475) && (mouseY > 206 && mouseY < 255)) //planet 2
         {
             start = 2;
         }else if((mouseX > 332 && mouseX < 475) && (mouseY > 268 && mouseY < 317))//planet 3
         {
             start = 2;
         }else if((mouseX > 332 && mouseX < 475) && (mouseY > 330 && mouseY < 379))//planet 4
         {
             start = 2;
         }else if ((mouseX > 332 && mouseX < 475) && (mouseY > 393 && mouseY < 441))//planet 5
         {
             start = 2;
         }else if((mouseX > 30 && mouseX < 130) && (mouseY > 30 && mouseY < 79))//back button
         {
             start = back;
         }
     }
    
    float spiral = 0; 
    int i = 0;
    boolean begin = false;

    public void loading()
    {

        float outline = 75;
        float cx = width/2;
        float cy = height/2;
        fill(0, 0, 255);
        textSize(60);
        textAlign(CENTER);
        text("Eligius III", 672, 75);
        noFill();
        strokeCap(SQUARE);
        fill(0, 0, 255);//blue
        spiral = (float) ((spiral + abs(sin((float) (spiral * .1)) * 1) * 1 + .1) % 200); //speed of circles increaseing and decreasing with how much percent the increase and decrease
        ellipse(cx , cy , 400, 400);
        //noFill();
        fill(0, 255, 0);//green
        ellipse(cx, cy, spiral + 140, spiral + 140);
        noFill();
        
        fill(255, 100);
        ellipse(cx, cy, spiral -330 , spiral - 330);
        fill(0, 0, 255);
        textSize(15);
        textAlign(CENTER);
        text("Press Here", cx, cy);
        noFill();
        fill(0, 100);
        ellipse(cx, cy, spiral -250 , spiral - 250);
        arc(0,0,outline,outline,0,PI);
        noFill();
        
        //display loading and press here
        // if((spiral > 190 && mouseX < 200) && (spiral > 190 && spiral < 200))
        // {
        //     textAlign(CENTER); 
        //     System.out.println("Loading");
        //     spiral = 450;
        //     fill(51, 0, 26);
        //     noFill();
        // } else if((spiral > 490 && mouseX < 500) && (spiral > 490 && spiral < 500)) {
        //    // ("Press here");
        // }
         noStroke();
         


    }

    public void draw()
    {
        
        background(0);
        
        line(20,20, mouseX, mouseY);
        println(mouseX, mouseY); // find out xy co-ordinate line of infinate length from one point to x and y of my mouse
       // bg.map();
        bg.render();
        
        // if(begin == false){
        //     //background(stary);
        //     noStroke();
        //     pushMatrix();
        //     translate(width/2, height/2, -250);
        //     pushMatrix();
        //     rotateY(PI * frameCount / 500);
        //     popMatrix();
        //     loading();
        // }
        // else 
         if (start == 0){
            loading();
            for(int b = 0; b < button.size(); b++)
                {
                    
                    button.get(b).render();
                    //button.mousePressed();
                    
                    
            }
             
                   
        }else if (start == 1){
            //background(stary);
            // radar.render();
            // radar.update();
            for(int p = 0; p < planets.size(); p++){
                planets.get(p).render();
                
            }
                // for(int c = 0; c < cir.size(); c++){
                //     cir.get(c).render();
                // }
                for(Circle cr: circle)
                {
                    noFill();
                    textSize(15);
                    cr.render();
                    text("Oxygen",100, 100);
                    text("Feul",200,100);
                    text("Water Supply", 300, 100);
                }
                for(int m = 0; m < elements.size(); m++){
                    elements.get(m).render();
                }
                    for(int x = 0; x < elements.size(); x++){
                        elements.get(x).render();
                    }
             }else if (start == 2){ //planet 1
                but.backButton();
                fill(0, 0, 255);
                textSize(20);
                textAlign(CENTER);
                text("Back", 132, 50);
                noFill();
                image(s1,width/5,height/2, 500,500);
                
                radar.render();
                radar.update();
             }else if (start == 3){
                but.backButton();
             }else if (start == 4){
                but.backButton();
             }else if (start == 5){
                but.backButton();
             }else if (start == 6){
                but.backButton();
             }
            
         
       
        //button.mousePressed();
        
    //    mc.update();
    //     mc.render();
    //    ship.render();

        if (checkKey(LEFT))
        {
            System.out.println("Left arrow key pressed");
        }
    }
}

