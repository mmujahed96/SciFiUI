package ie.tudublin;

import processing.core.PApplet;

public class Circle extends UIElement
{
    private int size; // fields 
    private float width;
    private float height;
    private float diameter;
    private float radius;
    private float start;
    private float stop;
    protected PApplet ui;

    //public Circle(UI ui, float x, float y, float width, float height, float start, float stop)
    public Circle(PApplet ui, float x, float y, float width, float height)
    {
        super(x, y, ui);
        this.size = size;
        this.diameter = diameter;
        radius = diameter / 2;
        this.width = width;
        this.height = height;
        // this.start = start;
        // this.stop = stop;
    }

    public void render()
    {
        //ui.smooth();
        ui.noFill();
        ui.stroke(255, 255, 0);
        ui.ellipse(x, y, width/2, height/2);
        //ui.arc(x,y,ui.width, ui.height, start, stop);//a, b, c, d, start, stop
        ui.noStroke();
        
    }
}