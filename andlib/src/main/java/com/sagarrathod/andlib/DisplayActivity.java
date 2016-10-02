package com.sagarrathod.andlib;

import android.content.Intent;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.sagarrathod.commons.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Sagar Rathod
 * @version 1.0
 *
 */
public class DisplayActivity extends AppCompatActivity {

    @BindView(R2.id.jokes_text_view)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        ButterKnife.bind(this);

        //initialize the view
        init(getIntent());
    }

    /**
     * Initializes the view with intent data
     * @param intent
     */
    private void init(Intent intent){
        if(intent != null) {

            String joke = intent.getStringExtra(Utils.INTENT_JOKE_EXTRA);
            textView.setText(joke);
        }
    }

    /**
     *  Intent handler callback
     * @param intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        init(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

