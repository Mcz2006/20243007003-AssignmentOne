package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Home screen of CampusLife.
 *
 * <p>Shows the welcome banner and the four topic ImageButtons. Each button
 * confirms the click with a Toast (Part E) and then starts {@link DetailActivity}
 * with the index of the topic that was chosen (Part G).</p>
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
        openTopic(DetailActivity.TOPIC_FACILITIES);
    }

    /** Handles a click on the Events ImageButton. */
    public void onEventsClick(View view) {
        Toast.makeText(this, R.string.toast_events, Toast.LENGTH_SHORT).show();
        openTopic(DetailActivity.TOPIC_EVENTS);
    }

    /** Handles a click on the Clubs ImageButton. */
    public void onClubsClick(View view) {
        Toast.makeText(this, R.string.toast_clubs, Toast.LENGTH_SHORT).show();
        openTopic(DetailActivity.TOPIC_CLUBS);
    }

    /** Handles a click on the Support ImageButton. */
    public void onSupportClick(View view) {
        Toast.makeText(this, R.string.toast_support, Toast.LENGTH_SHORT).show();
        openTopic(DetailActivity.TOPIC_SUPPORT);
    }

    /**
     * Starts the detail screen for one topic.
     *
     * @param topicIndex index of the topic in the arrays.xml arrays (0-3)
     */
    private void openTopic(int topicIndex) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_TOPIC_INDEX, topicIndex);
        startActivity(intent);
    }
}
