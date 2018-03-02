package com.example.gebruiker.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by ${Steven} on ${27/2}.
 */

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }

    // creates new entry for in database and sends user to main activity
    public void addEntry(View view) {
        EditText title = findViewById(R.id.InputTitleID);
        EditText mood = findViewById(R.id.InputMoodID);
        EditText content = findViewById(R.id.InputContentID);

        String titleInput = title.getText().toString();
        String moodInput = mood.getText().toString();
        String contentInput = content.getText().toString();

        JournalEntry newEntry = new JournalEntry(titleInput, contentInput, moodInput);
        EntryDatabase.getInstance(this).insert(newEntry);
        Intent intent = new Intent(InputActivity.this, MainActivity.class);
        startActivity(intent);
    }
}

