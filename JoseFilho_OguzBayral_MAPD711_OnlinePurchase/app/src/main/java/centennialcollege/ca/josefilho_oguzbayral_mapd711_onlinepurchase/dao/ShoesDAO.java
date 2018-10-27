package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.Shoes;

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

    public Shoes insert(Shoes shoes) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put("itemName", shoes.getItemName());
        data.put("category", shoes.getCategory());
        data.put("shoeSize", shoes.getShoeSize());
        data.put("price", shoes.getPrice());
        shoes.setItemId(db.insert("Shoes", null, data));
        if (shoes.getItemId() != -1) {
            return shoes;
        } else {
            return null;
        }

    }

    public void update(Shoes shoes) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put("itemName", shoes.getItemName());
        data.put("category", shoes.getCategory());
        data.put("shoeSize", shoes.getShoeSize());
        data.put("price", shoes.getPrice());
        db.update("Shoes", data, "itemId = ?", new String[]{shoes.getItemId().toString()});
    }

    public void remove(Long id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("Shoes", "itemId = ?", new String[]{id.toString()});
    }
}
