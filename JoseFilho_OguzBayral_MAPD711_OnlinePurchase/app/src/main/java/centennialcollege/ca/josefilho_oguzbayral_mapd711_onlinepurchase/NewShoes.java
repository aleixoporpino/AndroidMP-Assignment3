package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao.ShoesDAO;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.Shoes;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.welcomeCsr;

public class NewShoes extends AppCompatActivity {

    private EditText txtName;
    private EditText txtShoeSize;
    private EditText txtPrice;
    private Spinner spinnerCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_shoes);

        txtName = findViewById(R.id.txtShoeName);
        txtShoeSize = findViewById(R.id.txtShoeSize);
        txtPrice = findViewById(R.id.txtShoePrice);
        spinnerCategory = findViewById(R.id.spinnerCategory);

        // Create a adapter to the category type spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.category_array, android.R.layout.simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapter);
    }

    public void save(View view) {
        boolean formValid = true;
        ShoesDAO shoesDAO = new ShoesDAO(this);
        Shoes shoes = new Shoes();
        // Validate all the required fields in the form
        if (TextUtils.isEmpty(txtName.getText().toString().trim())) {
            txtName.setError("Name is required!");
            formValid = false;
        }
        if (TextUtils.isEmpty(txtShoeSize.getText().toString().trim())) {
            txtShoeSize.setError("Shoe size is required!");
            formValid = false;
        }
        if (TextUtils.isEmpty(txtPrice.getText().toString().trim())) {
            txtPrice.setError("Price is required!");
            formValid = false;
        }


        if (formValid) {
            shoes.setShoeSize(Double.parseDouble(txtShoeSize.getText().toString()));
            shoes.setCategory(spinnerCategory.getSelectedItem().toString());
            shoes.setItemName(txtName.getText().toString());
            shoes.setPrice(Double.parseDouble(txtPrice.getText().toString()));
            shoesDAO.insert(shoes);

            Intent intent = new Intent(NewShoes.this, ShoesActivity.class);
            startActivity(intent);
        }

    }
}
