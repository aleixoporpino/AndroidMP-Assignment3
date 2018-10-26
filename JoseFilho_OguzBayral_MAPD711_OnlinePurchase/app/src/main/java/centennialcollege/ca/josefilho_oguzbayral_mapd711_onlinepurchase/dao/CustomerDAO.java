package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.Customer;

public class CustomerDAO extends SQLiteOpenHelper {

    public CustomerDAO(Context context) {
        super(context, "OnlinePurchase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Customers (" +
                " customerId INTEGER PRIMARY KEY, " +
                " userName TEXT NOT NULL, " +
                " password TEXT NOT NULL, " +
                " firstName TEXT NOT NULL, " +
                " lastName TEXT NOT NULL, " +
                " address TEXT NOT NULL, " +
                " city TEXT NOT NULL, " +
                " postalCode TEXT NOT NULL);";
        db.execSQL(sql);
    }

    // Temporary drop
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Customers;";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insert(Customer customer) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put("username", customer.getUserName());
        data.put("password", customer.getPassword());
        data.put("firstName", customer.getFirstName());
        data.put("lastName", customer.getLastName());
        data.put("address", customer.getAddress());
        data.put("city", customer.getCity());
        data.put("postalCode", customer.getPostalCode());
        db.insert("Customers", null, data);
    }

    public Customer login(String userName, String password) {
        SQLiteDatabase db = getReadableDatabase();

        String sql = "SELECT * FROM Customers c " +
                "WHERE c.userName = ? AND c.password = ? ";

        Cursor c = db.rawQuery(sql, new String[]{userName, password});

        Customer customer = null;
        while (c.moveToNext()) {
            customer = new Customer();
            customer.setCustomerId(c.getLong(c.getColumnIndex("customerId")));
            customer.setUserName(c.getString(c.getColumnIndex("userName")));
            customer.setFirstName(c.getString(c.getColumnIndex("firstName")));
            customer.setLastName(c.getString(c.getColumnIndex("lastName")));
            customer.setAddress(c.getString(c.getColumnIndex("address")));
            customer.setCity(c.getString(c.getColumnIndex("city")));
            customer.setPostalCode(c.getString(c.getColumnIndex("postalCode")));
        }
        c.close();
        return customer;
    }
}

