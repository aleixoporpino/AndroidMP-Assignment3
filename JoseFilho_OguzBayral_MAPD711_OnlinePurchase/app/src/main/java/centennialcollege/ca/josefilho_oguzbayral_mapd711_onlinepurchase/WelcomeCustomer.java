package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao.CsrDAO;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao.CustomerDAO;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao.OrderDAO;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao.ShoesDAO;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.Order;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.Shoes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class WelcomeCustomer extends AppCompatActivity {

    private SharedPreferences userPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_customer);

        userPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String fullName = userPref.getString("username", "");

        TextView tfUserName = findViewById(R.id.userFullName);
        tfUserName.setText(fullName);

    }


    public void clickOrders(View view) {
        Intent intent = new Intent(WelcomeCustomer.this, CustomerOrderActivity.class);
        startActivity(intent);
    }

    public void clickNewOrder(View view) {
        Intent intent = new Intent(WelcomeCustomer.this, CustomerNewOrderAcitivity.class);
        startActivity(intent);
    }

    public void signOut(View view) {
        Intent intent = new Intent(WelcomeCustomer.this, MainActivity.class);
        startActivity(intent);
    }

}
