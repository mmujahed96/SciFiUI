package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class Minimap extends UIElement
{
    int size; // fields 
    float radius;
    PVector pos;
    float frequency;
    float spin = 0;
    float r, g, b;

    public Minimap (float x, float y, float frequency, int size , float r, float g, float b, PApplet ui)
    {
        super(x, y, ui);
        //this.wd = (int) (width / 2);
        this.size = size;
        this.frequency = frequency;
        pos = new PVector(x, y);
        this.radius = radius;
        this.r = r;
        this.g = g;
        this.b = b;
    }
    
   
    public void render()
    {
        ui.pushMatrix();        
        ui.stroke(0, 200, 0);
        ui.translate(pos.x, pos.y);
        ui.rotate(spin);
        ui.fill(r, g, 0, 75);
        ui.ellipse(pos.x,pos.y,size, size); //circle for the suns
        ui.noFill();
        
        
        
         ui.popMatrix();
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