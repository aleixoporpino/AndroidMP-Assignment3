package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.R;

public class welcomeCsr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_customer);
        TextView tfUserName = (TextView) findViewById(R.id.userFullName);
        SharedPreferences userPref = getSharedPreferences("userInfo",Context.MODE_PRIVATE);
        String fullName = userPref.getString("username","");
        fullName.toUpperCase();
        tfUserName.setText(fullName);






    }
}
