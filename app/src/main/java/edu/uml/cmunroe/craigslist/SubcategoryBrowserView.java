package edu.uml.cmunroe.craigslist;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SubcategoryBrowserView extends LinearLayout {
    public SubcategoryBrowserView(Context context, final String subcategory) {
        super(context);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        setOrientation(LinearLayout.VERTICAL);

        // load dynamic postings
    }
}
