package edu.uml.cmunroe.craigslist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class CategoryButtonView extends LinearLayout {
    public final LinearLayout subcategory_links;
    public CategoryButtonView(final Context context, final Category category) {
        super(context);
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        setOrientation(LinearLayout.VERTICAL);

        AppCompatTextView category_btn = new AppCompatTextView(context);
        category_btn.setLayoutParams(
                new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        category_btn.setTextSize(24); //sp
        category_btn.setTextColor(getResources().getColor(R.color.colorPrimary));
        category_btn.setBackground(getResources().getDrawable(R.drawable.border));
        category_btn.setTypeface(null, Typeface.BOLD);
        category_btn.setPaintFlags(category_btn.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        category_btn.setText(category.category_name);
        addView(category_btn);

        subcategory_links = new LinearLayout(context);
        subcategory_links.setOrientation(LinearLayout.VERTICAL);
        subcategory_links.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 0));
        subcategory_links.setVisibility(GONE);
        subcategory_links.setBackground(getResources().getDrawable(R.drawable.border));
        for (final String subcategory : category.subcategories) {
            AppCompatTextView subcategory_link = new AppCompatTextView(context);
            subcategory_link.setLayoutParams(
                    new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            subcategory_link.setTextSize(24); //sp
            subcategory_link.setTextColor(getResources().getColor(R.color.colorPrimary));
            subcategory_link.setText(subcategory);
            subcategory_link.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, SubcategoryBrowserActivity.class);
                    i.putExtra("subcategory", subcategory);
                    context.startActivity(i);
                }
            });
            subcategory_links.addView(subcategory_link);
        }
        addView(subcategory_links);

        category_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("chrislist", "clicked " + category.category_name);
                boolean is_visible = subcategory_links.getVisibility() == View.VISIBLE;

                if (is_visible) {
                    Log.i("chrislist", "COLLAPSE");
                    ViewUtils.collapse(subcategory_links);
                } else {
                    Log.i("chrislist", "EXPAND");
                    ViewUtils.expand(subcategory_links);
                }
            }
        });
    }
}
