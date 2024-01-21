package fpoly.trungnqph45090.duanmau.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import fpoly.trungnqph45090.duanmau.DataBase.DbHelper;
import fpoly.trungnqph45090.duanmau.Models.ThuThu;

public class ThuThuDAO {
    private DbHelper dbHelper;
    private SQLiteDatabase db;

    public ThuThuDAO(Context context) {
        this.dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    public void insertThuThu(ThuThu thuThu){

    }
}
