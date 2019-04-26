package ie.tudublin;

import processing.core.PApplet;

public class Minimap extends UIElement
{
    private int size; // fields 
    private float width;
    private float height;
    private int CENTER;
    //private int wd;

    public Minimap (float x, float y, float width, float height , PApplet ui)
    {
        super(x, y, ui);
        this.size = size;
        //this.wd = (int) (width / 2);
        this.width = width;
        this.height = height;

    }
    float spin = 0;
   
    public void render()
    {
        ui.noFill();
        ui.strokeWeight(1);
        ui.stroke(0,200,200);
        ui.ellipse(x, y, width, height);
        ui.noStroke();  

        ui.pushMatrix();

        ui.translate(x,y); //keeps the arc with the circles

        ui.rotate(spin);

        int outline = 100;   //  semi arc 's position

        for(int i =0; i< 1; i++) //  thickness of arc

        {
            ui.strokeWeight(1);
            ui.stroke(0 + (i*300),0 + (i*10),0 + (i*25));

            //ui.arc(0,0,outline,outline,0,ui.PI); // size of semi arc | starting point
            ui.circle(0, 0, outline);
            // ui.ellipse(0, 0, outline, outline);
            // ui.ellipse(0, 0, outline, ui.PI);
            
            outline += 2 ; // size
            ui.noStroke();
            //ui.noEllispseMode();
        }

       ui.popMatrix();

        spin -= 0.1f;
        
    }
}    