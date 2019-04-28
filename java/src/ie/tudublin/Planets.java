package ie.tudublin;

import processing.core.PApplet;

public class Planets extends UIElement
{
    private int size; // fields 
    private float width;
    private float height;
    //private int CENTER;
    //private int wd;
    private String text;

    public Planets(float x, float y, float width, float height, PApplet ui)

    {
        super(x, y, ui);
        this.size = size;
        //this.wd = (int) (width / 2);
        this.width = width;
        this.height = height;
        this.text = text;

    }

    public void render()
    {
        ui.strokeWeight(1);
        ui.stroke(77, 242, 217);
        ui.lights();
        //ui.line(height/2, , size , size);
        ui.noFill();
        ui.rect(x, y, width, height);
       ui.noStroke();
       ui.strokeWeight(1);

    }
   
    
}