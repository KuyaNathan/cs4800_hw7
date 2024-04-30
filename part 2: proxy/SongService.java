import java.util.List;

public interface SongService {
    Song searchByID(int songID);
    List<Song> searchByTitle(String title);
    List<Song> searchByAlbum(String album);
}
