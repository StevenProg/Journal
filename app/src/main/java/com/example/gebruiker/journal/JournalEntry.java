package com.example.gebruiker.journal;

import java.io.Serializable;

/**
 * Created by ${Steven} on ${27/2}.
 */

public class JournalEntry implements Serializable {
    private String title, content, mood, time;

    public JournalEntry(String title, String content, String mood) {
        this.title = title;
        this.content = content;
        this.mood = mood;
    }

    public JournalEntry(String title, String content, String mood, String Time) {
        this.title = title;
        this.content = content;
        this.mood = mood;
        this.time = Time;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getMood() {
        return mood;
    }

    public String getTime() {
        return time;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
