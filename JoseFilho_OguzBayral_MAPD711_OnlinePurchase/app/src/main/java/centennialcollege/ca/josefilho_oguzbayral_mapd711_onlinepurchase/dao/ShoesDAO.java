package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ShoesDAO extends SQLiteOpenHelper {
    public ShoesDAO(Context context) {
        super(context, "OnlinePurchase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Shoes (" +
                " itemId INTEGER PRIMARY KEY, " +
                " itemName TEXT NOT NULL, " +
                " category TEXT NOT NULL, " +
                " shoeSize DOUBLE NOT NULL, " +
                " price DOUBLE NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Shoes;";
        db.execSQL(sql);
        onCreate(db);
    }


}
