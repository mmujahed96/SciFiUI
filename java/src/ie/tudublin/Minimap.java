package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Minimap extends UIElement
{
    private int size; // fields 
    private float radius;
    private PVector pos;
    private float frequency;
    private float spin = 0;

    public Minimap (float x, float y, float frequency, float radius , PApplet ui)
    {
        super(x, y, ui);
        //this.wd = (int) (width / 2);
        this.frequency = frequency;
        pos = new PVector(x, y);
        this.radius = radius;
    }
    
   
    public void render()
    {
        ui.pushMatrix();        
        ui.noFill();
        ui.stroke(0, 200, 0);
        ui.translate(pos.x, pos.y);
        ui.rotate(spin);
        ui.ellipse(0, 0, radius * 2, radius * 2);
        for(int i = 0; i < 2 ; i++)
        {
            //int  = 0;

        ui.ellipse(0,0,radius*.5f,radius*.5f); //circle for the suns
        ui.fill(255, 0, 0, 75);
        ui.ellipse(50 +(i*.5f),0 +(i*.006f) , radius * .4f, radius * 0.4f);// small red planet
        ui.noFill();
        ui.ellipse(20 +(i*.10f),0 +(i*.006f) , radius * .4f, radius * 0.4f);
        
        }
        ui.popMatrix();
        

         ui.ellipse(pos.x, pos.y, radius * 2, radius * 2);
        //  ui.ellipse(pos.x, pos.y, radius * 0.08f, radius * 0.8f);
        //  ui.ellipse(pos.x, pos.y, radius * .05f, radius * .05f);
         float x2 = pos.x + (float) Math.sin(spin) * radius;
         float y2 = pos.y - (float) Math.cos(spin) * radius;
         //ui.line(pos.x, pos.y, x2, y2);
         ui.circle(pos.x, pos.y, 50 );
    }
    float timeDelta = 1.0f/ 60.0f;
    public void move()
    {
        spin += PApplet.TWO_PI * timeDelta * frequency;
    }
    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * @return the radius
     */
    public float getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }

    /**
     * @return the pos
     */
    public PVector getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(PVector pos) {
        this.pos = pos;
    }

    /**
     * @return the frequency
     */
    public float getFrequency() {
        return frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }

    /**
     * @return the spin
     */
    public float getSpin() {
        return spin;
    }

    /**
     * @param spin the spin to set
     */
    public void setSpin(float spin) {
        this.spin = spin;
    }
}    