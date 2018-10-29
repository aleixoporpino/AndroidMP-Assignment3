package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.Order;

public class DetailsCustomerOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_customer_order);

        Intent intent = getIntent();
        Order order = (Order) intent.getSerializableExtra("order");

    }
}
