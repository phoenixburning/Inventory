package db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import job.Item;

public class ItemDAO {

    private final DAO dao;
    private final SQLiteDatabase db;

    public ItemDAO(Context context) {
        dao = new DAO(context);
        db = dao.open();
    }

    /**
     * Closing database
     */
    public void close() {

        dao.close();
    }

    public long create(Item i) {
        ContentValues values = new ContentValues();
        values.put("reference", i.reference());
        values.put("name", i.name());
        values.put("price", i.price());
        values.put("amount", i.amount());
        Log.d("bdd", "insert, : " + i);
        return db.insert(CreateDbInventory.TABLE_ITEM, null, values);
    }

    public long delete(Item a) {
        String[] values = {a.reference(), a.name(), ""+ a.price(), "" + a.amount()};
        Log.d("bdd", "delete, : " + a);
        return db.delete(CreateDbInventory.TABLE_ITEM, "reference=? AND name=? AND price=? AND amount=?", values);
    }

    public Cursor readItems() {
        String reqSQL = "SELECT id AS '_id', reference, name, price, amount FROM " + CreateDbInventory.TABLE_ITEM + ";";
        // Request execution
        Cursor c = db.rawQuery(reqSQL, null);
        Log.d("bdd", "Le curseur contient " + c.getCount() + "lignes");
        return c;
    }

}
