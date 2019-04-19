package ie.tudublin;

import processing.core.PApplet;

public class Circle extends UIElement

{

    private float diameter;

 

public Circle (float x, float y ,float radius, float diameter, PApplet ui)

   {

    super(x, y, ui);

   this.diameter = diameter;

   radius = diameter/2;

   }

 

    float spin = 0;

    float spin1 = 0;

    public void render()

    {

        for(int i = 0; i < 2; i++) // circles

        {

            ui.noFill();

            ui.stroke(0,200,200);

            ui.ellipse(x,y, i*(50),i*(50)); // makes static circles small / big
            //ui.noStroke();
        }

        ui.pushMatrix();

        ui.translate(x,y);

        ui.rotate(spin);

        int outline = 75;   //  semi arc 's position

        for(int i =0; i< 2; i++) //  thickness of arc

        {
            ui.strokeWeight(2);
            ui.stroke(0 + (i*30),0 + (i*10),0 + (i*25));

            ui.arc(0,0,outline,outline,0,ui.PI); // size of semi arc | starting point 

            outline += 10 ; // size
            //ui.noStroke();
        }

       ui.popMatrix();

        spin -= 0.5f; // rotation speed

     

    }

 

}

