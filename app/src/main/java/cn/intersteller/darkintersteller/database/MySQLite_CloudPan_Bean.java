package cn.intersteller.darkintersteller.database;

public class MySQLite_CloudPan_Bean {
    private String song_name;//从simpleSong中拿
    private String song_id;//从simpleSong中拿

    private String album_name;//从alBeans中拿
    private String album_id;//从alBeans中拿

    private String singer_id;//从arBean中拿
    private String singer_name;//从arBean中拿

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getSong_id() {
        return song_id;
    }

    public void setSong_id(String song_id) {
        this.song_id = song_id;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(String album_id) {
        this.album_id = album_id;
    }

    public String getSinger_id() {
        return singer_id;
    }

    public void setSinger_id(String singer_id) {
        this.singer_id = singer_id;
    }

    public String getSinger_name() {
        return singer_name;
    }

    public void setSinger_name(String singer_name) {
        this.singer_name = singer_name;
    }

    public MySQLite_CloudPan_Bean(String song_name, String song_id, String album_name, String album_id, String singer_name) {
        this.song_name = song_name;
        this.song_id = song_id;
        this.album_name = album_name;
        this.album_id = album_id;
        this.singer_name = singer_name;
    }
}
