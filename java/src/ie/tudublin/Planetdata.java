package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Planetdata {
    private String name;
    private String about;
    private String race;

    public Planetdata(TableRow row)//constructor
    {   this.name = row.getString("Name");
        this.about = row.getString("About");
        this.race = row.getString("Race");
    }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the about
	 */
	public String getAbout() {
		return about;
	}

	/**
	 * @param about the about to set
	 */
	public void setAbout(String about) {
		this.about = about;
	}

	/**
	 * @return the race
	 */
	public String getRace() {
		return race;
	}

	/**
	 * @param race the race to set
	 */
	public void setRace(String race) {
		this.race = race;
	}
}