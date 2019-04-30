package ie.tudublin;

import java.util.ArrayList;
import ddf.minim.AudioPlayer;
import ddf.minim.AudioInput;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.Table;
import processing.data.TableRow;



public class UI extends PApplet
{
    Minim minim, wMinim;    
    ArrayList <UIElement> elements = new ArrayList<UIElement>();
    ArrayList <Button> button = new ArrayList<Button>();
    ArrayList <Planets> planets = new ArrayList<Planets>();
    ArrayList <Circle> circle = new ArrayList<Circle>();
    ArrayList <Minimap> lines = new ArrayList<Minimap>();
    ArrayList <Minimap> mini = new ArrayList<Minimap>();
    ArrayList <Fan> fan = new ArrayList<Fan>();
    AudioPlayer[] sounds = new AudioPlayer[3];
    Boxcolor[] b1 = new Boxcolor[5];

    private ArrayList<Planetdata> DataE = new ArrayList<Planetdata>();  //earth data
    private ArrayList<Planetdata> DataErup = new ArrayList<Planetdata>();  //eruptus data
    private ArrayList<Planetdata> DataKep = new ArrayList<Planetdata>();  //keplet data
    private ArrayList<Planetdata> DataGli = new ArrayList<Planetdata>();  //gliese data
    private ArrayList<Planetdata> DataCri = new ArrayList<Planetdata>();  //crim data
    private ArrayList<Text> Textinfo = new ArrayList<Text>();

    MovingCircle mc;
    Radar radar;
    Background bg;
    int start = 0;
    boolean[] keys = new boolean[1024];
    PImage stary;
    Button but;
    //Fan fan;
    PImage s1,s2,s3,s4,s5;
    float radius = 0;
    //Minimap mini;
    AudioPlayer sound, wSound;
    Globe arglobe;

    


    //for the sine wave
    float k = 10.0f;
    float k1 = 0.5f;
    float k2 = 0.5f;
    float k3 = 10.0f;
    float l = 15.0f;
    float step = 1;

    float b1x = 35;
    float b1y = 139;

    public void keyPressed()
    {
        keys[keyCode] = true;
        if(keyPressed)
                {
                    if (keyCode == ENTER ) //space bar
                    {
                        start = 1;
                    }
                }if (keyCode == BACKSPACE)
                {
                    start = 1;
                }

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
        //size(800, 800, P3D);
        // Use fullscreen instead of size to make your interface fullscreen
       fullScreen(P3D); 
    }

    public void setup()
    {
        //loading 
        button.add(new Button(this, width/2, height/2, 500, 500));//UI ui, float x, float y, float width, float height, String text
        button.add(new Button(this,width/2, height/2, 120, 120));
        button.add(new Button(this,width/2, height/2, 400, 400));
        button.add(new Button(this,width/2, height/2, 330, 330));
        // mc = new MovingCircle(this, width / 2, height / 2, 50);
        radar = new Radar(this, 0.4f, 404, 562, 75 );//UI ui, float frequency, float x, float y, float radius
        bg = new Background(0, 0, 30,this);
        elements.add(new Box(1150, 4, 210, 220,this)); // mini map box
        elements.add(new Box(1047,428,300,330,this));// info box
        elements.add(new Box(1051,436,290,315,this));
        elements.add(new Box(30,454,248,310,this)); //sine wave box
        arglobe = new Globe(780, 350, PI + 1.2f, PI / 6, PI + 1.6f, PI / 4, PI + 0.7f, this);

        //lines for the orbit
        for(int i = 0; i < 5; i++)
        {
            Minimap ni = new Minimap(1256 ,114 , 200+(i*-35), this);
            lines.add(ni);
        }
        //2 large planets 
        for(int i = 0; i < 2; i++)
        {
            
            Minimap ni = new Minimap(1173+(i*20) ,111+(i*80) , 20, this);
            lines.add(ni);
            
        }
        //2 smaller planets to the Star(sun) in the middle
        for(int i = 0; i < 2; i++)
        {
            
            Minimap ni = new Minimap(1252+(i*20) ,49+(i*110) , 10, this);
            lines.add(ni);
            
        }

        //rectangles and button rectangle inside
        for(int i = 0; i < 5; i++)
        {
            Planets p = new Planets(30 ,139 +(i*62) , 450, 60, this);
            Planets pb = new Planets(332 ,144 +(i*62) , 144, 50, this);
            planets.add(p);
            planets.add(pb);
        }
        //circles with percentages
        for(int i = 0; i < 4; i++)
        {
            int text = (int)random(50,100);
            Circle cir = new Circle(100 +(i*100), 46, 75, 75, text, this);
            circle.add(cir);
        }

        for(int i = 0; i < 2; i++)
        {
            int text = (int)random(50,100);
            Circle cir = new Circle(1180 +(i*100), 285, 75, 75, text, this);
            circle.add(cir);
        }

        for(int i = 0; i < 2; i++)
        {
            int text = (int)random(50,100);
            Circle cir = new Circle(1180+(i*100), 380, 75, 75, text, this);
            circle.add(cir);
        }

        //fan 
        for(int i = 0; i < 6; i++)
        {
            //int space = 10;   
            Fan f = new Fan(413 +(i*100), 710, 100, 100, this);
            fan.add(f);
        }
        //inside planet rectangles change color
        for(int i =0; i < 5; i++)
        {
            b1[i] = new Boxcolor(b1x,b1y, 115, 168, this);
            // b1y += 10;
            // b1x += 10;
        }

        //img
        s1 = loadImage("exo.jpg");
        s2 = loadImage("dearth.jpg");
        s3 = loadImage("gliese667c.jpg");
        s4 = loadImage("Kepler62f.jpg");
        s5 = loadImage("HWVir.jpg");
        //stary = loadImage("bg.jpg");

        //planet info
        loadEarthdata(); 
        loadErupdata();
        loadKepdata();
        loadGlidata(); 
        loadCridata();
        loadInfoText();

        minim = new Minim(this);
        wMinim = new Minim(this);
        sounds[1] = minim.loadFile("GUI_Select_22.mp3");
        sounds[2] = minim.loadFile("GUI_Notification 13");
        sounds[2] = minim.loadFile("GUI_Notification 14");
        // sounds.play()
        //sound = minim.loadFile("GUI_Select_22.mp3");
    }
     
    public void mousePressed()
    {
        if((mouseX > 332 && mouseX < 475) && (mouseY > 144 && mouseY < 192))//planet 1
        {
            start = 2;
           // sound[1].play();
           
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
        text("Press Enter", cx, cy);
        noFill();
        fill(0, 100);
        ellipse(cx, cy, spiral -250 , spiral - 250);
        arc(0,0,outline,outline,0,PI);
        noFill();
        noStroke();
    }     

    public void globe(){
        fill(255);
        lights();
        translate(767, 365, 100);
        float radius = 150;
        int t =100;
        rotateX((mouseX)/ width * 2 *PI);
        rotateY((frameCount)/50);
        for(int i =0; i < t; i++)
        {
            float longitude = map(i, 0, t, -PI, PI);
            for(int j = 0; j < t; j++)
            {
                float latitude = map( j, 0, t, -HALF_PI, HALF_PI);
                float x = radius * sin(longitude) * cos(latitude);
                float y = radius * sin(longitude) * sin(latitude);
                float z = radius * cos(longitude);
                stroke(59, 89, 171); 
                strokeWeight(2);
                point(x, y, z);
            }
        }
        noStroke();
    }

//sine wave
    
    public float sine(float x) {
      return k1*pow(k2/(k2+pow(x, 4)), k2)*cos(k3*x-l);
    }
    public void sinew()
    {
      float kx = 0.0f;
      float ky = width/2;
      boolean overSig = false;
      boolean locked = false;
      fill(169, 59, 171);
      textSize(30);
      textAlign(CENTER);
      text("Radio Signal",136 ,492);
      noFill();
      noStroke();
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
        }//end for
        wSound = wMinim.loadFile("Glitch Sound Effects.mp3");
        wSound.play(); 
      }//end for
      l += 0.3;  
      k3  += (k-k3)/500;
      }//end if stat
         
    } // end if statment 
    else {
        
      stroke(255);
      fill(255);
      overSig = false;
    }    
        l += 0.3;  
        k3  += (k-k3)/500;
        //wSound.pause();
    }


    public void draw()
    {   
        background(0);
        
        line(20,20, mouseX, mouseY);
        println(mouseX, mouseY); // find out xy co-ordinate line of infinate length from one point to x and y of my mouse
        //bg.render();
        if (start == 0){
            loading();
            for(int b = 0; b < button.size(); b++)
            {
                button.get(b).render();
            }      
        }else if (start == 1){
            
            radar.render();

            radar.update();
           
            //for the sine wave aka radio wave
            k=random(10, 15);
            sinew();
            

            for (int i=0;i<2;i++)
            {
                b1[i].render();
            }

            for(Planets p: planets){
                p.render();
            }
            for(Planets pb: planets){
                fill(58, 59, 171);
                textSize(20);
                textAlign(CENTER, CENTER);
                pb.render();
                text("ERUPTUS",400 ,164);
                text("EARTH",400 ,228);
                text("KEPLER",400 ,292);
                text("GLIESE",400 ,351);
                text("CRIM", 400 ,414);
            }
            //bg.render();

            for(Circle cr: circle)
                {
                noFill();
                textSize(15);
                cr.render();
                text("Oxygen",100, 100);
                text("Feul",200,100);
                text("Water Supply", 300, 100);
                text("Status", 400, 100);
               // cr.update();
            }
            for(int t = 0; t < Textinfo.size(); t++){
                drawInfoText();
            }
            for(Minimap ni: lines)
            {
                ni.render();
            }
            //boxes
            for(int x = 0; x < elements.size(); x++)
            {
                elements.get(x).render();
            }
            //fan
            for(Fan f: fan)
            {
                
                f.render();
            }
           //arcs around globe
           arglobe.render();
           globe();
           bg.render();
           //bg.render(); 
           

        }else if (start == 2){ //eruptus
            background(0);
            image(s1,width - 1250 ,height - 600, 450,350);
            for(int e = 0; e < DataErup.size(); e++)
            {
            drawErupdata();
            }

        }else if (start == 3){ //earth
            background(0);
            image(s2,width - 1150 ,height - 600, 350,350);
            for(int e = 0; e < DataE.size(); e++)
            {
                drawEarthdata();
            }

        }else if (start == 4){
            background(0);
            image(s3,width - 1250 ,height - 600, 450,350);
            for(int e = 0; e < DataKep.size(); e++)
            {
                drawKepdata();
            }

        }else if (start == 5){
            background(0);
            image(s4,width - 1250 ,height - 600, 450,350);
            for(int e = 0; e < DataGli.size(); e++)
            {
                drawGlidata();
            }
        }else if (start == 6){
            background(0);
            image(s5,width - 1250 ,height - 600, 450,350);
            for(int e = 0; e < DataCri.size(); e++)
            {
                drawCridata();
            }
        }

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
            textSize(15);
            textAlign(LEFT);
            text(eData.getName(), 712, 193 );
            text(eData.getAbout(), 712, 210, 500, 450 );
            text(eData.getSpecies(), 712, 553 );
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
            text(erupData.getName(), 712, 193);
            text(erupData.getAbout(),712, 282, 500, 450); 
            text(erupData.getSpecies(), 712, 553);
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
            text(kepData.getName(), 712, 193);
            text(kepData.getAbout(), 712, 282, 500, 450);
            text(kepData.getSpecies(), 712, 553);
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
            text(gliData.getName(), 712, 193);
            text(gliData.getAbout(), 712, 282, 500, 450 );
            text(gliData.getSpecies(), 712, 533);
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
            text(criData.getName(), 712, 193);
            text(criData.getAbout(), 712, 282, 500, 450 );
            text(criData.getSpecies(), 712, 533 );
            noFill();
            noStroke();
        }
    }
    public void loadInfoText() 
    {
        Table table = loadTable("coord.csv", "header");
        for (TableRow row : table.rows()) 
        {
            Text infoText = new Text(row);
            Textinfo.add(infoText);
        }
    }
    public void drawInfoText()
    {
        for(Text infoText : Textinfo)
        {
            stroke(255);
            fill(255);
            textSize(15);
            textAlign(LEFT);
            text(infoText.getCurloc(), 1060, 487, 300, 200);
            text(infoText.getDistance(), 1060, 575);
            text(infoText.getSystem(), 1060, 611, 300, 200);
            noFill();
            noStroke();
            strokeWeight(1);
        }
    }
    
}

