class Playlist {
    private String[] songs;
    private int songCount;

    Playlist(int size) {
        songs = new String[size];
        songCount = 0;
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    public String[] getSongs() {
        return java.util.Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }
}