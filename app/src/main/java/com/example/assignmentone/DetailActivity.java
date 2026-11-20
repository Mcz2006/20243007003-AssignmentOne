package com.example.assignmentone;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Detail screen of CampusLife.
 *
 * <p>The topic to show is passed in by MainActivity with an explicit Intent extra
 * ({@link #EXTRA_TOPIC_INDEX}); this activity is still showing the place-saver text
 * until the arrays are wired up in Part H.</p>
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
    }
}
