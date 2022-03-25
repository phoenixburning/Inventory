package com.example.inventory;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialisations();
    }

    private void initialisations() {
        // Find exit button
        Button btQuitter = findViewById(R.id.btQuit);
        // Set listener on exit button
        btQuitter.setOnClickListener(v -> finish());

        // Set event on add button
        Button btAddFurniture = findViewById(R.id.btAddItem);
        btAddFurniture.setOnClickListener(view -> startAdd());

        // Set event on list button
        Button btListFurniture = findViewById(R.id.btListItems);
        btListFurniture.setOnClickListener(view -> startList());
    }

    private void startAdd() {
        Intent intent = new Intent( MainActivity.this, AddItemActivity.class);
        startActivity(intent);
    }

    private void startList() {
        Intent intent = new Intent( MainActivity.this, ListItemsActivity.class);
        startActivity(intent);
    }


}