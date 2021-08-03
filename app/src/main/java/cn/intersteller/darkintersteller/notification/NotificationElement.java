package cn.intersteller.darkintersteller.notification;

import android.graphics.Bitmap;

public class NotificationElement {
    Bitmap songAlbumBitmap;
    String songName;
    String songArtistAndAlbum;
    boolean playing;
    boolean loved;
    boolean openLyric;


    public Bitmap getSongAlbumBitmap() {
        return songAlbumBitmap;
    }

    public void setSongAlbumBitmap(Bitmap songAlbumBitmap) {
        this.songAlbumBitmap = songAlbumBitmap;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongArtistAndAlbum() {
        return songArtistAndAlbum;
    }

    public void setSongArtistAndAlbum(String songArtistAndAlbum) {
        this.songArtistAndAlbum = songArtistAndAlbum;
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public boolean isLoved() {
        return loved;
    }

    public void setLoved(boolean loved) {
        this.loved = loved;
    }

    public boolean isOpenLyric() {
        return openLyric;
    }

    public void setOpenLyric(boolean openLyric) {
        this.openLyric = openLyric;
    }
}
