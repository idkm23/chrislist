package edu.uml.cmunroe.craigslist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SubcategoryBrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        final String subcategory = b.getString("subcategory");
        setContentView(R.layout.activity_subcategory_browser);

        TextView header = findViewById(R.id.subcategory_browser_header);
        header.setText(subcategory);

        LinearLayout ll = findViewById(R.id.subcategory_browser_linear_layout);
        ll.addView(new SubcategoryBrowserView(getApplicationContext(), subcategory));

        Button post_button = findViewById(R.id.post_button);
        post_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), PostActivity.class);
                i.putExtra("subcategory", subcategory);
                getApplicationContext().startActivity(i);
            }
        });
    }
}
