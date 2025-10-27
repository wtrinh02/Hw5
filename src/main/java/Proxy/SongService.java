package Proxy;
import java.util.List;

public interface SongService {
    Song searchBtId(Integer songID);
    List<Song> searchByTitle(String title);
    List<Song> searchByAlbum(String album);
}
