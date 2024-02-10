package fpoly.trungnqph45090.duanmau.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Seed {
    DbHelper dbHelper;
    SQLiteDatabase db;

    public Seed(Context context) {
        this.dbHelper = new DbHelper(context);
        this.db = dbHelper.getWritableDatabase();
    }

    public void dataPhieuMuon(){

    }
}
