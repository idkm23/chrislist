package edu.uml.cmunroe.craigslist;

/**
 * Created by pepe on 1/13/2018.
 */

public class Category {
    public final String category_name;
    public final String[] subcategories;
    public Category(final String category_name, final String[] subcategories) {
        this.category_name = category_name;
        this.subcategories = subcategories;
    }
    public static Category[] makeCategories(final String[] category_names, final String[][] subcategory_names) {
        final Category[] categories = new Category[category_names.length];
        for (int i = 0; i < categories.length; i++) {
            categories[i] = new Category(category_names[i], subcategory_names[i]);
        }
        return categories;
    }
}
