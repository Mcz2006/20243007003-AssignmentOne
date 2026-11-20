package com.example.assignmentone;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Detail screen of CampusLife.
 *
 * <p>Until Part H this screen only shows the place-saver text declared in
 * activity_detail.xml; the real topic content is loaded from arrays.xml later.</p>
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        WindowInsetsHelper.applyBottomInset(findViewById(R.id.detailRoot));
    }
}
