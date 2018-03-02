package com.example.gebruiker.journal;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

/**
 * Created by ${Steven} on ${27/2}.
 */

public class EntryAdapter extends ResourceCursorAdapter {

    EntryAdapter(Context context, Cursor cursor) {
        super(context, R.layout.entry_row, cursor);
    }


    // sets the title and time for in entry_row.xml
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        int TitleIndex =  cursor.getColumnIndex("Title");
        String myTitle = cursor.getString(TitleIndex);

        int TimeIndex = cursor.getColumnIndex("Time");
        String myTime = cursor.getString(TimeIndex);

        TextView titleID = view.findViewById(R.id.RowTitleID);
        TextView clockID = view.findViewById(R.id.RowTimeID);

        titleID.setText(myTitle);
        clockID.setText(myTime);
    }
}
