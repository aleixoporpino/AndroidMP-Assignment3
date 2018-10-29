package centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.dao.ShoesDAO;
import centennialcollege.ca.josefilho_oguzbayral_mapd711_onlinepurchase.model.Shoes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ShoesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoes);

        ShoesDAO shoesDAO = new ShoesDAO(this);
        List<Shoes> shoes = new ArrayList<>(shoesDAO.findAll());

        ListView listView = findViewById(R.id.shoes_list);

        ArrayAdapter<Shoes> adapter;
        adapter = new ArrayAdapter<Shoes>(this, android.R.layout.simple_list_item_1, shoes);
        listView.setAdapter(adapter);

    }


    public void addShoes(View view) {
        Intent intent = new Intent(ShoesActivity.this, NewShoes.class);
        startActivity(intent);
    }
}