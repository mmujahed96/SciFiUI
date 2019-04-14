package ie.tudublin;

import processing.core.PApplet;

public class Circle extends UIElement
{
    private int size; // fields 

    public Circle(float x, float y, int size , PApplet ui)

    {
        super(x, y, ui);
        this.size = size;
        

    }

    public void render()
    {
        ui.ellipse(x, y, size,size);

    }
}