package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao.CsrDAO;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao.CustomerDAO;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.Csr;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.Customer;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.welcomeCsr;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.welcomeCustomer;

import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    private CsrDAO csrDAO = new CsrDAO(this);
    private CustomerDAO customerDAO = new CustomerDAO(this);
    private RadioGroup rg;
    RadioButton rb;
    private int loginType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = findViewById(R.id.radioGroup);
        loginType = rg.getCheckedRadioButtonId();


        Collection<Customer> customers = customerDAO.findAll();
        System.out.println(customers);
    }

    public void login(View v) {
        //Intent intent;
        EditText etFullName = findViewById(R.id.r1editText);
        EditText etPassword = findViewById(R.id.r2editText);
        String fullName = etFullName.getText().toString();
        String password = etPassword.getText().toString();
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        Collection<Customer> customers = customerDAO.findAll();
        System.out.println(customers);
        Collection<Csr> csrs = csrDAO.findAll();
        System.out.println(csrs);

        RadioButton rbSelected = findViewById(loginType);
        if (rbSelected.getText().toString().contains("Customer")) {
            Customer customer = customerDAO.login(fullName, password);
            if (customer != null && customer.getCustomerId() != null) {
                editor.putString("username", fullName);
                editor.apply();
                //instantiate intent class
                Intent intent = new Intent(MainActivity.this, welcomeCustomer.class);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Invalid login or password", Toast.LENGTH_LONG).show();
                etFullName.setText("");
                etPassword.setText("");
                etFullName.requestFocus();
            }

        } else if (rbSelected.getText().toString().contains("CSR")) {
            Csr csr = csrDAO.login(fullName, password);
            if (csr != null && csr.getEmployeeId() != null) {
                editor.putString("username", fullName);
                editor.apply();
                //instantiate intent class
                Intent intent = new Intent(MainActivity.this, welcomeCsr.class);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Invalid login or password", Toast.LENGTH_LONG).show();
                etFullName.setText("");
                etPassword.setText("");
                etFullName.requestFocus();
            }
        }

    }

    public void rbClick(View v) {
        loginType = rg.getCheckedRadioButtonId();
    }

    public void signUpCustomer(View view) {
        Intent intent = new Intent(MainActivity.this, CustomerSignUp.class);
        startActivity(intent);
    }

    public void signUpCsr(View view) {
        Intent intent = new Intent(MainActivity.this, CSRSignUp.class);
        startActivity(intent);
    }
}