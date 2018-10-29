package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.R;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.ShoesActivity;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao.CsrDAO;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao.CustomerDAO;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.orderSubmit;


public class welcomeCustomer extends AppCompatActivity {

    CsrDAO csrDAO;
    CustomerDAO customerDAO;
    RadioGroup shoeType;
    RadioGroup shoeSize;

    int shoe;
    int size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_customer);
        shoeType = (RadioGroup) findViewById(R.id.radioGroupshoe);
        shoeSize = (RadioGroup) findViewById(R.id.radioGroupsize);
        TextView tfUserName = (TextView) findViewById(R.id.userFullName);
        SharedPreferences userPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String fullName = userPref.getString("username", "");
        fullName.toUpperCase();
        tfUserName.setText(fullName);
        Log.d("SIZE", "value:");

    }


    public void order(View v) {

        Intent intent = new Intent(welcomeCustomer.this, orderSubmit.class);
        SharedPreferences sharedPref = getSharedPreferences("orderInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        if (shoe % 2 == 0) {
            editor.putString("shoeType", "Mens Shoe");

        }
        if (shoe % 2 == 1) {
            editor.putString("shoeType", "Womens Shoe");

        }
        if (size % 2 == 0) {
            editor.putString("shoeSize", "Small");

        }
        if (size % 2 == 0) {
            editor.putString("shoeSize", "Medium");

        }
        if (size % 2 == 0) {
            editor.putString("shoeSize", "Large");
        }
        editor.apply();
        startActivity(intent);
    }

    public void shoeTypeClick(View v) {
        int radiobuttonId = shoeType.getCheckedRadioButtonId();
        shoe = radiobuttonId;
        Log.d("SHOE", "value: " + shoe);

    }

    public void shoeSizeClick(View v) {
        int radiobuttonId = shoeSize.getCheckedRadioButtonId();
        size = radiobuttonId;
        Log.d("SIZE", "value: " + size);

    }
}
