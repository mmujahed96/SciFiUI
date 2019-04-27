package ie.tudublin;

import processing.core.PApplet;

public class Sine extends UIElement
{
    private int size; // fields 
    private float width;
    private float height;
    private float radius;
    private int xa = 2; // x axis
    private int ya = 1; //y axis
    private int c1, c2;


    public Sine(float x, float y, float width, float height , PApplet ui)

    {
        super(x, y, ui);
        this.size = size;
        //this.wd = (int) (width / 2);
        this.width = width;
        this.height = height;

    }

    public void render()
    {
       // ui.strokeWeight(0.1f);
        ui.stroke(77, 242, 217);
        ui.noFill();
        ui.rect(x, y, width, height);
        ui.noStroke();
        //ui.strokeWeight(1);
        

    }
}