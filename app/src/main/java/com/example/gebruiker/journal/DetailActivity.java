package com.example.gebruiker.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by ${Steven} on ${27/2}.
 */

public class DetailActivity extends AppCompatActivity {

    // gets info from main activity about clicked lists, and represents this in activity_detail.xml format
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        JournalEntry detailEntry = (JournalEntry) intent.getSerializableExtra("currentEntry");

        TextView title = findViewById(R.id.TitleID);
        TextView content = findViewById(R.id.ContentID);
        TextView mood = findViewById(R.id.MoodID);
        TextView time = findViewById(R.id.TimeID);

        title.setText(detailEntry.getTitle());
        content.setText(detailEntry.getContent());
        mood.setText(detailEntry.getMood());
        time.setText(detailEntry.getTime());
    }
}
