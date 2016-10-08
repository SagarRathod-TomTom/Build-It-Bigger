package com.sagarrathod.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sagarrathod.andlib.DisplayActivity;
import com.sagarrathod.commons.Utils;

public class MainActivity extends AppCompatActivity implements ResultCallbackListener{

    private EndpointsAsyncTask endpointsAsyncTask = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

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

    public void tellJoke(View view) {
       //Toast.makeText(this, Jokes.getFirstJoke(), Toast.LENGTH_SHORT).show();

        endpointsAsyncTask = new EndpointsAsyncTask(this);
        endpointsAsyncTask.execute("joke");
    }

    @Override
    public void resultCallback(String response) {

        Intent intent = new Intent(this, DisplayActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(Utils.INTENT_JOKE_EXTRA, response);
        startActivity(intent);
    }
}
