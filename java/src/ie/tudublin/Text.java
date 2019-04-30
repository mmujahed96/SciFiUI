package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Text {
    private String distance;
    private String system;
    private String curloc;


    public Text(TableRow row)//constructor
    {
        this.curloc = row.getString("CurLoc");
        this.distance = row.getString("Distance");
        this.system = row.getString("System");
       
        
    }

    /**
     * @return the distance
     */
    public String getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(String distance) {
        this.distance = distance;
    }

    /**
     * @return the system
     */
    public String getSystem() {
        return system;
    }

    /**
     * @param system the system to set
     */
    public void setSystem(String system) {
        this.system = system;
    }

    /**
     * @return the curloc
     */
    public String getCurloc() {
        return curloc;
    }

    /**
	 * @param curloc the curloc to set
	 */
	public void setCurloc(String curloc) {
		this.curloc = curloc;
    }
}    

  