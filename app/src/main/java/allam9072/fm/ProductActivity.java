package allam9072.fm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        TextView textView = findViewById(R.id.tv_product_activity);
        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("prod_title"));
    }
}
