package com.kodetr.resepmakanan;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MakananImp extends SQLiteOpenHelper implements MakananInterface {

    private String NAMA_TBL = "tbl_makanan";

    public MakananImp(Context context) {
        super(context, "db_maknan", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sql) {
        sql.execSQL("CREATE TABLE '" + NAMA_TBL + "'(id INTEGER, nama TEXT, gambar TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sql, int i, int i1) {
        sql.execSQL("DROP TABLE '" + NAMA_TBL + "'");
    }

    @Override
    public Cursor read() {
        SQLiteDatabase sql = getReadableDatabase();
        return sql.rawQuery("SELECT * FROM " + NAMA_TBL + "", null);
    }

    @Override
    public void create(ResepMakanan makanan) {
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("INSERT INTO '" + NAMA_TBL + "' VALUES ('" + makanan.getId() + "', '" + makanan.getNama_makanan() + "', '" + makanan.getGambar() + "') ");
        sql.execSQL("INSERT INTO '" + NAMA_TBL + "' VALUES(1, 'Pizza', 'https://www.qsrmagazine.com/sites/default/files/styles/story_page/public/PizzaHut.jpg?itok=8m3Mf8Bf')");
    }

    @Override
    public void update(ResepMakanan makanan) {
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("UPDATE '" + NAMA_TBL + "' SET nama='" + makanan.getNama_makanan() + "', gambar='" + makanan.getGambar() + "' WHERE id='" + makanan.getId() + "'");
    }

    @Override
    public void delete(int id) {
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("DELETE FROM '" + NAMA_TBL + "' WHERE id='" + id + "'");
    }
}
