package ProxyTests;

import Proxy.ProxyService;
import Proxy.RealService;
import Proxy.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProxyServiceTests {

    private RealService realService;
    private ProxyService proxyService;
    private Song song1;
    private Song song2;
    private Song song3;

    @BeforeEach
    public void setup() {
        song1 = new Song("TestSong1",1,"TestAlbum");
        song2 = new Song("TestSong2",2,"TestAlbum");
        song3 = new Song("TestSong1",3,"TestAlbum");
        List<Song> songs = Arrays.asList(song1,song2,song3);
        realService = new RealService(songs);
        proxyService = new ProxyService(realService);
    }

    @Test
    public void testSearchByID() {
        Song actual = proxyService.searchById(1);
        int expected = 1;
        assertEquals(expected,actual.getId());
    }
    @Test
    public void testSearchByIDCacheSize() {
        proxyService.searchById(1);
        proxyService.searchById(1);

        int actual = proxyService.getCacheById().size();
        int expected = 1;
        assertEquals(expected,actual);
    }

    @Test
    public void testSearchByAlbum() {
        List<Song> songs = proxyService.searchByAlbum("TestAlbum");
        int expected = 3;
        assertEquals(expected,songs.size());
    }
    @Test
    public void testSearchByAlbumCacheSize() {
        proxyService.searchByAlbum("TestAlbum");
        proxyService.searchByAlbum("TestAlbum");
        int expected = 1;
        int actual = proxyService.getCacheByAlbum().size();
        assertEquals(expected,actual);
    }

    @Test
    public void testSearchByTitle() {
        List<Song> songs = proxyService.searchByTitle("TestSong1");
        int expected = 2;
        assertEquals(expected,songs.size());
    }
    @Test
    public void testSearchByTitleCacheSize() {
        proxyService.searchByTitle("TestSong1");
        proxyService.searchByTitle("TestSong1");
        int expected = 1;
        int actual = proxyService.getCacheByTitle().size();
        assertEquals(expected,actual);
    }
}
