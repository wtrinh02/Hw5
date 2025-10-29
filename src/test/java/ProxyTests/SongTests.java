package ProxyTests;

import Proxy.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongTests {
    Song song;

    @BeforeEach
    public void setup() {
        song = new Song("TestSong",1,"TestAlbum");
    }
    @Test
    public void testGetTitle(){
        String expected = "TestSong";
        String actual = song.getTitle();
        assertEquals(expected,actual);
    }
    @Test
    public void testGetId(){
        int expected = 1;
        int actual = song.getId();
        assertEquals(expected,actual);
    }

    @Test
    public void testGetAlbum(){
        String expected = "TestAlbum";
        String actual = song.getAlbum();
        assertEquals(expected,actual);
    }


}
