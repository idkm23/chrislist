package edu.uml.cmunroe.craigslist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewPostActivity extends AppCompatActivity {

    private String subcategory = "null";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getIntent().getExtras();
        final String post_id = b.getString("post_id");
        subcategory = b.getString("subcategory");

        setContentView(R.layout.activity_view_post);
        loadPostFromFirebase(post_id);
    }

    private void loadPostFromFirebase(String post_id) {
        final TextView title = findViewById(R.id.rvlap_title);
        final TextView price = findViewById(R.id.rvlap_price);
        final TextView location = findViewById(R.id.rvlap_location);
        final TextView email = findViewById(R.id.rvlap_email);
        final TextView body = findViewById(R.id.rvlap_body);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef =
                database.getReference("posts").child(subcategory).child(post_id);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("chrislist", "Value is: " + dataSnapshot);
                String title_str = dataSnapshot.child("title").getValue(String.class);
                if (title_str == null || title_str.isEmpty()) {
                    title_str = "[no title]";
                }
                String price_str;
                if (dataSnapshot.child("price").getValue(Double.class) != 0) {
                    price_str = ViewUtils.formatPrice(
                            dataSnapshot.child("price").getValue(Double.class));
                } else {
                    price_str = "[no price]";
                }
                String location_str = dataSnapshot.child("location").getValue(String.class);
                if (location_str == null || location_str.isEmpty()) {
                    location_str = "[no location]";
                }
                String email_str = dataSnapshot.child("email").getValue(String.class);
                if (email_str == null || email_str.isEmpty()) {
                    email_str = "[no email]";
                }
                String body_str = dataSnapshot.child("body").getValue(String.class);
                if (body_str == null || body_str.isEmpty()) {
                    body_str = "[no body]";
                }

                title.setText(title_str);
                price.setText(price_str);
                location.setText(location_str);
                email.setText(email_str);
                body.setText(body_str);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("chrislist", "Failed to read value.", error.toException());
            }
        });
    }

    // Ensures we do not return to a potential submission form
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent a = new Intent(this, SubcategoryBrowserActivity.class);
            a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(a);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}