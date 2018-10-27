package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao.CustomerDAO;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.Customer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hey

        /*CustomerDAO customerDAO = new CustomerDAO(this);

        Customer customer = customerDAO.login("admin","1223456");

        System.out.println(customer);*/

    }
}
