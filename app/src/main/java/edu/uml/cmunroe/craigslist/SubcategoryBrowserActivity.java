package edu.uml.cmunroe.craigslist;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SubcategoryBrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        String subcategory = b.getString("subcategory");
        setContentView(R.layout.activity_subcategory_browser);

        TextView header = findViewById(R.id.subcategory_browser_header);
        header.setPaintFlags(header.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        header.setText(subcategory);

        LinearLayout ll = findViewById(R.id.subcategory_browser_linear_layout);
        ll.addView(new SubcategoryBrowserView(getApplicationContext(), subcategory));
    }
}
