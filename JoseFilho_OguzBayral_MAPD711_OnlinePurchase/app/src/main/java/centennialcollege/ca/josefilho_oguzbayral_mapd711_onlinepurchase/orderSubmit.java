package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class orderSubmit extends AppCompatActivity {


    private TextView shoeType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_submit);

        TextView shoeSize = (TextView) findViewById(R.id.shoeSize);
        TextView shoeType = (TextView) findViewById(R.id.shoeType);
        TextView shoeQuantity = (TextView) findViewById(R.id.shoeQuantity);
        TextView tfUserName = (TextView) findViewById(R.id.userFullName);
        Intent intent= getIntent();
        SharedPreferences userPref = getSharedPreferences("userInfo",Context.MODE_PRIVATE);
        String fullName = userPref.getString("username","");
        fullName.toUpperCase();
        tfUserName.setText(fullName);
        SharedPreferences orderPref = getSharedPreferences("orderInfo",Context.MODE_PRIVATE);
        String shoeType1 = orderPref.getString("shoeType","");
        String shoeSize1 = orderPref.getString("shoeSize","");
        shoeType.setText(shoeType1);
        shoeSize.setText(shoeSize1);
        String quantity = intent.getStringExtra("quantity");
        shoeQuantity.setText(quantity);

    }
}
