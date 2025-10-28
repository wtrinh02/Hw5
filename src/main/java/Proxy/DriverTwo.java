package Proxy;

import java.util.ArrayList;
import java.util.List;

public class DriverTwo {
    public static void main(String[] args) {
        Song song1 = new Song("Song1", 1, "Album 1");
        Song song2 = new Song("Song2", 2, "Album 2");
        Song song3 = new Song("Song3", 3, "Album 3");
        Song song4 = new Song("Song4", 4, "Album 4");
        Song song5 = new Song("Song5", 5, "Album 5");
        Song song6 = new Song("Song6", 6, "Album 6");
        Song song7 = new Song("Song7", 7, "Album 7");
        Song song8 = new Song("Song8", 8, "Album 8");
        Song song1copy = new Song("Song1", 10, "Album 10");
        Song album2copy = new Song("Song9", 9, "Album 9");

        List<Song> songs = new ArrayList<>();
        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);
        songs.add(song6);
        songs.add(song7);
        songs.add(song8);
        songs.add(song1copy);
        songs.add(album2copy);

        RealService realService = new RealService(songs);

        ProxyService proxyService = new ProxyService(realService);

        int validID = 1;
        int invalidID = 11;
        System.out.println(proxyService.searchById(validID).toString());
        System.out.println(proxyService.searchById(validID).toString());
        System.out.println(proxyService.searchById(invalidID));

        System.out.println(proxyService.searchByTitle("Song1").toString());
        System.out.println(proxyService.searchByTitle("Song1").toString());

        System.out.println(proxyService.searchByAlbum("Album 2").toString());
        System.out.println(proxyService.searchByTitle("Song4").toString());


    }
}
