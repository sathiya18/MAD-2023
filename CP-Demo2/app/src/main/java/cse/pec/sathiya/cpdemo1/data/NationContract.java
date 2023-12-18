package cse.pec.sathiya.cpdemo1.data;

import android.net.Uri;
import android.provider.BaseColumns;

/* A contract class contains constants that define names for URIs, tables, and columns.  */
public final class NationContract {
                                                   //<package_name.MyCP
    public static final String CONTENT_AUTHORITY = "cse.pec.sathiya.cpdemo1.data.NationProvider";

    // BASE_CONTENT_URI: content://cse.pec.sathiya.cpdemo1.data.NationProvider
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // Path to get CLIENT APP to our table
    public static final String PATH_COUNTRIES = "countries";

    public static final class NationEntry implements BaseColumns {

        // CONTENT_URI: content://cse.pec.sathiya.cpdemo1.data.NationProvider/countries
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_COUNTRIES);

        // Table Name
        public static final String TABLE_NAME = "countries";

        // Columns
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_COUNTRY = "country";
        public static final String COLUMN_CONTINENT = "continent";
    }
}

