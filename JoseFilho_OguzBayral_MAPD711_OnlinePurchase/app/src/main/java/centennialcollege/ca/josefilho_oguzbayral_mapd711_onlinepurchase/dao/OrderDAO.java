package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OrderDAO extends SQLiteOpenHelper {
    public OrderDAO(Context context) {
        super(context, "OnlinePurchase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Orders (" +
                " orderId INTEGER PRIMARY KEY, " +
                " customerId INTEGER NOT NULL, " +
                " itemId INTEGER NOT NULL, " +
                " orderDate DATE NOT NULL, " +
                " status TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Orders;";
        db.execSQL(sql);
        onCreate(db);
    }
}
