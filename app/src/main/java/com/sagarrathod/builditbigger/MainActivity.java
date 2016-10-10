package com.sagarrathod.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.sagarrathod.andlib.DisplayActivity;
import com.sagarrathod.commons.Utils;

/**
 *  @author Sagar Rathod
 *  @version 1.0
 *
 *  Build it bigger app starter activity.
 *
 */
public class MainActivity extends AppCompatActivity implements FragmentCallback,
        ResultCallbackListener{

    private EndpointsAsyncTask mEndpointsAsyncTask;
    private MainActivityFragment mMainActivityFragment;

    /**
     * Inflates the layout and initializes the fragment instance.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        mMainActivityFragment = (MainActivityFragment)
                fragmentManager.findFragmentById(R.id.fragment);

    }

    /**
     * Registers the fragment callback.
     */
    @Override
    protected void onStart() {
        super.onStart();

        if(mMainActivityFragment != null){
            mMainActivityFragment.setFragmentCallback(this);
        }
    }

    /**
     * Inflates menu layout.
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Handles the menu item events.
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Starts the display activity to show joke received from
     * google cloud endpoint.
     *
     * @param response
     */
    @Override
    public void resultCallback(String response) {

        Intent intent = new Intent(this, DisplayActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(Utils.INTENT_JOKE_EXTRA, response);
        startActivity(intent);
    }

    /**
     * Creates the endpoint async task to fetch random joke
     * from google cloud endpoint.
     */
    @Override
    public void fragmentCallback() {
        mEndpointsAsyncTask = new EndpointsAsyncTask(this, mMainActivityFragment.mProgressBar);
        mEndpointsAsyncTask.execute("joke");
    }
}
