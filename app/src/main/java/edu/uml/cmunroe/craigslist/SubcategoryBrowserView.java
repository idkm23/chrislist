package edu.uml.cmunroe.craigslist;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SubcategoryBrowserView extends LinearLayout {
    private FirebaseDatabase database;
    private String subcategory;

    public SubcategoryBrowserView(Context context, final String subcategory) {
        super(context);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        setOrientation(LinearLayout.VERTICAL);
        this.subcategory = subcategory;
        database = FirebaseDatabase.getInstance();
        load_page(0);
    }

    public void load_page(int page) {
        Query query =
                database.getReference("posts").child(subcategory).orderByKey().limitToLast(6);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                ArrayList<DataSnapshot> postings = new ArrayList();
                for (final DataSnapshot posting : dataSnapshot.getChildren()) {
                    postings.add(0, posting);
                }
                for (final DataSnapshot posting: postings) {
                    Log.i("chrislist", posting.toString());

                    TextView text_view = new TextView(getContext());
                    text_view.setLayoutParams(
                            new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
                    text_view.setTextSize(24); //sp
                    text_view.setTextColor(getResources().getColor(R.color.colorPrimary));
                    text_view.setBackground(getResources().getDrawable(R.drawable.border));
                    text_view.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent i = new Intent(getContext(), ViewPostActivity.class);
                            i.putExtra("subcategory", subcategory);
                            i.putExtra("post_id", posting.getKey());
                            getContext().startActivity(i);
                        }
                    });

                    String title_str = posting.child("title").getValue(String.class);
                    if (title_str == null || title_str.isEmpty()) {
                        title_str = "[no title]";
                    }
                    String price_str;
                    if (posting.child("price").getValue(Double.class) != 0) {
                        price_str = ViewUtils.formatPrice(
                                posting.child("price").getValue(Double.class));
                    } else {
                        price_str = "[no price]";
                    }
                    String location_str = posting.child("location").getValue(String.class);
                    if (location_str == null || location_str.isEmpty()) {
                        location_str = "no location";
                    }
                    String text = String.format("%s, - %s (%s)", title_str, price_str, location_str);
                    text_view.setText(text);
                    addView(text_view);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("chrislist", "database cancelled");
            }
        });
    }

    public void reset() {

    }
}
