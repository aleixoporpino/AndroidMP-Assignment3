package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao.OrderDAO;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao.ShoesDAO;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.Order;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.Shoes;

import java.util.ArrayList;
import java.util.List;

public class OrdersActivity extends AppCompatActivity {
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        OrderDAO ordersDAO = new OrderDAO(this);
        List<Order> orders = new ArrayList<>(ordersDAO.findAll());

        listView = findViewById(R.id.orders_list);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Order order = (Order) listView.getItemAtPosition(position);
                Intent intent = new Intent(OrdersActivity.this, EditOrderActivity.class);
                intent.putExtra("order", order);
                startActivity(intent);
            }
        });

        ArrayAdapter<Order> adapter;
        adapter = new ArrayAdapter<Order>(this, android.R.layout.simple_list_item_1, orders);
        listView.setAdapter(adapter);
    }

    private void loadOrdersList() {
        OrderDAO ordersDAO = new OrderDAO(this);
        List<Order> orders = new ArrayList<>(ordersDAO.findAll());
        ordersDAO.close();
        ArrayAdapter<Order> adapter;
        adapter = new ArrayAdapter<Order>(this, android.R.layout.simple_list_item_1, orders);
        listView.setAdapter(adapter);
    }

    public void back(View view) {
        Intent intent = new Intent(OrdersActivity.this, WelcomeCsr.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadOrdersList();
    }
}
