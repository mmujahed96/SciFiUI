package ie.tudublin;

import processing.core.PApplet;

public class Box extends UIElement
{
    private int size; // fields 
    private float width;
    private float height;


    public Box(float x, float y, float width, float height , PApplet ui)

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