package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Detail screen of CampusLife.
 *
 * <p>The topic to show is passed in with an explicit Intent extra
 * ({@link #EXTRA_TOPIC_INDEX}). The screen then reads the matching title, body text
 * and icon name from res/values/arrays.xml and populates its views (Part H).</p>
 *
 * <p>No if statements or switch cases are used: the topic index is clamped to a
 * valid range and then used directly as an array index.</p>
 */
public class DetailActivity extends AppCompatActivity {

    /** Key of the int extra that identifies the topic (Part G). */
    public static final String EXTRA_TOPIC_INDEX =
            "com.example.assignmentone.extra.TOPIC_INDEX";

    /** Topic indexes, matching the order of the arrays in arrays.xml. */
    public static final int TOPIC_FACILITIES = 0;
    public static final int TOPIC_EVENTS = 1;
    public static final int TOPIC_CLUBS = 2;
    public static final int TOPIC_SUPPORT = 3;

    /** Used when the activity is opened without a valid topic. */
    private static final int NO_TOPIC = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        WindowInsetsHelper.applyBottomInset(findViewById(R.id.detailRoot));

        populateFromArrays(readTopicIndex());
    }

    /**
     * Reads the topic index passed in by MainActivity.
     *
     * @return the index, or {@link #NO_TOPIC} if the extra is missing
     */
    private int readTopicIndex() {
        Intent intent = getIntent();
        return intent.getIntExtra(EXTRA_TOPIC_INDEX, NO_TOPIC);
    }

    /**
     * Fills the header and the content area with the data held in arrays.xml.
     *
     * @param topicIndex index of the selected topic
     */
    private void populateFromArrays(int topicIndex) {
        String[] headerTitles = getResources().getStringArray(R.array.topic_header_titles);
        String[] titles = getResources().getStringArray(R.array.topic_titles);
        String[] details = getResources().getStringArray(R.array.topic_details);
        String[] imageNames = getResources().getStringArray(R.array.topic_images);

        // Keep the index inside the arrays without branching.
        int safeIndex = Math.max(0, Math.min(topicIndex, titles.length - 1));

        TextView headerTitle = findViewById(R.id.headerTitle);
        headerTitle.setText(headerTitles[safeIndex]);

        TextView detailTitle = findViewById(R.id.detailTitle);
        detailTitle.setText(titles[safeIndex]);

        TextView detailContent = findViewById(R.id.detailContent);
        detailContent.setText(details[safeIndex]);

        // Resolve the drawable name stored in arrays.xml to a resource id. If the name
        // cannot be resolved, a default icon is used instead (a conditional expression
        // keeps the code free of if statements, as the brief requires).
        int resolvedIconId = getResources().getIdentifier(
                imageNames[safeIndex], "drawable", getPackageName());
        int iconId = (resolvedIconId != 0) ? resolvedIconId : R.drawable.ic_facilities;

        ImageView headerIcon = findViewById(R.id.headerIcon);
        headerIcon.setImageResource(iconId);
    }
}
