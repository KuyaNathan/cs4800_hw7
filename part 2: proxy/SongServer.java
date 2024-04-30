import java.util.ArrayList;
import java.util.List;

public class SongServer implements SongService{
    private final List<Song> songsList;

    public SongServer(List<Song> songsList) {
        this.songsList = songsList;
    }

    public Song searchByID(int songID){
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        for(Song song: songsList){
            if(song.getID() == songID){
                return song;
            }
        }
        return null;
    }

    public List<Song> searchByTitle(String title){
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        List<Song> searchResults = new ArrayList<>();
        for(Song song: songsList){
            if(song.getTitle().equalsIgnoreCase(title)){
                searchResults.add(song);
            }
        }
        return searchResults;
    }

    public List<Song> searchByAlbum(String album){
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        List<Song> searchResults = new ArrayList<>();
        for(Song song: songsList){
            if(song.getAlbum().equalsIgnoreCase(album)){
                searchResults.add(song);
            }
        }
        return searchResults;
    }

    public void showSongsList(){
        System.out.println("Server songs list:");
        for(Song song: songsList){
            System.out.print(song.getTitle() + ", ");
        }
        System.out.println("\n");
    }
}
