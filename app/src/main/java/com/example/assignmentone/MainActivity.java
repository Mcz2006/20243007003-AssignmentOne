package com.example.assignmentone;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Home screen of CampusLife: the welcome banner and the four topic ImageButtons.
 *
 * <p>Every button reports its click with a Toast so the onClick wiring can be
 * checked before the detail screen exists (Part E).</p>
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WindowInsetsHelper.applyBottomInset(findViewById(R.id.mainRoot));
    }

    /** Handles a click on the Facilities ImageButton. */
    public void onFacilitiesClick(View view) {
        Toast.makeText(this, R.string.toast_facilities, Toast.LENGTH_SHORT).show();
    }

    /** Handles a click on the Events ImageButton. */
    public void onEventsClick(View view) {
        Toast.makeText(this, R.string.toast_events, Toast.LENGTH_SHORT).show();
    }

    /** Handles a click on the Clubs ImageButton. */
    public void onClubsClick(View view) {
        Toast.makeText(this, R.string.toast_clubs, Toast.LENGTH_SHORT).show();
    }

    /** Handles a click on the Support ImageButton. */
    public void onSupportClick(View view) {
        Toast.makeText(this, R.string.toast_support, Toast.LENGTH_SHORT).show();
    }
}
