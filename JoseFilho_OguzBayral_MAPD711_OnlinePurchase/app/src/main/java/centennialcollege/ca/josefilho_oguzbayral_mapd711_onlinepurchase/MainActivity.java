package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.util.Log;


import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao.CsrDAO;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao.CustomerDAO;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.Customer;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.Csr;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.welcomeCsr;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.welcomeCustomer;

public class MainActivity extends AppCompatActivity {

    CsrDAO csrDAO;
    CustomerDAO customerDAO;
    RadioGroup rg;
    int loginType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
    }

        public void login(View v)
        {
            //Intent intent;
            EditText etFullName = findViewById(R.id.r1editText);
            EditText etPassword = findViewById(R.id.r2editText);
            String fullName = etFullName.getText().toString();
            String password = etPassword.getText().toString();
            SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("username",fullName);
            editor.putString("password",password);
            editor.apply();


            if(loginType%2 == 0){
                //Customer customer = customerDAO.login(fullName,password);
                //instantiate intent class
                Intent intent=new Intent(MainActivity.this, welcomeCustomer.class);
                startActivity(intent);

            }
            else if(loginType%2 == 1){
                //Csr csr = csrDAO.login(fullName,password);
                //instantiate intent class
                Intent intent=new Intent(MainActivity.this, welcomeCsr.class);
                startActivity(intent);
            }
            //startActivity(intent);
           /*

        /*CustomerDAO customerDAO = new CustomerDAO(this);

        Customer customer = customerDAO.login("admin","123456");

        System.out.println(customer);*/


        }
        public void rbClick(View v){
            int radiobuttonId = rg.getCheckedRadioButtonId();
            loginType = radiobuttonId;
            Log.d("MYINT", "value: " + loginType);

        }
}