package fpoly.trungnqph45090.duanmau.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fpoly.trungnqph45090.duanmau.DataBase.DbHelper;
import fpoly.trungnqph45090.duanmau.Models.Sach;
import fpoly.trungnqph45090.duanmau.Models.ThuThu;

public class SachDAO {
    private DbHelper dbHelper;
    private SQLiteDatabase db;

    public SachDAO(Context context) {
        this.dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void insertSach(Sach sach){
        ContentValues values = new ContentValues();
        values.put("MaSach" , sach.getMaSach());
        values.put("TenSach" ,sach.getTenSach());
        values.put("GiaThue" , sach.getGiaThue());
        values.put("MaLoai"  , sach.getMaLoai());
        db.insert("Sach",null , values);
    }
    @SuppressLint("Range")
    public ArrayList<Sach> getData(String sql, String... selectionArgs) {
        ArrayList<Sach> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            Sach obj = new Sach();
            obj.setMaSach(Integer.parseInt(cursor.getString(cursor.getColumnIndex("MaSach"))));
            obj.setTenSach(cursor.getString(cursor.getColumnIndex("TenSach")));
            obj.setGiaThue(Integer.parseInt(cursor.getString(cursor.getColumnIndex("MatKhau"))));
            obj.setMaLoai(Integer.parseInt(cursor.getString(cursor.getColumnIndex("MaLoai"))));
            list.add(obj);
        }
        return list;
    }
    public ArrayList<Sach> getAll(){
        String sql = "SELECT * FROM Sach";
        return getData(sql);
    }
    public Sach getByID(String id){
        String sql = "SELECT * FROM WHERE MaSach=?";
        List<Sach> list = getData(sql,id);
        return list.get(0);
    }
}
