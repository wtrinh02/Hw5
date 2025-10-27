package Proxy;

public class Song {

    private int id;
    private String title;
    private String album;
    public Song(String title, Integer songID, String album){
        this.title = title;
        this.id = songID;
        this.album = album;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAlbum() {
        return album;
    }

}
