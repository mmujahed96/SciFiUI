package ie.tudublin;

import processing.core.PApplet;

public class Minimap extends UIElement
{
    private int size; // fields 
    private float width;
    private float height;
    //private int CENTER;
    //private int wd;

    public Minimap (float x, float y, float width, float height , PApplet ui)
    {
        super(x, y, ui);
        this.size = size;
        //this.wd = (int) (width / 2);
        this.width = width;
        this.height = height;

    }
   
    public void render()
    {
        ui.noFill();
        ui.strokeWeight(1);
        ui.stroke(0,200,200);
        ui.ellipse(x, y, width, height);
        ui.noStroke();  
        
    }
}    