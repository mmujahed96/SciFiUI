package ie.tudublin;

import processing.core.PApplet;

public class Button
{
    UI ui;
    private float x;
    private float y;
    private float width;
    private float height;
    private String text;
    private int mouseY;
    private int mouseX;
    

    public Button(UI ui, float x, float y, float width, float height, String text)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
    }

    public void render()//this is the image of the the circle
    {
        ui.noFill();
        ui.stroke(0, 0, 255);
        
       // ui.ellipse(x , y, width/2, height/2);
        ui.ellipse(x , y, width/2, height/2);
        ui.ellipse(x, y, width/4, height/4);
        ui.ellipse(x, y, width/5, height/5);
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text(text, x + width * 0.5f, y + height * 0.5f);
    }
        
    public void update()
    {
        if (mouseX > width/4)
        { //the curser goes to x bigger than the number the background turns orange
            // background(255, 100, 0);
            ui.fill(255, 0, 0);
            ui.ellipse(x, y, width/4, height/4);
        }else if (mouseY < width/2)
        { //the curser goes to x bigger than the number the background turns blue
            //background(0, 0, 255);
            ui.fill(0, 0, 255); // blue
           // ui.ellipse(x , y, width/2, height/2);// after the orange bg the blue circle appears
         }
    }
     
}
    
