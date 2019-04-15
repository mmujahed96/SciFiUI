package ie.tudublin;

import processing.core.PApplet;

public class Background extends UIElement
{
    private int size; // fields 
    private float width;
    private float height;
    //private int CENTER;
    //private int wd;

    public Background(float x, float y, int size , PApplet ui)

    {
        super(x, y, ui);
        this.size = size;
        //this.wd = (int) (width / 2);

    }

    public void render()
    {
        ui.stroke(77, 242, 217);
        //ui.line(height/2, , size , size);
        ui.noFill();
       // ui.ellipseMode(CENTER);

    }
    public void map()
    {
        for(float x = 0; x < ui.width; x = x + 35){
            for(float y = 0; y < ui.height; y = y + 35){
         ui.rect(x , y, size, size);
            }
        }
    }
    // public void mousePressed()
    // {
    //     keys[keyCode] = true;
    // }
}