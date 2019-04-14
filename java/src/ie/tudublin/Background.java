package ie.tudublin;

import processing.core.PApplet;

public class Background 
{
    private int size; // fields 
    private float width;
    private float height;
    //private int CENTER;
    //private int wd;
    UI ui;
    private float x;
    private float y;

    public Background(float x, float y, int size, UI ui )
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        

    }

    public void render()
    {
        ui.stroke(255, 0, 255);
        //ui.line(height/2, , size , size);
        ui.noFill();
       
       for(float x = 0; x < width; x = x + 20){
           for(float y = 0; y < height; y = y + 20){
        ui.rect(x , y, size, size);
           }
       }

    }
    // public void mousePressed()
    // {
    //     keys[keyCode] = true;
    // }
}