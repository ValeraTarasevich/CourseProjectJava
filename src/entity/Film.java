package entity;

public class Film {

    private final String URL = "content/films/";
    private final String URL_VIDEO ="content/video/";

    private int id;
    private String name;
    private int year;
    private String country;
    private String style;
    private String video;
    private String photo;

    public Film() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photoName) {
        if (!photoName.contains(URL))
        {
            this.photo = URL+photoName;
        }
        else {
            this.photo = photoName;
        }
    }
    public String getVideo() {
        return video;
    }

    public void setVideo(String videoName) {
        if (!videoName.contains(URL_VIDEO))
        {
            this.video = URL_VIDEO+videoName;
        }
        else {
            this.video = videoName;
        }
    }
}
