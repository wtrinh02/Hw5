package ProxyTests;

import Proxy.RealService;
import Proxy.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RealServiceTests {

    private List<Song> songList;
    private RealService realService;

    @BeforeEach
    public void setUp(){
        songList = new ArrayList<>();
        songList.add(new Song("TestSong1",1,"TestAlbum"));
        songList.add(new Song("TestSong2",2,"TestAlbum"));
        songList.add(new Song("TestSong1",3,"TestAlbum"));
        realService = new RealService(songList);
    }

    @Test
    public void testSearchByID(){
        Song actual = realService.searchById(1);
        int expected = 1;
        assertEquals(expected,actual.getId());
    }

    @Test
    public void testSearchByTitleSize(){
        List<Song> songs = realService.searchByTitle("TestSong1");
        int expected = 2;
        assertEquals(expected,songs.size());
    }

    @Test
    public void testSearchByAlbumSize(){
        List<Song> songs = realService.searchByAlbum("TestAlbum");
        int expected = 3;
        assertEquals(expected,songs.size());
    }
}
