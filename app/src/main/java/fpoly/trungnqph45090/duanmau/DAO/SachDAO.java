package fpoly.trungnqph45090.duanmau.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import fpoly.trungnqph45090.duanmau.DataBase.DbHelper;
import fpoly.trungnqph45090.duanmau.Models.Sach;

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
    public ArrayList<Sach> getAllSach(){
        ArrayList<Sach> list = new ArrayList<>();

        return list;
    }
}
