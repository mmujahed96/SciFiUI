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
    

    public Button(UI ui, float x, float y, float width, float height)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
    }

    public void render()//this is the image of the the circle
    {
        ui.strokeWeight(3);
        ui.noFill();
        ui.stroke(26, 206, 246);

        ui.ellipse(x, y, width, height);//kel
        ui.noStroke();
        ui.strokeWeight(1); //cancels out the first one
    }
        
    // public void mousePressed()
    // {
    //         //background(204);
    //         if (ui.mousePressed == true) {
    //           ui.fill(255); // White
    //         } else {
    //           ui.fill(0); // Black
    //         }

    // }
    public void backButton()
    {
      ui.fill(255, 0, 255);
      ui.rect(x,y,width, height);
    }
     
}
