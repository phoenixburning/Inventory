package com.example.inventory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cursoradapter.widget.SimpleCursorAdapter;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import db.ItemDAO;

public class ListItemsActivity extends AppCompatActivity {

    private ItemDAO itemDAO = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        initialisations();
        showItems();
    }

    private void initialisations() {
        Button btRetour = findViewById(R.id.btBack);
        // Association d'un Ã©couteur d'Ã©vÃ¨nement au clic de btRetour
        btRetour.setOnClickListener(v -> {
            itemDAO.close();
            finish();
        });
    }

    public void showItems() {
        Log.d("bdd", "DÃ©but de afficherLesArticles");
        itemDAO = new ItemDAO(this);
        Cursor c = itemDAO.readItems();
        Toast.makeText(getApplicationContext(), "Il y a " + c.getCount() + " articles", Toast.LENGTH_SHORT).show();
        // Nom des 4 attributs lus de la base de donnÃ©es
        String[] from = new String[] {"reference", "name", "price", "amount"};
        // RÃ©fÃ©rences des contrÃ´les graphiques qui afficheront les valeurs
        int[] to = new int[] {R.id.tvReference, R.id.tvName, R.id.tvPrice, R.id.tvAmount};
        // Adapter : lien entre les donnÃ©es et les contrÃ´les graphiques
        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this, R.id.tvTitle, c, from, to, 0);
        // Affectation de l'adapter a la listView
        ListView lvArticle = findViewById(R.id.lvList);
        lvArticle.setAdapter(dataAdapter);
        itemDAO.close();
    }
}