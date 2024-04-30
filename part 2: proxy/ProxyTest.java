import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class ProxyTest {
    Song one = new Song(1, "one", "test", "unit", 1);
    Song two = new Song(2, "two", "test", "unit", 2);
    Song three = new Song(3, "three", "test", "unit", 3);

    List<Song> songsCollection = new ArrayList<>();
    SongServer server = new SongServer(songsCollection);

    List<Song> proxyCache = new ArrayList<>();
    SongProxy proxy = new SongProxy(server, proxyCache);

    @Test
    public void testSearchByID(){
        songsCollection.add(one);
        songsCollection.add(two);

        proxyCache.add(one);

        Song foundInProxy = proxy.searchByID(1);
        assertNotNull(foundInProxy);
        assertEquals("one", foundInProxy.getTitle());
        assertEquals("test", foundInProxy.getArtist());
        assertEquals("unit", foundInProxy.getAlbum());
        assertEquals(1, foundInProxy.getDuration(), 0.001);

        Song fetchedFromServer = proxy.searchByID(2);
        assertNotNull(fetchedFromServer);
        assertEquals("two", fetchedFromServer.getTitle());
        assertEquals("test", fetchedFromServer.getArtist());
        assertEquals("unit", fetchedFromServer.getAlbum());
        assertEquals(2, fetchedFromServer.getDuration(), 0.001);
    }

    @Test
    public void testSearchByTitle(){
        songsCollection.add(one);
        songsCollection.add(two);

        proxyCache.add(one);

        List<Song> searchResults = proxy.searchByTitle("one");
        assertNotNull(searchResults);
        assertEquals(1, searchResults.size());
        assertEquals("one", searchResults.get(0).getTitle());
        assertEquals("test", searchResults.get(0).getArtist());
        assertEquals("unit", searchResults.get(0).getAlbum());
        assertEquals(1, searchResults.get(0).getDuration(), 0.001);

        searchResults = proxy.searchByTitle("two");
        assertNotNull(searchResults);
        assertEquals(1, searchResults.size());
        assertEquals("two", searchResults.get(0).getTitle());
        assertEquals("test", searchResults.get(0).getArtist());
        assertEquals("unit", searchResults.get(0).getAlbum());
        assertEquals(2, searchResults.get(0).getDuration(), 0.001);
    }

    @Test
    public void testSearchByAlbum(){
        songsCollection.add(one);
        songsCollection.add(two);
        songsCollection.add(three);

        proxyCache.add(one);

        List<Song> searchResults = proxy.searchByAlbum("unit");
        assertNotNull(searchResults);
        assertEquals(3, searchResults.size());
        assertEquals("one", searchResults.get(0).getTitle());
        assertEquals("test", searchResults.get(0).getArtist());
        assertEquals("unit", searchResults.get(0).getAlbum());
        assertEquals(1, searchResults.get(0).getDuration(), 0.001);

        assertEquals("two", searchResults.get(1).getTitle());
        assertEquals("test", searchResults.get(1).getArtist());
        assertEquals("unit", searchResults.get(1).getAlbum());
        assertEquals(2, searchResults.get(1).getDuration(), 0.001);

        assertEquals("three", searchResults.get(2).getTitle());
        assertEquals("test", searchResults.get(2).getArtist());
        assertEquals("unit", searchResults.get(2).getAlbum());
        assertEquals(3, searchResults.get(2).getDuration(), 0.001);
    }
}
