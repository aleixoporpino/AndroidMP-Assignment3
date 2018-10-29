package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.Csr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CsrDAO extends SQLiteOpenHelper {
    public CsrDAO(Context context) {
        super(context, "OnlinePurchase", null, 6);
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

    public void insert(Csr csr) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put("userName", csr.getUserName());
        data.put("password", csr.getPassword());
        data.put("firstName", csr.getFirstName());
        data.put("lastName", csr.getLastName());
        db.insert("Csr", null, data);
    }


    public Csr login(String userName, String password) {
        List<Csr> csrs = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM Csr c " +
                "WHERE c.userName = ? AND c.password = ? ";

        Cursor c = db.rawQuery(sql, new String[]{userName, password});

        while (c.moveToNext()) {
            Csr csr = new Csr();
            csr.setEmployeeId(c.getLong(c.getColumnIndex("employeeId")));
            csr.setUserName(c.getString(c.getColumnIndex("userName")));
            csr.setFirstName(c.getString(c.getColumnIndex("firstName")));
            csr.setLastName(c.getString(c.getColumnIndex("lastName")));
            csrs.add(csr);
        }
        c.close();
        if (!csrs.isEmpty()) return csrs.get(0);
        return null;
    }

    public Collection<Csr> findAll() {
        Collection<Csr> csrs = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM Csr c ";

        Cursor c = db.rawQuery(sql, null);

        Csr csr = null;
        while (c.moveToNext()) {
            csr = new Csr();
            csr.setEmployeeId(c.getLong(c.getColumnIndex("employeeId")));
            csr.setUserName(c.getString(c.getColumnIndex("userName")));
            csr.setFirstName(c.getString(c.getColumnIndex("firstName")));
            csr.setLastName(c.getString(c.getColumnIndex("lastName")));
            csrs.add(csr);
        }
        c.close();
        return csrs;
    }
}
