import java.util.ArrayList;
import java.util.List;

public class SongProxy implements SongService{
    private final SongServer songServer;
    private List<Song> songsCache = new ArrayList<>();

    public SongProxy(SongServer songServer, List<Song> songsCache){
        this.songServer = songServer;
        this.songsCache = songsCache;
    }

    public Song searchByID(int songID){
        System.out.println("Searching...");
        for(Song song: songsCache){
            if(song.getID() == songID){
                System.out.println("Found!");
                return song;
            }
        }
        Song fetchedFromServer = songServer.searchByID(songID);
        if(fetchedFromServer != null){
            System.out.println("Found!");
            songsCache.add(fetchedFromServer);
        }
        return fetchedFromServer;
    }

    public List<Song> searchByTitle(String title){
        List<Song> searchResults = new ArrayList<>();
        System.out.println("Searching...");
        for(Song song: songsCache){
            if(song.getTitle().equalsIgnoreCase(title)) {
                searchResults.add(song);
            }
        }

        List<Song> fetchedFromServer = songServer.searchByTitle(title);
        for(Song song: fetchedFromServer){
            if(!songsCache.contains(song)){
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}

                songsCache.add(song);
                searchResults.add(song);
            }
        }
        if(searchResults.isEmpty()){
            System.out.println("No matches found.");
            return null;
        }
        System.out.println("Found");
        return searchResults;
    }

    public List<Song> searchByAlbum(String album){
        List<Song> searchResults = new ArrayList<>();
        for(Song song: songsCache){
            if(song.getAlbum().equalsIgnoreCase(album)) {
                searchResults.add(song);
            }
        }

        List<Song> fetchedFromServer = songServer.searchByAlbum(album);
        for(Song song: fetchedFromServer){
            if(!songsCache.contains(song)){
                try {
                    Thread.sleep(100);
                } catch (Exception e) {}

                songsCache.add(song);
                searchResults.add(song);
            }
        }
        if(searchResults.isEmpty()){
            System.out.println("No matches found.");
            return null;
        }
        System.out.println("Found");
        return searchResults;
    }

    public void showIDResults(Song foundSong){
        System.out.println("Search Results:");
        System.out.println(foundSong.getTitle() + " by: " +
                foundSong.getArtist() + ", Album: " + foundSong.getAlbum() +
                ", Duration: " + foundSong.getDuration() + " minutes");
        System.out.println();
    }

    public void showTitleAlbumResults(List<Song> searchResults){
        System.out.println("Search Results:");
        for(Song song: searchResults){
            System.out.println(song.getTitle() + " by: " +
                    song.getArtist() + ", Album: " + song.getAlbum() +
                    ", Duration: " + song.getDuration() + " minutes");
        }
        System.out.println();
    }

    public void showProxyCache(){
        System.out.println("Proxy songs cache:");
        for(Song song: songsCache){
            System.out.print(song.getTitle() + ", ");
        }
        System.out.println();
    }
}
