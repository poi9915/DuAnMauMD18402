package fpoly.trungnqph45090.duanmau.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import fpoly.trungnqph45090.duanmau.DataBase.DbHelper;
import fpoly.trungnqph45090.duanmau.Models.LoaiSach;
import fpoly.trungnqph45090.duanmau.Models.PhieuMuon;
import fpoly.trungnqph45090.duanmau.Models.Sach;

public class LoaiSachDAO {
    private DbHelper dbHelper;
    private SQLiteDatabase db;

    public LoaiSachDAO(Context context) {
        this.dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void insertloaiSach(LoaiSach loaiSach) {
        ContentValues values = new ContentValues();
        values.put("MaLoai", loaiSach.getMaLoai());
        values.put("Ten", loaiSach.getTen());
        db.insert("LoaiSach", null, values);
    }

    @SuppressLint("Range")
    public ArrayList<LoaiSach> getData(String sql, String...selectionArgs) {
        ArrayList<LoaiSach> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            LoaiSach obj = new LoaiSach();
            obj.setMaLoai(Integer.parseInt(cursor.getString(cursor.getColumnIndex("MaLoai"))));
            obj.setTen(cursor.getString(cursor.getColumnIndex("Ten")));
            list.add(obj);
        }
        return list;
    }
    public ArrayList<LoaiSach> getAll(){
        String sql ="SELECT * FROM LoaiSach";
        return getData(sql);
    }
    @SuppressLint("Range")
    public LoaiSach getByID(String id) {
        Cursor cursor = db.rawQuery("select * from LoaiSach where MaLoai = ?", new String[]{id});
        LoaiSach item = null;
        if (cursor.moveToFirst()) {
            item = new LoaiSach();
            item.setMaLoai(cursor.getInt(cursor.getColumnIndex("MaLoai")));
            item.setTen(cursor.getString(cursor.getColumnIndex("Ten")));
        }
        cursor.close();
        return item;
    }

    public int removeLoaiSach(LoaiSach loaiSach) {
        String[] id = new String[]{String.valueOf(loaiSach.getMaLoai())};
        return db.delete("LoaiSach", "MaLoai = ?", id);
    }

    public int updateLoaiSach(LoaiSach loaiSach) {
        String[] id = new String[]{String.valueOf(loaiSach.getMaLoai())};
        ContentValues values = new ContentValues();
        values.put("Ten", loaiSach.getTen());
        return db.update("LoaiSach", values, "MaLoai = ?", id);
    }
}
