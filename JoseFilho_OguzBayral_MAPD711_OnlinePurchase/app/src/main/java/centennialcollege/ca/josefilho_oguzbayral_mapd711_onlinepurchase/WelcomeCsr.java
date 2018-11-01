package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class WelcomeCsr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_csr);
        TextView tfUserName = (TextView) findViewById(R.id.userFullName);
        SharedPreferences userPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String fullName = userPref.getString("username", "");
        fullName.toUpperCase();
        tfUserName.setText(fullName);

    }

    public void clickShoes(View view) {
        Intent intent = new Intent(WelcomeCsr.this, ShoesActivity.class);
        startActivity(intent);
    }

    public void clickOrders(View view) {
        Intent intent = new Intent(WelcomeCsr.this, OrdersActivity.class);
        startActivity(intent);
    }

    public void signOut(View view) {
        Intent intent = new Intent(WelcomeCsr.this, MainActivity.class);
        startActivity(intent);
    }
}
