package ie.tudublin;

import processing.core.PApplet;

public class MovingCircle
{
    private float x;
    private float dx = 1;
    private float y;
    private float diameter;
    private float radius;
    UI ui;

    public MovingCircle(UI ui, float x, float y, float diameter)
    {
        this.ui = ui;
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        radius = diameter / 2;
    }
    
    public void render()
    {
        ui.stroke(255, 0, 255);
        ui.noFill();
        ui.ellipse(x, y, diameter, diameter);
        ui.fill(255);
        // Static field
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text("Loading", x, y);
        
        //perpeler like drawing
        for(int i =0; i< 3; i++) //  thickness of arc

        {
            ui.strokeWeight(1);
            ui.stroke(0 + (i*50),0 + (i*200),0 + (i*25));
            ui.noStroke();
            //ui.arc(0,0,outline,outline,0,ui.PI); // size of semi arc | starting point
            ui.circle(0, 0, outline);
            ui.stroke(0 + (i*50),0 + (i*150),0 + (i*25));
            ui.ellipse(0, 0, outline, outline);
            ui.ellipse(0, 0, outline, ui.PI);
            
            outline += 3 ; // size
            ui.noStroke();
            //ui.noEllispseMode();
        }

    }

    public void update()
    {
        x += dx;
        if ((x > ui.width - radius) || (x < radius))
        {
            dx *= -1;
        }
    }
}
