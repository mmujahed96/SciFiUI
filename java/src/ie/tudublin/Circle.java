//small circles with percentage
package ie.tudublin;

import processing.core.PApplet;

public class Circle extends UIElement

{

    private float diameter;
    private float random;
    private int text;
    private float radius;
 

public Circle (float x, float y ,float radius, float diameter, int text, UI ui)

   {

    super(x, y, ui);
    this.random = random;
    this.radius = radius;
    this.text = text;

   this.diameter = diameter;

   radius = diameter/2;

   }

    float spin = 0;

    public void render()

    {

        for(int i = 0; i < 2; i++) // circles

        {

            ui.noFill();

            ui.stroke(0,200,200);

            ui.ellipse(x,y, i*(70),i*(70)); // makes static circles small / big
            
            float r = random(50);   
            
            
        }
        ui.stroke(2);
        ui.fill(255);
        ui.textSize(15); 
        ui.textAlign(PApplet.CENTER, PApplet.CENTER);
        ui.text( text + "%", x, y);
        ui.noFill();
        ui.pushMatrix();

        ui.translate(x,y); //keeps the arc with the circles

        ui.rotate(spin);

        int outline = 75;   //  semi arcs position

        for(int i =0; i< 2; i++) //  thickness of arc

        {
            ui.strokeWeight(2);
            ui.stroke(0 + (i*300),0 + (i*10),0 + (i*25));

            ui.arc(0,0,outline,outline,0,ui.PI); // size of semi arc 

            outline += 10 ; // size
            ui.noStroke();
        }

       ui.popMatrix();

        spin -= 0.1f; // rotation speed
        ui.noFill();
        ui.noStroke();
     

    }

    private float random(int i) {
        return 0;
    }

 

}

