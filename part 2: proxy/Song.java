public class Song {
    private int id;
    private String title;
    private String artist;
    private String album;
    private double duration;

    public Song(int id, String title, String artist, String album, double duration){
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public void showSongDetails(){
        System.out.println("Song Title: " + getTitle() + ", Artist: " +
                getArtist() + ", Album: " + getAlbum() + ", Duration: " +
                getDuration());
    }

    public int getID(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getArtist(){
        return artist;
    }

    public String getAlbum(){
        return album;
    }

    public double getDuration(){
        return duration;
    }
}
