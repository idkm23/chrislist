package edu.uml.cmunroe.craigslist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class CategoryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        generateView();
    }

    protected void generateView() {
        LinearLayout ll = findViewById(R.id.category_menu_linear_layout);
        for(final Category c : Constants.category_map) {
            CategoryButtonView category_btn = new CategoryButtonView(this, c);
            ll.addView(category_btn);
        }
    }
}