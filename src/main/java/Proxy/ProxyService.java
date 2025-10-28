package Proxy;

import java.util.HashMap;
import java.util.List;

public class ProxyService implements SongService{

    private RealService service;
    private HashMap<Integer, Song> cacheById;
    private HashMap<String, List<Song>> cacheByTitle;
    private HashMap<String, List<Song>> cacheByAlbum;

    public ProxyService(RealService service){
        cacheById = new HashMap<>();
        cacheByTitle = new HashMap<>();
        cacheByAlbum = new HashMap<>();
        this.service = service;
    }


    @Override
    public Song searchById(Integer songID) {
        if(cacheById.containsKey(songID)){
            return cacheById.get(songID);
        }
        Song song = service.searchById(songID);
        cacheById.put(songID, song);
        return song;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if(cacheByTitle.containsKey(title)){
            return cacheByTitle.get(title);
        }
        List<Song> foundSongs = service.searchByTitle(title);
        cacheByTitle.put(title, foundSongs);
        return foundSongs;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if(cacheByAlbum.containsKey(album)){
            return cacheByAlbum.get(album);
        }
        List<Song> foundSongs = service.searchByAlbum(album);
        cacheByAlbum.put(album, foundSongs);
        return foundSongs;
    }
}
