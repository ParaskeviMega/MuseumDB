/* The exhibit class that manages the
(id, title, artist, date, culture, description)
variables of the created exhibit
*/
public class Exhibit {
    private int id, date;
    private String title, artist, culture, description;

    public Exhibit() {}

    public Exhibit(int id, String title, String artist, int date, String culture, String description) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.date = date;
        this.culture = culture;
        this.description = description;
    }

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