package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.Csr;

public class CsrDAO extends SQLiteOpenHelper {
    public CsrDAO(Context context) {
        super(context, "OnlinePurchase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Csr (" +
                " employeeId INTEGER PRIMARY KEY, " +
                " userName TEXT NOT NULL, " +
                " password TEXT NOT NULL, " +
                " firstName TEXT NOT NULL, " +
                " lastName TEXT NOT NULL);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Csr;";
        db.execSQL(sql);
        onCreate(db);
    }

    public Csr login(String userName, String password) {
        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM Csr c " +
                "WHERE c.userName = ? AND c.password = ? ";

        Cursor c = db.rawQuery(sql, new String[]{userName, password});

        Csr csr = null;
        while (c.moveToNext()) {
            csr = new Csr();
            csr.setEmployeeId(c.getLong(c.getColumnIndex("employeeId")));
            csr.setUserName(c.getString(c.getColumnIndex("userName")));
            csr.setFirstName(c.getString(c.getColumnIndex("firstName")));
            csr.setLastName(c.getString(c.getColumnIndex("lastName")));
        }
        c.close();
        return csr;
    }
}
