package ie.tudublin;

import processing.core.PApplet;

public class Boxcolor extends UIElement
{
    private int width; // fields 
    private int height;

    public Boxcolor(float x, float y, int width , int height, PApplet ui)

    {
        super(x, y, ui);
        this.width = width;
        this.height =height;

    }

    public void render()
    {
        ui.noStroke();
        ui.strokeWeight(2);
        for(int sqy = 0; sqy < y + height; sqy = sqy+20)
        {
            for(int sqx = 0; sqx < y + width; sqx = sqx+20)
            {
                float qw = ui.dist(sqx, sqy, ui.mouseX, ui.mouseY);
                ui.fill(qw/1.7f,ui.random(255),ui.random(255));
                ui.rect(x + sqx, y + sqy, 50, 10);
            }
        }
    }
}