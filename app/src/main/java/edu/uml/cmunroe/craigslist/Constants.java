package edu.uml.cmunroe.craigslist;

/**
 * Created by pepe on 1/13/2018.
 */

public class Constants {
    public static final String[] category_names = {"community", "personals", "housing", "for sale",
            "services", "jobs", "gigs"};
    public static final String[][] subcategory_names = {
            // community
            {"activities", "artists", "childcare", "classes", "events", "general", "groups",
                    "local", "news", "lost+found", "musicians", "pets", "politics", "rideshare",
                    "volunteers"},
            // personals
            {"strictly platonic", "women seeking women", "women seeking men", "men seeking women",
                    "men seeking men", "misc romance", "casual encounters", "missed connections",
                    "rants and raves"},
            // housing
            {"apts / housing", "housing swap", "housing wanted", "office / commercial",
                    "parking / storage", "real estate for sale", "rooms / shared", "rooms wanted",
                    "sublets / temporary", "vacation rentals"},
            // for sale
            {"antiques", "appliances", "arts+crafts", "atv/utv/sno", "auto parts", "baby+kid",
                    "barter", "beauty+hlth", "bikes", "boats", "books", "business", "cars+trucks",
                    "cds/dvd/vhs", "cell phones", "clothes+acc", "collectibles", "computers",
                    "electronics", "farm+garden", "free", "furniture", "garage sale", "general",
                    "heavy equip", "household", "jewelry", "materials", "motorcycles",
                    "music instr", "photo+video", "rvs+camp", "sporting", "tickets", "tools",
                    "toys+games", "trailers", "video gaming", "wanted"},
            // services
            {"automotive", "beauty", "cell/mobile", "computer", "creative", "cycle", "event",
                    "farm+garden", "financial", "household", "labor/move", "legal", "lessons",
                    "marine", "pet", "real estate", "skilled trade", "sm biz ads", "therapeutic",
                    "travel/vac", "write/ed/tran"},
            // jobs
            {"accounting+finance", "admin / office", "arch / engineering", "art / media / design",
                    "biotech / science", "business / mgmt", "customer service", "education",
                    "food / bev / hosp", "general labor", "government", "human resources",
                    "internet engineers", "legal / paralegal", "manufacturing",
                    "marketing / pr / ad", "medical / health", "nonprofit sector",
                    "real estate", "retail / wholesale", "sales / biz dev", "salon / spa / fitness",
                    "security", "skilled trade / craft", "software / qa / dba",
                    "systems / network technical support", "transport", "tv / film / video",
                    "web / info design", "writing / editing", "[ETC]", "[ part-time ]"},
            // gigs
            {"computer", "creative", "crew", "domestic", "event", "labor", "talent", "writing"},
    };

    public static final Category[] category_map = Category.makeCategories(category_names, subcategory_names);
}
