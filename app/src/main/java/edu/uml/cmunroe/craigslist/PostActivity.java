package edu.uml.cmunroe.craigslist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

/**
 * Created by pepe on 1/15/2018.
 */

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getIntent().getExtras();
        final String subcategory = b.getString("subcategory");
        setContentView(R.layout.activity_post);
        TextView header = findViewById(R.id.rlap_post_header);
        header.setText(subcategory);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference postRef = database.getReference("posts").child(subcategory);
        Button submit_post_button = findViewById(R.id.submit_post_button);
        submit_post_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Write post to the database
                String post_id = postRef.push().getKey();
                Post new_post = new Post(PostActivity.this);
                Log.i("chrislist", "posting to id: " + post_id);
                postRef.child(post_id).setValue(new_post);

                Intent i = new Intent(getApplicationContext(), ViewPostActivity.class);
                i.putExtra("subcategory", subcategory);
                i.putExtra("post_id", post_id);
                getApplicationContext().startActivity(i);
            }
        });
    }
}
