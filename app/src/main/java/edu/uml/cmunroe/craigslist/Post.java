package edu.uml.cmunroe.craigslist;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Post {
    public final String title;
    public final double price;
    public final String location;
    public final String body;
    public final String email;

    public Post() {
        this.title = "";
        this.price = -1;
        this.location = "";
        this.body = "";
        this.email = "";
    }

    public Post(String title, double price, String location, String body, String email) {
        this.title = title;
        this.price = price;
        this.location = location;
        this.body = body;
        this.email = email;
    }

    public Post(AppCompatActivity activity) {
        TextView title_view = activity.findViewById(R.id.rlap_title_edittext);
        TextView price_view = activity.findViewById(R.id.rlap_price_edittext);
        TextView location_view = activity.findViewById(R.id.rlap_location_edittext);
        TextView body_view = activity.findViewById(R.id.rlap_body_edittext);
        TextView email_view = activity.findViewById(R.id.rlap_email_edittext);

        title = title_view.getText().toString();
        String price_str = price_view.getText().toString();
        if (price_str.equals("")) {
            price = 0;
        } else {
            price = Double.parseDouble(price_str);
        }
        location = location_view.getText().toString();
        body = body_view.getText().toString();
        email = email_view.getText().toString();
    }
}
