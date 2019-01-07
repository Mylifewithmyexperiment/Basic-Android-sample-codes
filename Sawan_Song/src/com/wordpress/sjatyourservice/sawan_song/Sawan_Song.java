package com.wordpress.sjatyourservice.sawan_song;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Sawan_Song extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sawan__song);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sawan__song, menu);
        return true;
    }
    
}
