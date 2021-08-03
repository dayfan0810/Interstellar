package cn.intersteller.darkintersteller.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import cn.intersteller.darkintersteller.utils.Constant;


public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private static MySQLiteOpenHelper sInstance = null;


    /**
     * @param context 上下文
     */
    public MySQLiteOpenHelper(Context context) {
        super(context, Constant.CLOUDPAN_DATABASE_NAME, null, Constant.CLOUDPAN_DATABASE_VERSION);
    }

    public static final synchronized MySQLiteOpenHelper getInstance(final Context context) {
        if (sInstance == null) {
            sInstance = new MySQLiteOpenHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        sql:create table table_name( song_id intger,song_name carchar(20),album_name carchar(20),singer_name carchar(20))
        String sql = "create table " + Constant.CLOUDPAN_DATABASE_TABLE_NAME + " ( song_id intger,song_name carchar(20),album_name carchar(20),singer_name carchar(20),PRIMARY KEY (song_id))";
        //上面设置song_id为primary key是防止添加相同数据
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
