package com.clintonmedbery.counter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    public int counter = 0;
    public TextView counterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterText = (TextView) findViewById(R.id.count);
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

    public void onSaveInstanceState(Bundle outState){
        outState.putInt("count", counter);
        super.onSaveInstanceState(outState);
    }

    public void onRestoreInstanceState(Bundle savedBundle){
        super.onRestoreInstanceState(savedBundle);
        counter = savedBundle.getInt("count");
        counterText.setText(Integer.toString(counter));
    }


    public void clearCounter(View view){
        TextView counterText = (TextView) findViewById(R.id.count);
        counterText.setText(Integer.toString(0));
        counter = 0;
    }

    public void addOne(View view){
        counter = counter + 1;
        counterText.setText(Integer.toString(counter));

    }
}
