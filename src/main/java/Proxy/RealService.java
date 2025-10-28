package Proxy;

import java.util.ArrayList;
import java.util.List;

public class RealService implements SongService{

    List<Song> songList;
    public RealService(List<Song> songList){
        this.songList = songList;
    }
    @Override
    public Song searchById(Integer songID) {
        
        try{
            Thread.sleep(1000);

            
        }
        catch (Exception e){

        }
        for (Song song : songList){
            if (song.getId() == songID){
                return song;
            }
        }
        return null;

    }

    @Override
    public List<Song> searchByTitle(String title) {

        try{
            Thread.sleep(1000);


        }
        catch (Exception e){

        }

        List<Song> searchedSongs = new ArrayList<>();
        for(Song song : songList){
            if (song.getTitle().toLowerCase().equals(title.toLowerCase())){
                searchedSongs.add(song);
            }
        }
        return searchedSongs;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        try{
            Thread.sleep(1000);


        }
        catch (Exception e){

        }

        List<Song> searchedSongs = new ArrayList<>();
        for(Song song : songList){
            if (song.getAlbum().toLowerCase().equals(album.toLowerCase())){
                searchedSongs.add(song);
            }
        }
        return searchedSongs;
    }
    
}
