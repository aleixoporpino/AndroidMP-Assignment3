package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
<<<<<<< HEAD

import android.widget.EditText;
import android.widget.RadioButton;
=======
>>>>>>> e9e2b615106b059b83d85b69d7e3c096581bbd69
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
        SharedPreferences userPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String fullName = userPref.getString("username", "");
        fullName.toUpperCase();
        tfUserName.setText(fullName);
        Log.d("SIZE", "value:");

    }


<<<<<<< HEAD
    public void order(View v)
    {
        EditText shoeQuantity =  findViewById(R.id.etQuantity);
        typeTag = shoeTypeClick(null);
        sizeTag = shoeSizeClick(null);

        Intent intent=new Intent(welcomeCustomer.this, orderSubmit.class);
        intent.putExtra("quantity",shoeQuantity.getText().toString());
        SharedPreferences sharedPref = getSharedPreferences("orderInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
=======
    public void order(View v) {

        Intent intent = new Intent(welcomeCustomer.this, orderSubmit.class);
        SharedPreferences sharedPref = getSharedPreferences("orderInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        if (shoe % 2 == 0) {
            editor.putString("shoeType", "Mens Shoe");
>>>>>>> e9e2b615106b059b83d85b69d7e3c096581bbd69

        if(typeTag.equals("men")){
            editor.putString("shoeType","Mens Shoe");
        }
<<<<<<< HEAD
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
=======
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
>>>>>>> e9e2b615106b059b83d85b69d7e3c096581bbd69
        }
        editor.apply();
        startActivity(intent);
    }

<<<<<<< HEAD
    public String shoeTypeClick(View v){
=======
    public void shoeTypeClick(View v) {
>>>>>>> e9e2b615106b059b83d85b69d7e3c096581bbd69
        int radiobuttonId = shoeType.getCheckedRadioButtonId();
        selectedShoeType = (RadioButton) findViewById(radiobuttonId);
        String typeTag = selectedShoeType.getTag().toString();
        return typeTag;


    }
<<<<<<< HEAD
    public String shoeSizeClick(View v){
=======

    public void shoeSizeClick(View v) {
>>>>>>> e9e2b615106b059b83d85b69d7e3c096581bbd69
        int radiobuttonId = shoeSize.getCheckedRadioButtonId();
        selectedShoeSize = (RadioButton) findViewById(radiobuttonId);
        String sizeTag = selectedShoeSize.getTag().toString();
        return sizeTag;
    }
}
