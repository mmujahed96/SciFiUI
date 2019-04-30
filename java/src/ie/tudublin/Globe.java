package ie.tudublin;

import processing.core.PApplet;


public class Globe extends UIElement
{
    
    private float size1 = 450; // fields 
    private float size2 = 400;
    private float size3 = 425;
    private float size4 = 475; 
    private float ro1;
    private float ro2;
    private float ro3;
    private float ro4;
    private float ro5;


    public Globe(float x, float y, float ro1, float ro2, float ro3, float ro4,float ro5, PApplet ui)
    {
        super(x, y, ui);
        //this.size = size;
        this.ro1 = ro1;
        this.ro2 = ro2;
        this.ro3 = ro3;
        this.ro4 = ro4;
        this.ro5 = ro5;

    
    }
    float spin = 0;
   
    public void render()
    {
        ui.strokeWeight(10);
        ui.stroke(175, 255, 0); 
        ui.arc(x, y, size1,size1, ro4 , ro4 + 0.9f);
        ui.stroke(153,0,0); 
        ui.arc(x, y, size4, size4, ro5, ro5 + 1.5f);

        ui.strokeWeight(5);
        ui.stroke(153, 0, 0); 
        ui.arc(x, y, size3, size3, ro1 , ro1 + 0.9f);
        ui.stroke(0, 0, 153); 
        ui.arc(x, y, size2, size2, ro2, ro2 + 1.5f);

        

        ui.strokeWeight(1);
        ui.noFill();
        ui.stroke(0);

        ro1 = ro1 + 0.1f;
        ro2 = ro2 + 0.1f;
        ro3 = ro3 - 0.1f;
        ro4 = ro4 - 0.1f;
        ro5 = ro5 - 0.2f;
    }
}