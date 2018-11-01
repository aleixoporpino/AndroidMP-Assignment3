package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao.ShoesDAO;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.Shoes;

public class NewShoes extends AppCompatActivity {

    private EditText txtName;
    private EditText txtShoeSize;
    private EditText txtPrice;
    private Spinner spinnerCategory;
    private Shoes shoes = new Shoes();

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

        Intent intent = getIntent();
        shoes = (Shoes) intent.getSerializableExtra("shoe");
        if (shoes != null) {
            txtName.setText(shoes.getItemName());
            txtPrice.setText(shoes.getPrice() + "");
            txtShoeSize.setText(shoes.getShoeSize() + "");
            spinnerCategory.setPrompt(shoes.getCategory());
        } else {
            shoes = new Shoes();
        }
    }

    public void save(View view) {
        boolean formValid = true;
        ShoesDAO shoesDAO = new ShoesDAO(this);
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

            if (shoes.getItemId() != null) {
                shoesDAO.update(shoes);
            } else {
                shoesDAO.insert(shoes);
            }

            Intent intent = new Intent(NewShoes.this, ShoesActivity.class);
            startActivity(intent);
        }

    }
    public void back(View view) {
        Intent intent = new Intent(NewShoes.this, ShoesActivity.class);
        startActivity(intent);
    }


}
