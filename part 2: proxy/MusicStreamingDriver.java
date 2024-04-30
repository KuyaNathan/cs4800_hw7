import java.util.ArrayList;
import java.util.List;

public class MusicStreamingDriver {
    public static void main(String[] args){
        // create songs
        Song summerBH = new Song(1, "SUMMER", "Brockhampton", "Saturation 2", 3.25);
        Song treasure = new Song(2, "Treasure", "Bruno Mars", "Unorthodox Jukebox", 2.59);
        Song coolwithyou = new Song(3, "Cool With You", "NewJeans", "Get Up", 2.28);
        Song billiejean = new Song(4, "Billie Jean", "Michael Jackson", "Thriller", 4.54);
        Song fantasy = new Song(5, "Fantasy", "Mariah Carey", "Daydream", 4.03);
        Song gummy = new Song(6, "GUMMY", "Brockhampton", "Saturation 2", 4.21);
        Song summerKeshi = new Song(7, "summer", "Keshi", "skeletons", 2.45);
        Song oxytocin = new Song(8, "Oxytocin", "Billie Eilish", "Happier Than Ever", 3.30);

        // add all songs to songCollection and create server with songCollection
        List<Song> songCollection = new ArrayList<>();
        songCollection.add(summerBH);
        songCollection.add(treasure);
        songCollection.add(coolwithyou);
        songCollection.add(billiejean);
        songCollection.add(fantasy);
        songCollection.add(gummy);
        songCollection.add(summerKeshi);
        songCollection.add(oxytocin);

        SongServer itunes = new SongServer(songCollection);
        itunes.showSongsList();

        // add some songs to proxyCache and create a proxy with proxyCache
        List<Song> proxyCache = new ArrayList<>();
        proxyCache.add(summerBH);
        proxyCache.add(billiejean);
        proxyCache.add(fantasy);

        SongProxy nevadaProxy = new SongProxy(itunes, proxyCache);

        System.out.println("Proxy cache before searches:");
        nevadaProxy.showProxyCache();

        System.out.println("\n---Searching ID for a song that is in the proxy---");

        long start = System.currentTimeMillis();
        Song idSearch = nevadaProxy.searchByID(1);
        long end = System.currentTimeMillis();
        long runtime = end - start;
        System.out.println("Runtime for search from proxy cache: " + runtime + " milliseconds");
        nevadaProxy.showIDResults(idSearch);

        System.out.println("---Searching ID for a song that is fetched from the server---");
        start = System.currentTimeMillis();
        idSearch = nevadaProxy.searchByID(2);
        end = System.currentTimeMillis();
        runtime = end - start;
        System.out.println("Runtime for search with server fetch: " + runtime + " milliseconds");
        nevadaProxy.showIDResults(idSearch);

        System.out.println("---Searching Title for song in the proxy---");
        start = System.currentTimeMillis();
        List<Song> searchResults = nevadaProxy.searchByTitle("Fantasy");
        end = System.currentTimeMillis();
        runtime = end - start;
        System.out.println("Runtime for search from proxy cache: " + runtime + " milliseconds");
        nevadaProxy.showTitleAlbumResults(searchResults);
        
        System.out.println("---Searching Title for song that is fetched from server---");
        start = System.currentTimeMillis();
        searchResults = nevadaProxy.searchByTitle("summer");
        end = System.currentTimeMillis();
        runtime = end - start;
        System.out.println("Runtime for search with server fetch: " + runtime + " milliseconds");
        nevadaProxy.showTitleAlbumResults(searchResults);

        System.out.println("---Searching Title for song that has been added to cache---");
        start = System.currentTimeMillis();
        searchResults = nevadaProxy.searchByTitle("summer");
        end = System.currentTimeMillis();
        runtime = end - start;
        System.out.println("Runtime for search from proxy cache: " + runtime + " milliseconds");
        nevadaProxy.showTitleAlbumResults(searchResults);

        System.out.println("---Searching Album for song in proxy cache---");
        start = System.currentTimeMillis();
        searchResults = nevadaProxy.searchByAlbum("Thriller");
        end = System.currentTimeMillis();
        runtime = end - start;
        System.out.println("Runtime for search from proxy cache: " + runtime + " milliseconds");
        nevadaProxy.showTitleAlbumResults(searchResults);

        System.out.println("---Searching Album for song that is fetched from server---");
        start = System.currentTimeMillis();
        searchResults = nevadaProxy.searchByAlbum("Saturation 2");
        end = System.currentTimeMillis();
        runtime = end - start;
        System.out.println("Runtime for search with server fetch: " + runtime + " milliseconds");
        nevadaProxy.showTitleAlbumResults(searchResults);

        System.out.println("Proxy Cache after searches:");
        nevadaProxy.showProxyCache();

        System.out.println("\nServer songs list for comparison:");
        itunes.showSongsList();
    }
}
