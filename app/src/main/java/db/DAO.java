package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DAO {

    private static final int VERSION_DB = 1;
    private static final String NOM_DB = "inventory.db";
    private final CreateDbInventory createDb;
    private SQLiteDatabase db = null;

    public DAO (Context context) {
        createDb = new CreateDbInventory(context, NOM_DB, null, VERSION_DB);
        Log.d( "bdd", "Appel au constructeur de DAO ok");
    }

    public SQLiteDatabase open() {
        if (db == null) {
            db = createDb.getWritableDatabase();
            Log.d( "bdd", "Base de donnÃ©es ouverte");
        } else {
            Log.d( "bdd", "Base de donnÃ©es accesible");
        }
        return db;
    }

    public void close() {
        if (db != null) {
            db.close();
            Log.d( "bdd", "Base de donnÃ©es fermÃ©e");
        }
    }

}
