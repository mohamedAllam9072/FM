package allam9072.fm.ui.ListActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import allam9072.fm.DB.JsonAPI;
import allam9072.fm.DB.Product;
import allam9072.fm.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListActivity extends AppCompatActivity {
    ListAdapter listAdapter;
    private RecyclerView rv;
    String categoryTitle;
    List<Product> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(categoryTitle);
        toolbar.setNavigationIcon(R.drawable.ic_arrow);


        Intent intent = getIntent();
        categoryTitle = intent.getStringExtra("cat_title");

        rv = findViewById(R.id.rv_2);
        rv.setLayoutManager(new GridLayoutManager(this, 2));
     //   retrofit();


         setList();


    }


    private void retrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://5bcce576cf2e850013874767.mockapi.io/task/1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonAPI jsonAPI = retrofit.create(JsonAPI.class);
        Call<List<Product>> call = jsonAPI.getAllProducts();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> productList = response.body();
                listAdapter = new ListAdapter(getApplicationContext(), productList);
                rv.setAdapter(listAdapter);

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    void setList() {
        list = new ArrayList<>();
        list.add(new Product(R.drawable.meat1, "meat1", "100", "s"));
        list.add(new Product(R.drawable.meat2, "meat2", "200", "a"));
        list.add(new Product(R.drawable.meat3, "meat3", "300", "d"));
        list.add(new Product(R.drawable.meat4, "meat4", "1400", "f"));
        list.add(new Product(R.drawable.meat5, "meat5", "500", "g"));
        list.add(new Product(R.drawable.meat1, "meat6", "600", "h"));
        list.add(new Product(R.drawable.meat2, "meat7", "700", "j"));
        list.add(new Product(R.drawable.meat3, "meat8", "800", "k"));
        listAdapter = new ListAdapter(getApplicationContext(), list);
        rv.setAdapter(listAdapter);
    }

}
