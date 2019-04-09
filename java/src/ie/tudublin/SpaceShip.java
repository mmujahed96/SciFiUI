package ie.tudublin;

import processing.core.PApplet;

public class SpaceShip extends UIElement
{
    private int size; // fields 

    public SpaceShip(float x, float y, int size , PApplet ui)

    {
        super(x, y, ui);
        this.size = size;

    }

    public void render()
    {
        ui.rect(x, y, size,size);

    }
}