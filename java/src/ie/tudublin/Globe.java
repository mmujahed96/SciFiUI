package ie.tudublin;

import processing.core.PApplet;
import processing.core.PShape;
//import processing.core.PVector;

public class Globe
{
    
    int size; // fields 
    private float width;
    private float lon;
    private float lat;
    private float radius;
    //private int CENTER;
    //private PVector globe;
    PShape globe;
    PApplet ui;
    private float total;
    //private int wd;


    public Globe(int size, PApplet ui)
    {
        //super(x, y, ui);
        this.size = size;
        //this.wd = (int) (width / 2);
        // this.lon = lon;
        // this.lat = lat;
        // this.radius = radius;
        //globe = new PVector[total+1][total+1];
        this.ui = ui;


    }
    float spin = 0;
   
    public void render()
    {
        globe = ui.createShape(ui.SPHERE, size); 
       // globe.setTexture(planet);
        ui.noStroke();
        ui.shape(globe);
    }
}