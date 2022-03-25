package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class CreateDbInventory extends SQLiteOpenHelper {

    public static final String TABLE_ITEM = "item";
    private static final String CREATE_TABLE_ITEM =
            "CREATE TABLE " + TABLE_ITEM + "(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "reference TEXT NOT NULL, " +
                    "name TEXT NOT NULL, " +
                    "price REAL," +
                    "amount INTEGER);";

    // Constructeur, Ã  gÃ©nÃ©rer automatiquement
    public CreateDbInventory(@Nullable Context context, @Nullable String name,
                             @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * CrÃ©ation de la base de donnÃ©es si elle n'existe pas
     *
     * @param db base
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ITEM);
        Log.d("bdd", "Base crÃ©Ã©e");
    }

    /**
     * CrÃ©ation d'une nouvelle base en cas de changement de version
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_ITEM + ";");
        Log.d("bdd", "Table " + TABLE_ITEM + " supprimÃ©e");
        onCreate(db);
    }

}
