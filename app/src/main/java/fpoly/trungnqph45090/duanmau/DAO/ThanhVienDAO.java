package fpoly.trungnqph45090.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fpoly.trungnqph45090.duanmau.DataBase.DbHelper;
import fpoly.trungnqph45090.duanmau.Models.ThanhVien;

public class ThanhVienDAO {
    private DbHelper dbHelper;
    private SQLiteDatabase db;

    public ThanhVienDAO(Context context) {
        this.dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public void insertThanhVien(ThanhVien thanhVien){
        ContentValues values = new ContentValues();
        values.put("MaTV" , thanhVien.getMaTV());
        values.put("HoTen" ,thanhVien.getHoTen());
        values.put("NamSinh" , thanhVien.getNamSinh());
        db.insert("ThanhVien" , null  , values);
    }
    public ArrayList<ThanhVien> getAllThanhVien(){
        ArrayList<ThanhVien> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from ThanhVien" , null);
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                int id = cursor.getInt(0);
                String hoten = cursor.getString(1);
                String namSinh = cursor.getString(2);
                list.add(new ThanhVien(id  , hoten, namSinh));
            }while (cursor.moveToNext());
        }
        return list;
    }
    public int removeThanhVien(ThanhVien thanhVien){
        String[] id = new String[]{String.valueOf(thanhVien.getMaTV())};
        return db.delete("ThanhVien" , "MaTV = ?" , id);
    }
    public int updateThanhVien(ThanhVien thanhVien){
        ContentValues values = new ContentValues();
        values.put("HoTen" ,thanhVien.getHoTen());
        values.put("NamSinh" , thanhVien.getNamSinh());
        return db.update("ThanhVien" , values , "MaTV = ?",new String[]{String.valueOf(thanhVien.getMaTV())});
    }
}
