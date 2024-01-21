package fpoly.trungnqph45090.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fpoly.trungnqph45090.duanmau.DataBase.DbHelper;
import fpoly.trungnqph45090.duanmau.Models.LoaiSach;

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

    public ArrayList<LoaiSach> getAllLoaiSach() {
        ArrayList<LoaiSach> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from LoaiSach", null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                int id = cursor.getInt(0);
                String Ten = cursor.getString(1);

                list.add(new LoaiSach(id, Ten));
            } while (cursor.moveToNext());
        }

        return list;
    }
    public int removeLoaiSach(LoaiSach loaiSach){
        String[] id = new String[]{String.valueOf(loaiSach.getMaLoai())};
        return db.delete("LoaiSach" , "MaLoai = ?" , id);
    }
    public int updateLoaiSach(LoaiSach loaiSach){
        String[] id = new String[]{String.valueOf(loaiSach.getMaLoai())};
        ContentValues values = new ContentValues();
        values.put("Ten" , loaiSach.getTen());
        return db.update("LoaiSach" , values , "MaLoai = ?" , id);
    }
}
