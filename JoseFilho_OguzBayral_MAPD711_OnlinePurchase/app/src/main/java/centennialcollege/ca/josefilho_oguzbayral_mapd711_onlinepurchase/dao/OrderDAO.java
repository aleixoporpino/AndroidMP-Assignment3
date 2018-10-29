package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.Order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

public class OrderDAO extends SQLiteOpenHelper {
    public OrderDAO(Context context) {
        super(context, "OnlinePurchase", null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Orders (" +
                " orderId INTEGER PRIMARY KEY, " +
                " customerId INTEGER NOT NULL, " +
                " itemId INTEGER NOT NULL, " +
                " orderDate TEXT NOT NULL, " +
                " quantity INTEGER NOT NULL, " +
                " status TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Orders;";
        db.execSQL(sql);
        onCreate(db);
    }

    public Collection<Order> findAll() {
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM Orders ";

        Cursor c = db.rawQuery(sql, null);

        Collection<Order> orders = getOrdersByCursor(c);
        c.close();
        return orders;
    }

    public Collection<Order> findByCustomerId(Long customerId) {
        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM Orders o " +
                " WHERE o.customerId = ? ";

        Cursor c = db.rawQuery(sql, new String[]{customerId.toString()});
        Collection<Order> orders = getOrdersByCursor(c);
        c.close();
        return orders;
    }

    public void insert(Order order) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(order.getOrderDate());
        SQLiteDatabase db = getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put("customerId", order.getCustomerId());
        data.put("itemId", order.getItemId());
        data.put("orderDate", date);
        data.put("quantity", order.getQuantity());
        data.put("status", order.getStatus());
        db.insert("Orders", null, data);
    }

    public void update(Order order) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(order.getOrderDate());
        SQLiteDatabase db = getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put("customerId", order.getCustomerId());
        data.put("itemId", order.getItemId());
        data.put("orderDate", date);
        data.put("quantity", order.getQuantity());
        data.put("status", order.getStatus());
        db.update("Orders", data, "orderId = ?", new String[]{order.getOrderId().toString()});
    }

    private Collection<Order> getOrdersByCursor(Cursor c) {
        Collection<Order> orders = new ArrayList<>();
        while (c.moveToNext()) {
            Order order = new Order();
            order.setOrderId(c.getLong(c.getColumnIndex("orderId")));
            order.setCustomerId(c.getLong(c.getColumnIndex("customerId")));
            order.setItemId(c.getLong(c.getColumnIndex("itemId")));
            order.setOrderDate(c.getString(c.getColumnIndex("orderDate")));
            order.setQuantity(c.getInt(c.getColumnIndex("quantity")));
            order.setStatus(c.getString(c.getColumnIndex("status")));
            orders.add(order);
        }

        return orders;
    }
}
