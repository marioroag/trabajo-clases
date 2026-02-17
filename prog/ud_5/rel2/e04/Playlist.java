package prog.ud_5.rel2.e04;

import java.util.ArrayList;

public class Playlist {
    ArrayList<Cancion> playlist;

    public Playlist(ArrayList<Cancion> playlist) {
        this.playlist = playlist;
    }

    public Playlist() {
        this.playlist = new ArrayList<>();
    }

    @Override
    public String toString() {
        String playlistMostrar = "";
        for (Cancion cancion : playlist) {
            for (int i = 1; i < playlist.size(); i++) {
            }
        }

        return playlistMostrar;
    }
}
