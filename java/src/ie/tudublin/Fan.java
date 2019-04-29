package ie.tudublin;

import processing.core.PApplet;

public class Fan extends UIElement
{
    private int size; // fields 
    private float width;
    private float height;
    private int CENTER;

    public Fan(float x, float y, float width, float height , PApplet ui)
    {
        super(x, y, ui);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    float spin = 0;
    public void render()
    {
        ui.noFill();
        ui.strokeWeight(1);
        ui.stroke(0,255,200);
        ui.ellipse(x, y, width, height);
        ui.noStroke();  

        ui.pushMatrix();
        ui.translate(x,y); //keeps the arc with the circles

        ui.rotate(spin);

        int outline = 75;
       // perpeler like drawing
        for(int i =0; i< 3; i++) //  thickness of arc

        {
            ui.strokeWeight(1);
            //ui.stroke(0 + (i*50),0 + (i*200),0 + (i*25));
            ui.noStroke();
            //ui.arc(0,0,outline,outline,0,ui.PI); // size of semi arc | starting point
            ui.circle(0, 0, outline);
            ui.stroke(0 + (i*50),0 + (i*150),0 + (i*25));
            ui.ellipse(0, 0, ui.PI, outline);
            ui.noFill();
            ui.stroke(0 + (i*500),0 + (i*200),0 + (i*25));
            ui.ellipse(0, 0, outline, ui.PI);
            
            outline += 3 ; // size
            ui.noStroke();
            //ui.noEllispseMode();
        }
        ui.popMatrix();

        spin -= 0.5f; // rotation speed
        ui.noFill();
        ui.noStroke();
     

    }
}