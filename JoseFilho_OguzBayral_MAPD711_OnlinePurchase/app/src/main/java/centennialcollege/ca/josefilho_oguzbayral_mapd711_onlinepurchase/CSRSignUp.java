package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao.CsrDAO;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.Csr;

public class CSRSignUp extends AppCompatActivity {

    private EditText txtUsername;
    private EditText txtPassword;
    private EditText txtLastName;
    private EditText txtFirstName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csrsign_up);

        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        txtLastName = findViewById(R.id.txtLastName);
        txtFirstName = findViewById(R.id.txtFirstName);
    }

    public void signUp(View view) {
        boolean formValid = true;
        CsrDAO csrDAO = new CsrDAO(this);
        Csr csr = new Csr();
        // Validate all the required fields in the form
        if (TextUtils.isEmpty(txtUsername.getText().toString().trim())) {
            txtUsername.setError("User name is required!");
            formValid = false;
        }
        if (TextUtils.isEmpty(txtPassword.getText().toString().trim())) {
            txtPassword.setError("Password is required!");
            formValid = false;
        }
        if (TextUtils.isEmpty(txtLastName.getText().toString().trim())) {
            txtLastName.setError("Last name is required!");
            formValid = false;
        }
        if (TextUtils.isEmpty(txtFirstName.getText().toString().trim())) {
            txtFirstName.setError("First name is required!");
            formValid = false;
        }

        if (formValid) {
            csr.setUserName(txtUsername.getText().toString());
            csr.setPassword(txtPassword.getText().toString());
            csr.setLastName(txtLastName.getText().toString());
            csr.setFirstName(txtFirstName.getText().toString());
            csrDAO.insert(csr);

            Intent intent = new Intent(CSRSignUp.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
