import java.util.*;

public class SongPlaylist {
    private LinkedList<Song> playlist;

    public SongPlaylist() {
        playlist = new LinkedList<>();
    }

    public void addSong(String title, String artist, int duration) {
        playlist.add(new Song(title, artist, duration));
    }

    public void removeSong(int index) {
        playlist.remove(index);
    }

    public void playPlaylist() {
        for (Song song : playlist) {
            System.out.println(song);
        }
    }

    public void shufflePlaylist() {
        LinkedList<Song> shuffled = new LinkedList<>(playlist);
        Collections.shuffle(shuffled, new Random());
        for (Song song : shuffled) {
            System.out.println(song);
        }
    }
    
    public void sortPlaylistByDuration() {
        Comparator<Song> durationComparator = new Comparator<Song>() {
            @Override
            public int compare(Song s1, Song s2) {
                return Integer.compare(s1.duration, s2.duration);
            }
        };
        Collections.sort(playlist, durationComparator);
    }


    private static class Song {
        private String title;
        private String artist;
        private int duration;

        public Song(String title, String artist, int duration) {
            this.title = title;
            this.artist = artist;
            this.duration = duration;
        }

        @Override
        public String toString() {
            return title + " - " + artist + " (" + duration + "s)";
        }
    }
}
