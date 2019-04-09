package ie.tudublin;

import processing.core.PApplet;

public abstract class UIElement
{
    protected float x;
    protected float y;
    protected PApplet ui;

    public UIElement(float x, float y, PApplet ui)// constructor
    {
        this.x = x;
        this.y = y;
        this.ui = ui;
    }

    public abstract void render();
}