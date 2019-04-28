package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;
import processing.data.Table;
import processing.data.TableRow;

public class UI extends PApplet
{
    ArrayList <UIElement> elements = new ArrayList<UIElement>();
    ArrayList <Button> button = new ArrayList<Button>();
    ArrayList <Planets> planets = new ArrayList<Planets>();
    ArrayList <Circle> circle = new ArrayList<Circle>();
    ArrayList <Minimap> lines = new ArrayList<Minimap>();
    ArrayList <Minimap> mini = new ArrayList<Minimap>();

    //ArrayList <Box> box = new ArrayList<Box>();
    private ArrayList<Planetdata> DataE = new ArrayList<Planetdata>();  //earth data
    private ArrayList<Planetdata> DataErup = new ArrayList<Planetdata>();  //eruptus data
    private ArrayList<Planetdata> DataKep = new ArrayList<Planetdata>();  //keplet data
    private ArrayList<Planetdata> DataGli = new ArrayList<Planetdata>();  //gliese data
    private ArrayList<Planetdata> DataCri = new ArrayList<Planetdata>();  //crim data
    
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
    float radius = 0;
    //Minimap mini;

    //for the sine wave
    float k = 10.0f;
    float k1 = 0.5f;
    float k2 = 0.5f;
    float k3 = 10.0f;
    float l = 15.0f;
    float step = 1;

    // public void keyPressed()
    // {
    //     keys[keyCode] = true;
    // }
    
    // public void keyReleased()
    // {
    //     keys[keyCode] = true;
    // }

    // public boolean checkKey(int c)
    // {
    //     return keys[c] || keys [Character.toUpperCase(c)];
    // }
    

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
        // mc = new MovingCircle(this, width / 2, height / 2, 50);
        // ship = new SpaceShip(30, 100, 600, this);
        radar = new Radar(this, 0.4f, 1200, 600, 100 );//UI ui, float frequency, float x, float y, float radius
        bg = new Background(100, 100 , 30,this);
       // mini.add(new Minimap(1280, 94, 0.4f, 50, this);//(float x, float y, int size, float frequency, float radius , float r, float g, float b, PApplet ui
        mini.add(new Minimap(1280, 94, 0.4f, 50, 116, 0, 255, this));
        // elements.add(new Minimap(1280, 94, 100, 100,this));
        // elements.add(new Minimap(1280, 94, 30, 30, this));
        // elements.add(new Minimap(1280, 94, 140, 140, this));
        elements.add(new Box(1200, 0, 160, 180,this));
        elements.add(new Box(492, 139, 110, 480,this));
        elements.add(new Box(7,456,278,310,this));
        but = new Button(this, 30, 30, 100,50 );

        //rectangles and button rectangle inside
        for(int i = 0; i < 5; i++)
        {
            Planets p = new Planets(30 ,139 +(i*62) , 450, 60, this);
            Planets pb = new Planets(332 ,144 +(i*62) , 144, 50, this);
            planets.add(p);
            planets.add(pb);
            
        }
        //circles with percentages
        for(int i = 0; i < 3; i++)
        {
            int text = (int)random(50,100);
            Circle cir = new Circle(100 +(i*100), 46, 75, 75, text, this);
            circle.add(cir);
            
        }
        //img
        s1 = loadImage("exo.jpg");
        s2 = loadImage("dearth.jpg");
        s3 = loadImage("gliese667c.jpg");
        s4 = loadImage("Kepler62f.jpg");
        s5 = loadImage("HWVir.jpg");
        stary = loadImage("bg.jpg");

        //planet info
        loadEarthdata(); 
        loadErupdata();
        loadKepdata();
        loadGlidata(); 
        loadCridata();
    }
     
    
     public void mousePressed()
     {
       // int back = start -1;
         if((mouseX > 632 && mouseX < 730) && (mouseY > 332 && mouseY < 432))//load screen
         {
            start = 1;
            
         }
         else if((mouseX > 332 && mouseX < 475) && (mouseY > 144 && mouseY < 192))//planet 1
         {
             start = 2;
         }else if((mouseX > 332 && mouseX < 475) && (mouseY > 206 && mouseY < 255)) //planet 2
         {
             start = 3;
         }else if((mouseX > 332 && mouseX < 475) && (mouseY > 268 && mouseY < 317))//planet 3
         {
             start = 4;
         }else if((mouseX > 332 && mouseX < 475) && (mouseY > 330 && mouseY < 379))//planet 4
         {
             start = 5;
         }else if ((mouseX > 332 && mouseX < 475) && (mouseY > 393 && mouseY < 441))//planet 5
         {
             start = 6;
         }
     }
    
    float spiral = 0; 
    int i = 0;
   // boolean begin = false;

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
         

//sine wave
    }
    float sine(float x) {
      return k1*pow(k2/(k2+pow(x, 4)), k2)*cos(k3*x-l);
     
     
    }
    void sinew()
    {
      float kx = 0.0f;
      float ky = width/2;
      boolean overSig = false;
      boolean locked = false;
      int boxSize=130;
      for (float x=2;  x<width/5; x+=step)
      {
        float sx = map(x, 5, 300, -4, 8);    //sine x //processing.core.PApplet.map(float value, float start1, float stop1, float start2, float stop2)
        float sy = sine(sx);//sine y
        float y = map(sy, -4, 0, height/0.5f, 650);//moves down page 
        fill(255);
        stroke(255);
        line(kx, ky, x, y);
    
        kx = x;
        ky = y;
      }
      if (mouseX > kx-boxSize && mouseX < kx+boxSize && 
        mouseY > ky-boxSize && mouseY < ky+boxSize)
    {
      overSig = true;  
      if(!locked) { 
      for(float i = 0; i < 2; i++)
      {       
        for (float x=6;  x<width/6.5; x+=step)
        {
        
        float sx = map(x, 0, 200, -4, 3);    //sine x //processing.core.PApplet.map(float value, float start1, float stop1, float start2, float stop2)
        float sy = sine(sx);//sine y
        float y = map(sy, -4, 0, height/0.5f, 650);//moves down page 
        strokeWeight(2);
        stroke(255, 255, 0); 
        fill(0);
        
        line(kx, ky, x+(i*50f), y);
        
        kx = x+(i*50);
        ky = y;
        }
      }
      l += 0.3;  
      k3  += (k-k3)/500;
      } 
    } 
    else {
      stroke(255);
      fill(255);
      overSig = false;
      }
  
      l += 0.3;  
      k3  += (k-k3)/500;
    
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
            radar.render();
            radar.update();

            //for the sine wave aka radio wave
            k=random(10, 15);
            fill(169, 59, 171);
            textSize(30);
            text("Radio Signal",133 ,492);
            sinew();
            noFill();
            noStroke();

            for(Planets p: planets){
                p.render();
                fill(255);
                 ellipse(width, 300, radius*2, radius*2);
                
            }
            for(Planets pb: planets){
                fill(58, 59, 171);
                textSize(20);
                pb.render();
                text("ERUPTUS",400 ,164);
                text("EARTH",400 ,228);
                text("KEPLER",400 ,292);
                text("GLIESE",400 ,351);
                text("CRIM", 400 ,414);
                
            }
                for(Circle cr: circle)
                {
                    noFill();
                    textSize(15);
                    cr.render();
                    text("Oxygen",100, 100);
                    text("Feul",200,100);
                    text("Water Supply", 300, 100);
                }

                for(int m = 0; m < mini.size(); m++)
                {
                    mini.get(m).render();
                    mini.get(m).move();
                }
                    for(int x = 0; x < elements.size(); x++){
                        elements.get(x).render();
                    }

             }else if (start == 2){ //eruptus
                background(0);
                but.backButton();
                fill(0, 0, 255);
                textSize(20);
                textAlign(CENTER);
                text("Back", 132, 50);
                noFill();
                image(s1,width - 550 ,height - 700, 450,450);
                for(int e = 0; e < DataErup.size(); e++)
                {
                drawErupdata();
                }

             }else if (start == 3){ //earth
                background(0);
                but.backButton();
                image(s2,width - 550 ,height - 700, 450,450);
                for(int e = 0; e < DataE.size(); e++)
                {
                drawEarthdata();
                }
                
             }else if (start == 4){
                background(0);
                but.backButton();
                image(s3,width - 550 ,height - 700, 450,450);
                for(int e = 0; e < DataKep.size(); e++)
            {
                drawKepdata();
            }

             }else if (start == 5){
                background(0);
                but.backButton();
                image(s4,width - 550 ,height - 700, 450,450);
                for(int e = 0; e < DataGli.size(); e++)
                {
                drawGlidata();
                }
             }else if (start == 6){
                background(0);
                but.backButton();
                image(s5,width - 550 ,height - 700, 450,450);
                for(int e = 0; e < DataCri.size(); e++)
                {
                drawCridata();
                }
             }
            
         
       
        //button.mousePressed();
        
    //    mc.update();
    //     mc.render();
    //    ship.render();

        // if (checkKey(LEFT))
        // {
        //     System.out.println("Left arrow key pressed");
        // }
    }
    public void loadEarthdata() 
    {
        Table table = loadTable("earth.csv", "header");
        for (TableRow row : table.rows()) 
        {
            Planetdata eData = new Planetdata(row);
            DataE.add(eData);
        }
    }
    public void drawEarthdata()
    {
        for(Planetdata eData : DataE)
        {
            stroke(255);
            fill(255);
            textSize(20);
            textAlign(LEFT);
            text(eData.getName(), 0, 0);
            text(eData.getAbout(), 100, 230);
            text(eData.getRace(), 100, 260, 500, 450);
            noFill();
            noStroke();
        }
    } 


    public void loadErupdata() 
    {
        Table table = loadTable("eruptus.csv", "header");
        for (TableRow row : table.rows()) 
        {
            Planetdata erupData = new Planetdata(row);
            DataErup.add(erupData);
        }
    }
    public void drawErupdata()
    {
        for(Planetdata erupData : DataErup)
        {
            stroke(255);
            fill(255);
            textSize(20);
            textAlign(LEFT);
            text(erupData.getName(), 0, 0);
            text(erupData.getAbout(), 100, 230);
            text(erupData.getRace(), 100, 260, 500, 450);
            noFill();
            noStroke();
        }
    } 
//kepler
    public void loadKepdata() 
    {
        Table table = loadTable("kepler.csv", "header");
        for (TableRow row : table.rows()) 
        {
            Planetdata kepData = new Planetdata(row);
            DataKep.add(kepData);
        }
    }
    public void drawKepdata()
    {
        for(Planetdata kepData : DataKep)
        {
            stroke(255);
            fill(255);
            textSize(20);
            textAlign(LEFT);
            text(kepData.getName(), 0, 0);
            text(kepData.getAbout(), 100, 230);
            text(kepData.getRace(), 100, 260, 500, 450);
            noFill();
            noStroke();
        }
    } 
    //gliese
    public void loadGlidata() 
    {
        Table table = loadTable("gliese.csv", "header");
        for (TableRow row : table.rows()) 
        {
            Planetdata gliData = new Planetdata(row);
            DataGli.add(gliData);
        }
    }
    public void drawGlidata()
    {
        for(Planetdata gliData : DataGli)
        {
            stroke(255);
            fill(255);
            textSize(20);
            textAlign(LEFT);
            text(gliData.getName(), 0, 0);
            text(gliData.getAbout(), 100, 230);
            text(gliData.getRace(), 100, 260, 500, 450);
            noFill();
            noStroke();
        }
    }
    //crim
    public void loadCridata() 
    {
        Table table = loadTable("crim.csv", "header");
        for (TableRow row : table.rows()) 
        {
            Planetdata criData = new Planetdata(row);
            DataCri.add(criData);
        }
    }
    public void drawCridata()
    {
        for(Planetdata criData : DataCri)
        {
            stroke(255);
            fill(255);
            textSize(20);
            textAlign(LEFT);
            text(criData.getName(), 0, 0);
            text(criData.getAbout(), 100, 230);
            text(criData.getRace(), 100, 260, 500, 450);
            noFill();
            noStroke();
        }
    }
}

