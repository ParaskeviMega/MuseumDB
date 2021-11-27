import java.io.Serializable;

public class Exhibit implements Serializable {
    // id, title, artist, date, culture, description
    private int id, date;
    private String title, artist, culture, description;

    public Exhibit() {

    }

    /*public Exhibit(int roll, String name, String course, String address) {
        this.rollNo = roll;
        this.name = name;
        this.course = course;
        this.address = address;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}