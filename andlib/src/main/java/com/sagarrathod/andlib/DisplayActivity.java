package com.sagarrathod.andlib;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
}

