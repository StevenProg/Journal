package com.example.gebruiker.journal;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by ${Steven} on ${27/2}.
 */
public class MainActivity extends AppCompatActivity {

    FloatingActionButton addButton;
    ListView list;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateData();

        list = findViewById(R.id.listID);
        list.setOnItemClickListener(new ListClickListener());
        list.setOnItemLongClickListener(new ListLongClickListener());
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateData();
    }

    private void updateData() {
        EntryDatabase database = EntryDatabase.getInstance(getApplicationContext());
        Cursor cursor = database.selectAll();

        EntryAdapter adapter = new EntryAdapter(MainActivity.this, cursor);
        list = findViewById(R.id.listID);
        list.setAdapter(adapter);

    }

    // sends user to Input Acitivity (created on the floatingActionButton)
    public void addButtonOnClickListener(View view) {
            Intent intentInput = new Intent(MainActivity.this, InputActivity.class);
            startActivity(intentInput);
        }

    // (short) click listener which sends user to detail activity, along with info about the input
    private class ListClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);

            Cursor entryPos = (Cursor) adapterView.getItemAtPosition(i);

            String entryTitle = entryPos.getString(entryPos.getColumnIndex("Title"));
            String entryContent = entryPos.getString(entryPos.getColumnIndex("Content"));
            String entryMood = entryPos.getString(entryPos.getColumnIndex("Mood"));
            String entryTime = entryPos.getString(entryPos.getColumnIndex("Time"));

            JournalEntry newJournalEntry = new JournalEntry(entryTitle, entryContent, entryMood, entryTime);
            intent.putExtra("currentEntry", newJournalEntry);

            startActivity(intent);
        }
    }

    // long click listener which deletes lists
    private class ListLongClickListener implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            ListView listview = findViewById(R.id.listID);
            int position = listview.getPositionForView(view);

            EntryDatabase.delete(position+ 1);
            updateData();
            return false;
        }
    }
}
