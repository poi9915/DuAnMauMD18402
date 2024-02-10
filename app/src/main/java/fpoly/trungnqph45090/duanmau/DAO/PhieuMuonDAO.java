package fpoly.trungnqph45090.duanmau.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import fpoly.trungnqph45090.duanmau.DataBase.DbHelper;
import fpoly.trungnqph45090.duanmau.Models.PhieuMuon;
import fpoly.trungnqph45090.duanmau.Models.Sach;
import fpoly.trungnqph45090.duanmau.Models.Top;

public class PhieuMuonDAO {
    private DbHelper dbHelper;
    private SQLiteDatabase db;
    Context context;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public PhieuMuonDAO(Context context) {
        this.dbHelper = new DbHelper(context);
        this.context = context;
        db = dbHelper.getWritableDatabase();
    }

    public long insertPhieuMuon(PhieuMuon phieuMuon) {
        ContentValues values = new ContentValues();
        values.put("MaTT", phieuMuon.getMaPM());
        values.put("MaTV", phieuMuon.getMaTV());
        values.put("MaSach", phieuMuon.getMaSach());
        values.put("Ngay", sdf.format(phieuMuon.getNgay()));
        values.put("TraSach", phieuMuon.getTraSach());
        values.put("TienThue", phieuMuon.getTienThue());
        return db.insert("PhieuMuon", null, values);
    }

    public long updatePhieuMuon(PhieuMuon phieuMuon) {
        ContentValues values = new ContentValues();
        values.put("MaTT", phieuMuon.getMaPM());
        values.put("MaTV", phieuMuon.getMaTV());
        values.put("MaSach", phieuMuon.getMaSach());
        values.put("Ngay", sdf.format(phieuMuon.getNgay()));
        values.put("TraSach", phieuMuon.getTraSach());
        values.put("TienThue", phieuMuon.getTienThue());
        return db.update(
                "PhieuMuon",
                values,
                "MaPM=?",
                new String[]{String.valueOf(phieuMuon.getMaPM())}
        );
    }

    public int deletePhieuMuon(String id) {
        return db.delete("PhieuMuon", "MaPM=?", new String[]{id});
    }

    @SuppressLint("Range")
    public ArrayList<PhieuMuon> getData(String sql, String... selectionArgs) {
        ArrayList<PhieuMuon> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectionArgs);
        while (cursor.moveToNext()) {
            PhieuMuon obj = new PhieuMuon();
            obj.setMaPM(Integer.parseInt(cursor.getString(cursor.getColumnIndex("MaPM"))));
            obj.setMaTT(cursor.getString(cursor.getColumnIndex("MaTT")));
            obj.setMaTV(cursor.getString(cursor.getColumnIndex("MaTV")));
            obj.setMaSach(Integer.parseInt(cursor.getString(cursor.getColumnIndex("MaSach"))));
            obj.setTienThue(Integer.parseInt(cursor.getString(cursor.getColumnIndex("TienThue"))));
            obj.setTraSach(Integer.parseInt(cursor.getString(cursor.getColumnIndex("TraSach"))));
            try {
                obj.setNgay(sdf.parse(cursor.getString(cursor.getColumnIndex("Ngay"))));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            list.add(obj);
        }
        return list;
    }

    public ArrayList<PhieuMuon> getAll() {
        String sql = "SELECT * FROM PhieuMuon";
        return getData(sql);
    }

    public PhieuMuon getByID(String id) {
        String sql = "SELECT * FROM Phieu Muon WHERE MaPM=?";
        List<PhieuMuon> list = getData(sql, id);
        return list.get(0);
    }

    @SuppressLint("Range")
    public ArrayList<Top> getTop(String tuNgay, String denNgay) {
        ArrayList<Top> list = new ArrayList<>();
        String sqlTop = "Select MaSach , count(MaSach) as SoLuong FROM PhieuMuon GROUP BY MaSach ORDER BY SoLuong DESC LIMIT 10";
        SachDAO sachDAO = new SachDAO(context);
        Cursor cursor = db.rawQuery(sqlTop, null);
        while (cursor.moveToNext()) {
            Top top = new Top();
            Sach sach = sachDAO.getByID(cursor.getString(cursor.getColumnIndex("MaSach")));
            top.setTenSach(sach.getTenSach());
            top.setSoLuong(Integer.parseInt(cursor.getString(cursor.getColumnIndex("SoLuong"))));
            list.add(top);
        }
        return list;
    }

    @SuppressLint("Range")
    public int getDoanThu(String tuNgay , String denNgay){
        String sqlDoanhThu = "select SUM(TienThue) as DoanhThu from PhieuMuon where Ngay between ? and ?";
        ArrayList<Integer> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sqlDoanhThu,new String[]{tuNgay,denNgay});
        while (cursor.moveToNext()){
            try{
                list.add(Integer.parseInt(cursor.getString(cursor.getColumnIndex("DoanhThu"))));

            }catch (Exception e){
                list.add(0);
            }
        }
        return list.get(0);
    }
}
