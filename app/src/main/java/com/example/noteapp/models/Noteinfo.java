package com.example.noteapp.models;

import android.widget.TextView;

public class Noteinfo {
    private String textView;





    public Noteinfo(String textView) {
        this.textView = textView;
    }

    public String getTextView() {
        return textView;
    }

    public void setTextView(String textView) {
        this.textView = textView;
    }
}
