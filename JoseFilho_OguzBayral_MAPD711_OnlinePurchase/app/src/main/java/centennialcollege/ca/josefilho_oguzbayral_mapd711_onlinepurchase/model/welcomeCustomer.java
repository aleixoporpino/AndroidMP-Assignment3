package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.R;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao.CsrDAO;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao.CustomerDAO;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.orderSubmit;


public class welcomeCustomer extends AppCompatActivity {

    CsrDAO csrDAO;
    CustomerDAO customerDAO;
    RadioGroup shoeType;
    RadioGroup shoeSize;
    RadioButton selectedShoeType;
    RadioButton selectedShoeSize;
    String typeTag;
    String sizeTag;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_customer);
        shoeType = (RadioGroup) findViewById(R.id.radioGroupshoe);
        shoeSize = (RadioGroup) findViewById(R.id.radioGroupsize);
        TextView tfUserName = (TextView) findViewById(R.id.userFullName);
        SharedPreferences userPref = getSharedPreferences("userInfo",Context.MODE_PRIVATE);
        String fullName = userPref.getString("username","");
        fullName.toUpperCase();
        tfUserName.setText(fullName);
        Log.d("SIZE", "value:");

    }


    public void order(View v)
    {
        EditText shoeQuantity =  findViewById(R.id.etQuantity);
        typeTag = shoeTypeClick(null);
        sizeTag = shoeSizeClick(null);

        Intent intent=new Intent(welcomeCustomer.this, orderSubmit.class);
        intent.putExtra("quantity",shoeQuantity.getText().toString());
        SharedPreferences sharedPref = getSharedPreferences("orderInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        if(typeTag.equals("men")){
            editor.putString("shoeType","Mens Shoe");
        }
        if(typeTag.equals("women")){
            editor.putString("shoeType","Womens Shoe");
        }
        if(typeTag.equals("kid")){
            editor.putString("shoeType","Kids Shoe");
        }
        if(sizeTag.equals("small")){
            editor.putString("shoeSize","Small");
        }
        if(sizeTag.equals("medium")){
            editor.putString("shoeSize","Medium");
        }
        if(sizeTag.equals("large")){
            editor.putString("shoeSize","Large");
        }
        editor.apply();
        startActivity(intent);
    }

    public String shoeTypeClick(View v){
        int radiobuttonId = shoeType.getCheckedRadioButtonId();
        selectedShoeType = (RadioButton) findViewById(radiobuttonId);
        String typeTag = selectedShoeType.getTag().toString();
        return typeTag;


    }
    public String shoeSizeClick(View v){
        int radiobuttonId = shoeSize.getCheckedRadioButtonId();
        selectedShoeSize = (RadioButton) findViewById(radiobuttonId);
        String sizeTag = selectedShoeSize.getTag().toString();
        return sizeTag;
    }

}
