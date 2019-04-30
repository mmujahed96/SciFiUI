package ie.tudublin;

import processing.core.PApplet;

public class Minimap extends UIElement
{
    private float size; // fields 
    private float radius;

    public Minimap (float x, float y, float size , PApplet ui)
    {
        super(x, y, ui);
        this.size = size;
        //this.wd = (int) (width / 2);
        //this.radius = radius;

    }
    float spin = 0;
   
    public void render()
    {
        ui.noFill();
        ui.strokeWeight(1);
        ui.stroke(0,200,200);
        ui.ellipse(x, y, size, size);
        ui.noStroke();  
        

    }
}    