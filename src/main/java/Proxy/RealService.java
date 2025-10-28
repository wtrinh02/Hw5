package Proxy;

import java.util.List;

public class RealService implements SongService{

    public RealService(){

    }
    @Override
    public Song searchBtId(Integer songID) {
        
        try{
            Thread.sleep(1000);

            
        }
        catch (Exception e){

        }
        return new Song(null, songID, null);


    }

    @Override
    public List<Song> searchByTitle(String title) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByTitle'");
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByAlbum'");
    }
    
}
