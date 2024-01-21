package fpoly.trungnqph45090.duanmau.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import fpoly.trungnqph45090.duanmau.DataBase.DbHelper;

public class PhieuMuonDAO {
    private DbHelper dbHelper;
    private SQLiteDatabase db;

    public PhieuMuonDAO(Context context) {
        this.dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

}
