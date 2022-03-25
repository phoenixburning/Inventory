package com.example.inventory;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import db.ItemDAO;
import job.Item;

public class AddItemActivity extends AppCompatActivity {

    private ItemDAO itemDAO = null;
    Item item = null;

    // Link GUI interface
    private EditText etReference;
    private EditText etName;
    private EditText etPrice;
    private EditText etAmount;

    // New item 
    String reference;
    String name;
    String price;
    float priceN;
    String amount;
    int amountN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        initialisations();
        gererCreationArticle();
    }
    private void initialisations() {
        Button btRetour = findViewById(R.id.btBack);
        // Association d'un Ã©couteur d'Ã©vÃ¨nement au clic de btRetour
        btRetour.setOnClickListener(v -> {
            itemDAO.close();
            finish();
        });
    }

    private void gererCreationArticle() {
// Reconnaissance des contrÃ´les graphiques de la vue
        etReference = findViewById(R.id.etAddReference);
        etName = findViewById(R.id.etAddName);
        etPrice = findViewById(R.id.etAddPrice);
        etAmount = findViewById(R.id.etAddAmount);
        Button btAdd = findViewById(R.id.btAdd);
// AccÃ¨s Ã  la table article
        itemDAO = new ItemDAO(this);
// Gestion de l'Ã©vÃ©nement onClick sur le boutn Ajouter
        btAdd.setOnClickListener(arg0 -> {
// RÃ©cupÃ©ration des zones saisies
            reference = etReference.getText().toString();
            name = etName.getText().toString();
            price = etPrice.getText().toString();
            priceN = Float.parseFloat(price);
            amount = etAmount.getText().toString();
            amountN = Integer.parseInt(amount);
// CrÃ©ation de l'article correspondant
            item = new Item(reference, name, priceN, amountN);
// Insertion de l'article dans la base de donnÃ©es
            long idArticleCree = itemDAO.create(item);
// Message Ã  l'Ã©cran getString(R.string.labelHi)
            Toast.makeText(getApplicationContext(), "Produit ajoutÃ© + " +
                    "(no : " + idArticleCree + " )", Toast.LENGTH_SHORT).show();
// Zones de saisies effacÃ©es
            etReference.setText("");
            etReference.requestFocus();
            etName.setText("");
            etPrice.setText("");
            etAmount.setText("");
        });
    }

}